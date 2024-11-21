package ru.job4j.lombok;

public class BuilderUsage {
    public static void main(String[] args) {
        var role = Role.of()
                .id(1)
                .name("ODMEN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);

        var bird = Bird.of()
                .age(1)
                .color("blue")
                .wingspan(2)
                .places("Alaska")
                .places("Osaka")
                .places("Siberia")
                .build();
        System.out.println(bird);

        var cat = Cat.builder()
                .age(5)
                .name("Busya")
                .interests("eat")
                .interests("sleep")
                .legs(2)
                .legs(2)
                .build();

        System.out.println(cat);

        var car = Car.builder()
                .brand("Oka")
                .year(1988)
                .characteristics("color", "red")
                .characteristics("state", "used")
                .build();
        System.out.println(car);
    }
}
