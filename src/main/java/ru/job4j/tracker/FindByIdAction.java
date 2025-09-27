package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output output;

    public FindByIdAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "�������� ������ �� id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== ����� ������ �� id ===");
        int id = input.askInt("������� id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
            output.println("������ � ��������� id: " + id + " �� �������.");
        }
        return true;
    }
}
