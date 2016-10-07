package ru.spb.nkurasov.tester.serialization;

/**
 * Created by Nikita on 05.10.2016.
 */
public interface Serializer {

    void serialize(Object obj, String outputFile) throws Exception;

    <T> T deserialize(String inputFile, Class<T> cls) throws Exception;

}
