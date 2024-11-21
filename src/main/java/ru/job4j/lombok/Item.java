package ru.job4j.lombok;

import lombok.*;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Item {
    @Getter
    @Setter
    private int id;
    @EqualsAndHashCode.Include
    @NonNull
    private String name;
}