package ru.spb.nkurasov.tester.serialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Nikita on 05.10.2016.
 */
@ContextConfiguration("classpath:context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SerializerTest {

    private static final Logger log = LoggerFactory.getLogger(SerializerTest.class);

    @Autowired
    @Qualifier("javaSerializer")
    private JavaSerializer javaSerializer;

    @Autowired
    @Qualifier("kryoSerializer")
    private KryoSerializer kryoSerializer;

    @Autowired
    @Qualifier("kryoUnsafeSerializer")
    private KryoUnsafeSerializer kryoUnsafeSerializer;

    @Autowired
    @Qualifier("kryoUnsafeMemorySerializer")
    private KryoUnsafeMemorySerializer kryoUnsafeMemorySerializer;

    @Autowired
    @Qualifier("meta")
    private Meta meta;

    @Test
    public void testJavaSerializer() throws Exception {
        String fileName = "meta.obj";
        javaSerializer.serialize(meta, fileName);
        javaSerializer.deserialize(fileName, Meta.class);
    }

    @Test
    public void testKryoSerializer() throws Exception {
        String fileName = "meta.kryo";
        kryoSerializer.serialize(meta, fileName);
        kryoSerializer.deserialize(fileName, Meta.class);
    }

    @Test
    public void testKryoUnsafeSerializer() throws Exception {
        String fileName = "meta.unsafe.kryo";
        kryoUnsafeSerializer.serialize(meta, fileName);
        kryoUnsafeSerializer.deserialize(fileName, Meta.class);
    }

    @Test
    public void testKryoUnsafeMemorySerializer() throws Exception {
        String fileName = "meta.unsafe.memory.kryo";
        kryoUnsafeMemorySerializer.serialize(meta, fileName);
        kryoUnsafeMemorySerializer.deserialize(fileName, Meta.class);
    }
}
