package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output output;

    public FindByNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "�������� ������ �� �����";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== ����� ������ �� ����� ===");
        String name = input.askStr("������� ���: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("������ � ������: " + name + " �� �������.");
        }
        return true;
    }
}
