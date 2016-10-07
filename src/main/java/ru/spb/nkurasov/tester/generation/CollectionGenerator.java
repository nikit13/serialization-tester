package ru.spb.nkurasov.tester.generation;

import java.util.Collection;
import java.util.Random;

/**
 * Created by Nikita on 04.10.2016.
 */
public abstract class CollectionGenerator<T, V extends Collection<T>> implements ValueGenerator<V> {
    private final Random r = new Random(System.nanoTime());

    private ValueGenerator<T> elementGenerator;

    private int minSize = Integer.MIN_VALUE;

    private int maxSize = Integer.MAX_VALUE;

    public V next() {
        int size = r.nextInt(maxSize - minSize) + minSize;
        V result = newInstance();
        while (result.size() < size) {
            result.add(elementGenerator.next());
        }
        return result;
    }

    protected abstract V newInstance();

    public ValueGenerator<T> getElementGenerator() {
        return elementGenerator;
    }

    public void setElementGenerator(ValueGenerator<T> elementGenerator) {
        this.elementGenerator = elementGenerator;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
