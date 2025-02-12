package ru.job4j.tracker;

import lombok.Data;
import ru.job4j.toone.User;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    private LocalDateTime created = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

    @ManyToMany(fetch = FetchType.EAGER)
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

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name,  LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }
}