package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.google.common.base.Stopwatch;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.spb.nkurasov.tester.generation.HashMapGenerator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

@ContextConfiguration(locations = "classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SerializationTest {

    @Autowired
    @Qualifier("longMapGen")
    private HashMapGenerator<String, Map<String, Set<Long>>> longMapGen;

    @Autowired
    @Qualifier("mapGen")
    private HashMapGenerator<String, Set<Long>> mapGen;

    @Test
    public void serialize() throws Exception {
        Meta meta = new Meta();

        Stopwatch t = Stopwatch.createStarted();
        meta.setLongs(mapGen.next());
        meta.setLongs2(longMapGen.next());
        System.out.println("generation time - " + t.stop());

        System.out.println("object size - " + ObjectSizeCalculator.getObjectSize(meta));

        t = Stopwatch.createStarted();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("meta.obj"))) {
            out.writeObject(meta);
        }
        System.out.println("serialization - " + t.stop());
    }

    @Test
    public void deserialize() throws Exception {
        Stopwatch t = Stopwatch.createStarted();
        Meta meta;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("meta.obj"))) {
            meta = (Meta) in.readObject();
        }
        System.out.println("deserialization - " + t.stop());
        System.out.println("object size - " + ObjectSizeCalculator.getObjectSize(meta));
    }

    @Test
    public void serializeUsingKryo() throws Exception {
        Stopwatch t = Stopwatch.createStarted();
        Meta meta;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("meta.obj"))) {
            meta = (Meta) in.readObject();
        }
        System.out.println("deserialization - " + t.stop());

        Kryo kryo = new Kryo();

        t = Stopwatch.createStarted();
        try (Output output = new Output(new FileOutputStream("meta.kryo"))) {
            kryo.writeObject(output, meta);
        }
        System.out.println("serialization - " + t.stop());
    }

    @Test
    public void deserializeUsingKryo() throws Exception {
        Kryo kryo = new Kryo();

        Stopwatch t = Stopwatch.createStarted();
        Meta meta;
        try (Input input = new Input(new FileInputStream("meta.kryo"))) {
            meta = kryo.readObject(input, Meta.class);
        }
        System.out.println("deserialization - " + t.stop());
        System.out.println("object size - " + ObjectSizeCalculator.getObjectSize(meta));
    }

    @Test
    public void serializeUsingKryoUnsafe() throws Exception {
        Kryo kryo = new Kryo();

        Stopwatch t = Stopwatch.createStarted();
        Meta meta;
        try (Input input = new Input(new FileInputStream("meta.kryo"))) {
            meta = kryo.readObject(input, Meta.class);
        }
        System.out.println("deserialization - " + t.stop());

        t = Stopwatch.createStarted();
        try (Output output = new UnsafeOutput(new FileOutputStream("meta.bin.kryo"))) {
            kryo.writeObject(output, meta);
        }
        System.out.println("serialization - " + t.stop());
    }

    @Test
    public void deserializeUsingKryoUnsafe() throws Exception {
        Kryo kryo = new Kryo();

        Stopwatch t = Stopwatch.createStarted();
        try (Input input = new UnsafeInput(new FileInputStream("meta.bin.kryo"))) {
            kryo.readObject(input, Meta.class);
        }
        System.out.println("deserialization - " + t.stop());
    }
}
