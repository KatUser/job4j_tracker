package ru.job4j.tracker;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all Items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all Items ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("The storage has no items.");
        }
        return true;
    }
}
