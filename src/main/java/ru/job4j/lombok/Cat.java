package ru.job4j.lombok;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@Builder
public class Cat {
    private int age;
    private String name;

    @Singular("interests")
    private List<String> interests;

    @Singular("legs")
    private List<Integer> legs;
}
