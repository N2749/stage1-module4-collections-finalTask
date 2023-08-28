package com.epam.mjc.collections.combined;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        Map<Integer, Set<String>> result = new HashMap<>();
        sourceMap.keySet().forEach(s -> {
            Set<String> entry = result.getOrDefault(s.length(), new HashSet<>());
            entry.add(s);
            result.put(s.length(), entry);
        });
        return result;
    }

    public static void main(String[] args) {
        MapFromKeysCreator main = new MapFromKeysCreator();
        main.createMap(
                Map.of("Monday", 1,
                        "Tuesday", 2,
                        "Wednesday", 3,
                        "Thursday", 4,
                        "Friday", 5)).forEach((integer, strings) -> {
            System.out.println(integer);
            strings.forEach(System.out::println);
        });

//                Map.of(6, Set.of("Monday", "Friday"),
//                        7, Set.of("Tuesday"),
//                        8, Set.of("Thursday"),
//                        9, Set.of("Wednesday"));
    }
}
