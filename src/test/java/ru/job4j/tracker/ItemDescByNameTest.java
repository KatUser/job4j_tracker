package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenSortDescendingOrder() {
        var nowDate = LocalDateTime.now();
        List<Item> item = new ArrayList<>(List.of(
                new Item("Third", 3, nowDate),
                new Item("Fourth", 4, nowDate),
                new Item("First", 1, nowDate),
                new Item("Second", 2, nowDate)
        ));

        List<Item> expected = new ArrayList<>(List.of(
                new Item("Third", 3, nowDate),
                new Item("Second", 2, nowDate),
                new Item("Fourth", 4, nowDate),
                new Item("First", 1, nowDate)
        ));
        item.sort(new ItemDescByName());

        assertEquals(item, expected);
    }
}
