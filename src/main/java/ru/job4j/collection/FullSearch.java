package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> res = new HashSet<>();
        for (Task task : tasks) {
            res.add(task.getNumber());
        }
        return res;
    }
}
