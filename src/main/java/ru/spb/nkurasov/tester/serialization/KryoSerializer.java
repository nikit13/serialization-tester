package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author nkurasov
 */
public class KryoSerializer extends AbstractKryoSerializer {

    public KryoSerializer() {
        super(KryoSerializer.class);
    }

    @Override
    protected Output newOutput(OutputStream out) {
        return new Output(out);
    }

    @Override
    protected Input newInput(InputStream in) {
        return new Input(in);
    }
}
