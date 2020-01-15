package ru.lokyanvs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountMapIml<T> implements CountMap<T> {

    private HashMap<T, Integer> container = new HashMap<>();

    @Override
    public void add(T o) {
        if (container.containsKey(o)) container.put(o, container.get(o) + 1);
        else container.put(o, 1);
    }

    @Override
    public int getCount(T o) {
        return container.getOrDefault(o, 0);
    }

    @Override
    public int remove(T o) {
        if (container.containsKey(o)) return container.remove(o);
        else return 0;
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        Map<T, Integer> map = source.toMap();
        for (Map.Entry<T, Integer> element : map.entrySet()) {
            if (container.containsKey(element.getKey()))
                container.put(element.getKey(), container.get(element.getKey()) + element.getValue());
            else container.put(element.getKey(), element.getValue());
        }
    }

    @Override
    public Map<T, Integer> toMap() {
        return container;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        Set<T> keySets = container.keySet();
        for (T element : keySets) {
            if (destination.containsKey(element))
                destination.put(element, destination.get(element) + container.get(element));
            else destination.put(element, container.get(element));
        }
    }

    @Override
    public String toString() {
        return container.toString();
    }
}
