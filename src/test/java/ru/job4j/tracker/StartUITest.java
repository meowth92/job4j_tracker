package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.action.*;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[] {"0", String.valueOf(item.getId()),  "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "����:" + System.lineSeparator()
                        + "0. ��������� ���������" + System.lineSeparator()
                        + "=== ���������� ��������� ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "����:" + ln
                        + "0. �������� ������" + ln
                        + "1. ��������� ���������" + ln
                        + "=== �������������� ������ ===" + ln
                        + "������ �������� �������." + ln
                        + "����:" + ln
                        + "0. �������� ������" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ���������� ��������� ===" + ln
        );
    }

    @Test
    void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "����:" + ln
                        + "0. �������� ��� ������" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ����� ���� ������ ===" + ln
                        + one + ln
                        + "����:" + ln
                        + "0. �������� ��� ������" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ���������� ��������� ===" + ln
        );
    }

    @Test
    void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[] {"0", one.getName(), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "����:" + ln
                        + "0. �������� ������ �� �����" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ����� ������ �� ����� ===" + ln
                        + one + ln
                        + "����:" + ln
                        + "0. �������� ������ �� �����" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ���������� ��������� ===" + ln
        );
    }

    @Test
    void whenFindByIdAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "����:" + ln
                        + "0. �������� ������ �� id" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ����� ������ �� id ===" + ln
                        + one + ln
                        + "����:" + ln
                        + "0. �������� ������ �� id" + ln
                        + "1. ��������� ���������" + ln
                        + "=== ���������� ��������� ===" + ln
        );
    }
}