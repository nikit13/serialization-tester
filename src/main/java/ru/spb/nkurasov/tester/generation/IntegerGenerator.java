package ru.spb.nkurasov.tester.generation;

import java.util.Random;

/**
 * Created by Nikita on 04.10.2016.
 */
public class IntegerGenerator extends RandomGenerator<Integer> {

    @Override
    protected Integer nextFromRandom(Random random) {
        return random.nextInt();
    }
}
