package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeMemoryInput;
import com.esotericsoftware.kryo.io.UnsafeMemoryOutput;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author nkurasov
 */
public class KryoUnsafeMemorySerializer extends AbstractKryoSerializer {

    public KryoUnsafeMemorySerializer() {
        super(KryoUnsafeMemorySerializer.class);
    }

    @Override
    protected Output newOutput(OutputStream out) {
        return new UnsafeMemoryOutput(out);
    }

    @Override
    protected Input newInput(InputStream in) {
        return new UnsafeMemoryInput(in);
    }
}

