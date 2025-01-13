package ru.job4j.tracker;

import lombok.Data;
import ru.job4j.toone.User;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDateTime created = LocalDateTime.now().withNano(0);

    @ManyToMany
    @JoinTable(
            name = "participates", /* тут связь вторичных ключей */
            joinColumns = { @JoinColumn(name = "item_id") }, /* Определяет ключ родительского объекта = Item.id */
            inverseJoinColumns = { @JoinColumn(name = "user_id") } /* определяет ключ объекта, который мы загружаем в родительский объект. */
    )
    private List<User> participates = new ArrayList<>();

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