package ru.lokyanvs;

import java.util.Comparator;

public class MyComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o, T t1) {
        return t1.compareTo(o);
    }
}
