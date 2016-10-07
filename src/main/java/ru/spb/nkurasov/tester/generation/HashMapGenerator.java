package ru.spb.nkurasov.tester.generation;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Nikita on 04.10.2016.
 */
public class HashMapGenerator<K, V> implements ValueGenerator<HashMap<K, V>> {

    private Random r = new Random();

    private ValueGenerator<K> keyGenerator;

    private ValueGenerator<V> valueGenerator;

    private int minSize = Integer.MIN_VALUE;

    private int maxSize = Integer.MAX_VALUE;

    @Override
    public HashMap<K, V> next() {
        int size = r.nextInt(maxSize - minSize) + minSize;
        HashMap<K, V> map = Maps.newHashMap();
        while (map.size() < size) {
            K nextKey;
            do {
                nextKey = keyGenerator.next();
            } while(map.containsKey(nextKey));
            map.put(nextKey, valueGenerator.next());
        }
        return map;
    }

    public ValueGenerator<K> getKeyGenerator() {
        return keyGenerator;
    }

    public void setKeyGenerator(ValueGenerator<K> keyGenerator) {
        this.keyGenerator = keyGenerator;
    }

    public ValueGenerator<V> getValueGenerator() {
        return valueGenerator;
    }

    public void setValueGenerator(ValueGenerator<V> valueGenerator) {
        this.valueGenerator = valueGenerator;
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
