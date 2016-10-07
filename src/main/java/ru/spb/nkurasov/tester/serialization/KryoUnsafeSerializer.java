package ru.spb.nkurasov.tester.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.UnsafeInput;
import com.esotericsoftware.kryo.io.UnsafeOutput;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author nkurasov
 */
public class KryoUnsafeSerializer extends AbstractKryoSerializer {

    public KryoUnsafeSerializer() {
        super(KryoUnsafeSerializer.class);
    }

    @Override
    protected Output newOutput(OutputStream out) {
        return new UnsafeOutput(out);
    }

    @Override
    protected Input newInput(InputStream in) {
        return new UnsafeInput(in);
    }
}