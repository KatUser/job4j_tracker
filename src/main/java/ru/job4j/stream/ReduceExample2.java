package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceExample2 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        Optional<Integer> sum = nums.stream()
                .reduce((a, b) -> a + b);
        System.out.println(sum.get());
    }
}