package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.tracker.HbmTracker.deleteAllItems;

public class HbmTrackerTest {

    @BeforeEach
    void cleanData() {
        deleteAllItems();
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("test1");
            tracker.add(item);
            var result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenItemIsDeletedThenThereIsNoItem() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            assertThat(tracker.findAll()).isEmpty();
        }
    }

    @Test
    public void whenItemIsReplacedThenReceiveTrue() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            var item2 = new Item();
            item1.setName("testItem1");
            item1.setCreated(LocalDateTime.now());
            item2.setName("testItem2");
            item2.setCreated(LocalDateTime.now());
            tracker.add(item1);
            var result = tracker.replace(item1.getId(), item2);
            assertThat(result).isTrue();
        }
    }

    @Test
    public void whenAddTwoItemsThenReceiveTwoItems() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            var item2 = new Item();
            item1.setName("testItem1");
            item2.setName("testItem2");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findAll()).usingRecursiveComparison()
                    .isEqualTo(List.of(item1, item2)
            );

        }
    }

    @Test
    public void whenAddItemThenCanFindItByName() {
        try (var tracker = new HbmTracker()) {
            var item1 = new Item();
            item1.setName("testItem");
            tracker.add(item1);
            assertThat(tracker.findByName(item1.getName())).isNotNull();
        }
    }

    @Test
    public void whenAddItemThenCanFindItById() {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            item1.setName("testItem");
            tracker.add(item1);
            assertThat(tracker.findById(item1.getId())).usingRecursiveComparison()
                    .isEqualTo(item1);
        }
    }

    @Test
    public void whenFailToReplaceItemThenReceiveFalse() {
        try (var tracker = new HbmTracker()) {
            var item = new Item();
            item.setName("testItem");
            var res = tracker.replace(1, item);
            assertThat(res).isFalse();
        }
    }
}