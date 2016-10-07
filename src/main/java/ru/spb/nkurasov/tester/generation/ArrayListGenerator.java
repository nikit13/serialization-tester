package ru.spb.nkurasov.tester.generation;

import java.util.ArrayList;

/**
 * Created by Nikita on 04.10.2016.
 */
public class ArrayListGenerator<T> extends CollectionGenerator<T, ArrayList<T>> {

    @Override
    protected ArrayList<T> newInstance() {
        return new ArrayList<>();
    }
}
