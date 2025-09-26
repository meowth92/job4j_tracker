package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("�������: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            }  else if (select == 2) {
                replaceItem(input, tracker);
            }  else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "�������� ����� ������", "�������� ��� ������", "�������� ������",
                "������� ������", "�������� ������ �� id", "�������� ������ �� �����",
                "��������� ���������"
        };
        System.out.println("����:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== ����� ������ �� ����� ===");
        String name = input.askStr("������� ���: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("������ � ������: " + name + " �� �������.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== ����� ������ �� id ===");
        int id = input.askInt("������� id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("������ � ��������� id: " + id + " �� �������.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== �������� ������ ===");
        int id = input.askInt("������� id: ");
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "������ ������� �������." : "������ �������� ������.");
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== �������������� ������ ===");
        int id = input.askInt("������� id: ");
        String name = input.askStr("������� ���: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("������ �������� �������.");
        } else {
            System.out.println("������ ������ ������.");
        }
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== ����� ���� ������ ===");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("��������� ��� �� �������� ������");
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== �������� ����� ������ ===");
        String name = input.askStr("������� ���: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("����������� ������: " + item);
    }

}