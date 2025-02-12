package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void whenSortAscendingOrder() {
        List<Item> item = new ArrayList<>(List.of(
                new Item(3, "Third"),
                new Item(4, "Fourth"),
                new Item(1, "First"),
                new Item(2, "Second")
        ));

        List<Item> expected = new ArrayList<>(List.of(
                new Item(1, "First"),
                new Item(4, "Fourth"),
                new Item(2, "Second"),
                new Item(3, "Third")

        ));
        item.sort(new ItemAscByName());
        assertEquals(item, expected);
    }
}
