package ru.spb.nkurasov.tester.generation;

/**
 * @author nkurasov
 */
public class IntArrayGenerator extends AbstractArrayGenerator<int[]> {

    @Override
    public int[] next() {
        return new int[computeSize()];
    }
}
