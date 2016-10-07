package ru.spb.nkurasov.tester.generation;

import java.util.Random;

/**
 * @author nkurasov
 */
public abstract class RandomGenerator<T> implements ValueGenerator<T> {

    private final Random r = new Random();

    public T next() {
        return nextFromRandom(r);
    }

    protected abstract T nextFromRandom(Random random);
}
