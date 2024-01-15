package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete an Item.";
    }

    @Override
    public boolean execute(Input input, Store tracker) {

        out.println("=== Delete item ===");
        int id = input.askInt("Please enter item's id: ");
        tracker.delete(id);
        return true;
    }
}
