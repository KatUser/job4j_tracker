package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SupplierAndBiConsumerTry2 {
    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = sup.get();
        int i = 1;
        for (String s: strings) {
            consumer.accept(i++, " is " + s);
        }
    }
}
