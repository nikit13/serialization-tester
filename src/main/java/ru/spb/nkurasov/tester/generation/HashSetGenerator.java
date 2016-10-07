package ru.spb.nkurasov.tester.generation;

import java.util.HashSet;

public class HashSetGenerator<T> extends CollectionGenerator<T, HashSet<T>> {

    @Override
    protected HashSet<T> newInstance() {
        return new HashSet<>();
    }
}
