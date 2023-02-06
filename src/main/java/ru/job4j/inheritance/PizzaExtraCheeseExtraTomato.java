package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String TOPPING = "extra tomato";

    @Override
    public String name() {
        return super.name() + " + " + TOPPING;
    }
}
