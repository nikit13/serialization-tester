package ru.spb.nkurasov.tester.serialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Nikita on 05.10.2016.
 */
@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SerializerTest {

    @Autowired
    private JavaSerializer javaSerializer;

    @Autowired
    private KryoSerializer kryoSerializer;

    @Autowired
    private KryoUnsafeSerializer kryoUnsafeSerializer;

    @Autowired
    private KryoUnsafeMemorySerializer kryoUnsafeMemorySerializer;

    @Autowired
    private Meta meta;

    @Test
    public void testJavaSerializer() throws Exception {
        String fileName = "meta.obj";
        javaSerializer.serialize(meta, new FileOutputStream(fileName));
        javaSerializer.deserialize(new FileInputStream(fileName), Meta.class);
    }

    @Test
    public void testKryoSerializer() throws Exception {
        String fileName = "meta.kryo";
        kryoSerializer.serialize(meta, new FileOutputStream(fileName));
        kryoSerializer.deserialize(new FileInputStream(fileName), Meta.class);
    }

    @Test
    public void testKryoUnsafeSerializer() throws Exception {
        String fileName = "meta.unsafe.kryo";
        kryoUnsafeSerializer.serialize(meta, new FileOutputStream(fileName));
        kryoUnsafeSerializer.deserialize(new FileInputStream(fileName), Meta.class);
    }

    @Test
    public void testKryoUnsafeMemorySerializer() throws Exception {
        String fileName = "meta.unsafe.memory.kryo";
        kryoUnsafeMemorySerializer.serialize(meta, new FileOutputStream(fileName));
        kryoUnsafeMemorySerializer.deserialize(new FileInputStream(fileName), Meta.class);
    }
}
