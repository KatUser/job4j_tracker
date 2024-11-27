package ru.job4j.tracker;

import lombok.Data;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().withNano(0);

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Item(String name, int id, LocalDateTime created) {
        this.name = name;
        this.id = id;
        this.created = created;
    }
}