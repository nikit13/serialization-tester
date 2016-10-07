package ru.spb.nkurasov.tester.serialization;

import com.google.common.collect.Maps;
import ru.spb.nkurasov.tester.generation.GeneratedValue;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by Nikita on 04.10.2016.
 */
public class Meta implements Serializable {

    @GeneratedValue(generator = "mapGen")
    private Map<String, Set<Long>> longs = Maps.newHashMap();

    @GeneratedValue(generator = "longMapGen")
    private  Map<String, Map<String, Set<Long>>> longs2 = Maps.newHashMap();

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
}
