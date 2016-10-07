package ru.spb.nkurasov.tester.generation;

import java.util.Random;

/**
 * Created by Nikita on 04.10.2016.
 */
public abstract class RandomGenerator<T> implements ValueGenerator<T> {

    private final Random r = new Random();

    public T next() {
        return nextFromRandom(r);
    }

    protected abstract T nextFromRandom(Random random);
}
