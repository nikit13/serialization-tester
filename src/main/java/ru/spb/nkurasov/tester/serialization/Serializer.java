package ru.spb.nkurasov.tester.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class provides serialization and deserialization objects
 *
 * @author nkurasov
 */
public interface Serializer {

    /**
     * Serialize the given object and write result into output stream
     *
     * @param obj    object for serialization
     * @param output the stream, in which the result will be written
     * @throws IOException          if an error occured while writing results to output
     * @throws NullPointerException if at least one argument is {@code null}
     */
    void serialize(Object obj, OutputStream output) throws IOException;

    /**
     * Deserializes and constructs object of the given type
     *
     * @param input stream, from which the result will be read
     * @param cls   expected type of deserialized object. If not, the method will throw {@link ClassCastException}
     * @param <T>   expected type of deserialized object
     * @return deserialized object
     * @throws IOException          if an error occured while reading data from input
     * @throws ClassCastException   if deserialized object is not an instance of the given class
     * @throws NullPointerException if at least one argument is {@code null}
     */
    <T> T deserialize(InputStream input, Class<T> cls) throws IOException;

}
