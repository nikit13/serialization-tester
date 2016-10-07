package ru.spb.nkurasov.tester.generation;

import java.util.ArrayList;

/**
 * @author nkurasov
 */
public class ArrayListGenerator<T> extends CollectionGenerator<T, ArrayList<T>> {

    @Override
    protected ArrayList<T> newInstance() {
        return new ArrayList<>();
    }
}
