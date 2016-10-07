package ru.spb.nkurasov.tester.generation;

import java.util.Random;

/**
 * Created by Nikita on 04.10.2016.
 */
public class StringGenerator extends RandomGenerator<String> {

    @Override
    public String nextFromRandom(Random random) {
        return Long.toHexString(random.nextLong());
    }
}
