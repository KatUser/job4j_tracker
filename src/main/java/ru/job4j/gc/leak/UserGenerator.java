package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class UserGenerator implements Generate {

    public final String pathNames = "src/main/java/ru/job4j/gc/leak/files/names.txt";
    public final String pathSurnames = "src/main/java/ru/job4j/gc/leak/files/surnames.txt";
    public final String pathPatrons = "src/main/java/ru/job4j/gc/leak/files/patr.txt";
    public final String separator = " ";
    public final int newUsers = 1000;

    public List<String> names;
    public List<String> surnames;
    public List<String> patrons;
    private List<User> users = new LinkedList<>();
    private Random random;

    public UserGenerator(Random random) {
        this.random = random;
        readAll();
    }

    @Override
    public void generate() {
        users.clear();
        for (int i = 0; i < newUsers; i++) {
            /* bad practice - concatenation, creates a new Obj each time you use +
            users.add(new User(
                    surnames.get(random.nextInt(surnames.size())) + separator
                            + names.get(random.nextInt(names.size())) + separator
                            + patrons.get(random.nextInt(patrons.size()))));
             */
            users.add(new User(String.join(surnames.get(random.nextInt(surnames.size())),
                    separator,
                    names.get(random.nextInt(names.size())),
                    separator,
                    patrons.get(random.nextInt(patrons.size())))));
        }
    }

    private void readAll() {
        try {
            names = read(pathNames);
            surnames = read(pathSurnames);
            patrons = read(pathPatrons);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public User randomUser() {
        return users.get(random.nextInt(users.size()));
    }

    public List<User> getUsers() {
        return users;
    }
}