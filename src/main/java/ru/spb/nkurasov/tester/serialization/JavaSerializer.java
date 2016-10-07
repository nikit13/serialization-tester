package ru.spb.nkurasov.tester.serialization;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Nikita on 05.10.2016.
 */
public class JavaSerializer implements Serializer {

    private static final Logger log = LoggerFactory.getLogger(JavaSerializer.class);

    @Override
    public void serialize(Object obj, String outputFile) throws Exception {
        Stopwatch t = Stopwatch.createStarted();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile))) {
            out.writeObject(obj);
        } finally {
            log.info("serialized to " + outputFile + " - " + t.stop());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String inputFile, Class<T> cls) throws Exception {
        Stopwatch s = Stopwatch.createStarted();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(inputFile))) {
            return (T) in.readObject();
        } finally {
            log.info("deserialized from " + inputFile + " - " + s.stop());
        }
    }
}
