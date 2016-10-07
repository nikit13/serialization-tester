package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Provides base functionality for Kryo serialization. Subclasses must implement
 * factory methods which creates concrete serializers/deserializers
 *
 * @author nkurasov
 */
abstract class AbstractKryoSerializer implements Serializer {

    private final Logger log;

    private final Kryo kryo = new Kryo();

    AbstractKryoSerializer(Class<?> loggerClass) {
        log = LoggerFactory.getLogger(loggerClass);
    }


    @Override
    public void serialize(Object obj, OutputStream output) throws IOException {
        Stopwatch s = Stopwatch.createStarted();
        try (Output out = newOutput(output)) {
            kryo.writeObject(out, obj);
        } finally {
            log.info("serialized to - " + s.stop());
        }
    }

    @Override
    public <T> T deserialize(InputStream input, Class<T> cls) throws IOException {
        Stopwatch s = Stopwatch.createStarted();
        try (Input in = newInput(input)) {
            return kryo.readObject(in, cls);
        } finally {
            log.info("deserialized from - " + s.stop());
        }
    }

    /**
     * Creates concrete Kryo serializer
     *
     * @param out receiver for serialized object
     * @return serializer, may not be {@code null}
     */
    protected abstract Output newOutput(OutputStream out);

    /**
     * Creates concrete Kryo deserializer
     *
     * @param in source of serialized object
     * @return serializer, may not be {@code null}
     */
    protected abstract Input newInput(InputStream in);

}
