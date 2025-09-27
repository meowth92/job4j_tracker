package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output output;

    public ExitAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "��������� ���������";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== ���������� ��������� ===");
        return false;
    }
}