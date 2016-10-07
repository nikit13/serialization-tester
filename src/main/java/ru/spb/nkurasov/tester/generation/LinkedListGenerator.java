package ru.spb.nkurasov.tester.generation;

import java.util.LinkedList;

/**
 * Created by Nikita on 05.10.2016.
 */
public class LinkedListGenerator<T> extends CollectionGenerator<T, LinkedList<T>> {

    @Override
    protected LinkedList<T> newInstance() {
        return new LinkedList<>();
    }
}
