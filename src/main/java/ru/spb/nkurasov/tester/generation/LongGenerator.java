package ru.spb.nkurasov.tester.generation;

import java.util.Random;

public class LongGenerator extends RandomGenerator<Long> {

    protected Long nextFromRandom(Random random) {
        return random.nextLong();
    }
}
