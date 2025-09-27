package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "�������� ������";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== �������������� ������ ===");
        int id = input.askInt("������� id: ");
        String name = input.askStr("������� ���: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("������ �������� �������.");
        } else {
            output.println("������ ������ ������.");
        }
        return true;
    }
}
