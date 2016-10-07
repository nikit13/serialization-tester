package ru.spb.nkurasov.tester.serialization;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * This is a wrapper over standard Java serialization mechanism.
 * Uses {@link ObjectOutputStream} and {@link ObjectInputStream}
 * for serialization/deserialization of objects
 *
 * @author nkurasov
 */
public class JavaSerializer implements Serializer {

    private static final Logger log = LoggerFactory.getLogger(JavaSerializer.class);

    @Override
    public void serialize(Object obj, OutputStream output) throws IOException {
        Stopwatch t = Stopwatch.createStarted();
        try (ObjectOutputStream out = new ObjectOutputStream(output)) {
            out.writeObject(obj);
        } finally {
            log.info("serialized to - " + t.stop());
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "unused"})
    public <T> T deserialize(InputStream input, Class<T> cls) throws IOException {
        Stopwatch s = Stopwatch.createStarted();
        try (ObjectInputStream in = new ObjectInputStream(input)) {
            return (T) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot read object", e);
        } finally {
            log.info("deserialized from - " + s.stop());
        }
    }
}
