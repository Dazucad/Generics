package ru.lokyanvs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapIml<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println("map после заполнения: " + map);

        HashMap<Integer, Integer> map1 = new HashMap<>() {{
            put(0, 1);
            put(1, 1);
            put(2, 1);
            put(3, 1);
            put(10, 3);
        }};

        System.out.println("map1: " + map1);

        map.toMap(map1);
        System.out.println("map1 после заполнения данными из map: " + map1);
        map.addAll(map);
        System.out.println("map после заполнения собой: " + map);
        System.out.println("Количество повторений цифры 10 в map: " + map.getCount(10));

        System.out.println("\nПроверка методов из CollectionUtils");
        List<Number> list = CollectionUtils.newArrayList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list: " + list);

        System.out.println("Индекс цифры 2 в list: " + CollectionUtils.indexOf(list, 2));
        System.out.println("массив из первых 3 элементов list: " + CollectionUtils.limit(list, 3));
        CollectionUtils.add(list, 4);
        System.out.println("Добавление в list методом CollectionUtils.add(list,4): " + list);

        List<Integer> integerList = new ArrayList<>() {{
            add(0);
            add(1);
        }};
        System.out.println("integerList: " + integerList);

        CollectionUtils.removeAll(list, integerList);
        System.out.println("list после удаления элементов, входящих в integerList: " + list);

        //восстанавливаем удаленные элементы
        list.add(0);
        list.add(1);

        System.out.println("list содержит все элементы integerList: " + CollectionUtils.containsAll(list, integerList));
        System.out.println("list содержит любую цифру {4, 1}: " + CollectionUtils.containsAny(list, new ArrayList<Integer>() {{
            add(4);
            add(1);
        }}));
        System.out.println("list содержит любую цифру {5, 6}: " + CollectionUtils.containsAny(list, new ArrayList<Integer>() {{
            add(5);
            add(6);
        }}));


        //строка ниже не работает с list<Number>, т.к. он не реализует Comparable
        //System.out.println("элементы list от 2 до 4: " + CollectionUtils.range(list, 2, 4));
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        System.out.println("integerList: " + integerList);

        System.out.println("элементы integerList от 2 до 4: " + CollectionUtils.range(integerList, 2, 4));
        System.out.println("элементы integerList через обратный компаратор: " + CollectionUtils.range(integerList, 4, 2, new MyComparator<>()));
    }
}
