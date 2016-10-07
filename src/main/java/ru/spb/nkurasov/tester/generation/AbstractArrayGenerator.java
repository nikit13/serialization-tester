package ru.spb.nkurasov.tester.generation;

import java.util.Random;

/**
 * @author nkurasov
 */
abstract class AbstractArrayGenerator<T> implements ValueGenerator<T> {

    private Random r = new Random();

    private int minLength = 0;

    private int maxLength = Integer.MAX_VALUE;

    protected int computeSize() {
        return r.nextInt(maxLength - minLength) + minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
