package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("asd@mail.ru", "Ivanov");
        map.put("qwe@mail.ru", "Sergeev");
        map.put("zxcv@mail.ru", "Zadov");

        for (String k : map.keySet()) {
            String v = map.get(k);
            System.out.println(k + " : " + v);
        }
    }
}
