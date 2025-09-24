package ru.job4j.tracker;


import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        int sizeRes = 0;
        Item[] result = new Item[items.length];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[sizeRes++] = items[i];
            }
        }
        return Arrays.copyOf(result, sizeRes);
    }

    public Item[] findByName(String key) {
        int sizeRes = 0;
        Item[] result = new Item[items.length];
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[sizeRes++] = items[i];
            }
        }
        return Arrays.copyOf(result, sizeRes);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public boolean replace(int id, Item item) {
        boolean res = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            res = true;
        }
        return res;
    }

    public void delete(int id) {
        int startPos = indexOf(id);
        int distPos = startPos + 1;
        if (startPos != -1) {
            System.arraycopy(items, startPos, items, distPos, size - startPos - 1);
            items[size - 1] = null;
            size--;
        }
    }
}