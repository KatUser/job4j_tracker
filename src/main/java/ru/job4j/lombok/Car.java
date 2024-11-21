package ru.job4j.lombok;

import lombok.*;

import java.util.Map;

@ToString
@Setter
@Getter
@Builder
public class Car {
    private String brand;
    private int year;
    @Singular("characteristics")
    private Map<String, String> characteristics;
}
