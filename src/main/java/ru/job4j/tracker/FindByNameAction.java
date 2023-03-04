package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Look up by item's name ===");
        String name = input.askStr("Please enter item's name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Items" + " with name " + name + " are not found.");
        }
        return true;
    }
}
