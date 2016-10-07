package ru.spb.nkurasov.tester.serialization;

import com.google.common.collect.Maps;
import ru.spb.nkurasov.tester.generation.GeneratedValue;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * @author nkurasov
 */
public class Meta implements Serializable {

    @GeneratedValue(generator = "mapGen")
    private Map<String, Set<Long>> longs = Maps.newHashMap();

    @GeneratedValue(generator = "longMapGen")
    private Map<String, Map<String, Set<Long>>> longs2 = Maps.newHashMap();

    private Map<String, Map<String, Map<String, Set<int[]>>>> veryBigMap = Maps.newHashMap();

    public Map<String, Map<String, Set<Long>>> getLongs2() {
        return longs2;
    }

    public void setLongs2(Map<String, Map<String, Set<Long>>> longs2) {
        this.longs2 = longs2;
    }

    public Map<String, Set<Long>> getLongs() {
        return longs;
    }

    public void setLongs(Map<String, Set<Long>> longs) {
        this.longs = longs;
    }

    public Map<String, Map<String, Map<String, Set<int[]>>>> getVeryBigMap() {
        return veryBigMap;
    }

    public void setVeryBigMap(Map<String, Map<String, Map<String, Set<int[]>>>> veryBigMap) {
        this.veryBigMap = veryBigMap;
    }
}
