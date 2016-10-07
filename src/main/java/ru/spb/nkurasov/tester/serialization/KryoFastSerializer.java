package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.io.FastInput;
import com.esotericsoftware.kryo.io.FastOutput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author nkurasov
 */
public class KryoFastSerializer extends AbstractKryoSerializer {

    public KryoFastSerializer() {
        super(KryoFastSerializer.class);
    }

    @Override
    protected Output newOutput(OutputStream out) {
        return new FastOutput(out);
    }

    @Override
    protected Input newInput(InputStream in) {
        return new FastInput(in);
    }
}
