package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.output.Output;
import ru.job4j.tracker.*;

public class CreateAction implements UserAction {
    private final Output output;

    public CreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "�������� ����� ������";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== �������� ����� ������ ===");
        String name = input.askStr("������� ���: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("����������� ������: " + item);
        return true;
    }
}
