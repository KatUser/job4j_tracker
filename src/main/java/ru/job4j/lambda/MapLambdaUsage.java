package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
