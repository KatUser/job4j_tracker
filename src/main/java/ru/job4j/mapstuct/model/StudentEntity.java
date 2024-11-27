package ru.job4j.mapstuct.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentEntity {
    private int id;
    private String name;
    private String classVal;
}