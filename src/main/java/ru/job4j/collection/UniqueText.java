package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        /* for-each origin -> new HashSet. */
        for (String s : origin) {
            check.add(s);
        }
        /* for-each text -> hashSet.contains */
        for (String s : text) {
            if (!check.contains(s)) {
                result = false;
                break;
            }
        }
        return result;
    }
}