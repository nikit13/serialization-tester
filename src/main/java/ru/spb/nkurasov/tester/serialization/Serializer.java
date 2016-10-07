package ru.spb.nkurasov.tester.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author nkurasov
 */
public interface Serializer {

    void serialize(Object obj, OutputStream output) throws IOException;

    <T> T deserialize(InputStream input, Class<T> cls) throws IOException;

}
