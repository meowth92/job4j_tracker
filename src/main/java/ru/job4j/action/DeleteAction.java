package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.output.Output;
import ru.job4j.tracker.*;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "������� ������";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== �������� ������ ===");
        int id = input.askInt("������� id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        output.println(item != null ? "������ ������� �������." : "������ �������� ������.");
        return true;
    }
}
