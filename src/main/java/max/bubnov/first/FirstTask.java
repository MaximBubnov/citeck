package max.bubnov.first;

import java.util.*;

/**
 * 1. имеется массив чисел, получить список вида {число, количество вхождений числа в массив}, список
 * должен быть отсортирован по количеству вхождений, внутри по возрастания числа. Использовать
 * можно любой алгоритмический язык.
 */
public class FirstTask {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 8, 9, 1, 6, 2, 44, 45, 74, 8, 1, 3, 7 ,5};

        TreeMap<Integer, Integer> map = new TreeMap<>();

        //найдем количество вхождений, отсортированных по возрастанию ключа (числа)
        for (Integer i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        //сортируем мапу по значению (количеству вхождений)
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>((map.entrySet()));
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
