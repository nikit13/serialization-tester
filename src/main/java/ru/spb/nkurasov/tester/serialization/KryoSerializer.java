package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Nikita on 05.10.2016.
 */
public class KryoSerializer implements Serializer {

    private static final Logger log = LoggerFactory.getLogger(KryoSerializer.class);

    private Kryo kryo = new Kryo();

    @Override
    public void serialize(Object obj, String outputFile) throws Exception {
        Stopwatch s = Stopwatch.createStarted();
        try (Output out = new Output(new FileOutputStream(outputFile))) {
            kryo.writeObject(out, obj);
        } finally {
            log.info("serialized to " + outputFile + " - " + s.stop());
        }
    }

    @Override
    public <T> T deserialize(String inputFile, Class<T> cls) throws Exception {
        Stopwatch s = Stopwatch.createStarted();
        try (Input in = new Input(new FileInputStream(inputFile))) {
            return kryo.readObject(in, cls);
        } finally {
            log.info("deserialized from " + inputFile + " - " + s.stop());
        }
    }
}