package ru.job4j.action;

import ru.job4j.input.Input;
import ru.job4j.output.Output;
import ru.job4j.tracker.*;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "�������� ��� ������";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== ����� ���� ������ ===");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("��������� ��� �� �������� ������");
        }
        return true;
    }
}
