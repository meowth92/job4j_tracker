package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * ������� ������ ���� �������������, ������� �������� key � ����� �����.
     * @param key ���� ������.
     * @return ������ �������������, ������� ������ ��������.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getName().contains(key)) {
                result.add(p);
            } else if (p.getSurname().contains(key)) {
                result.add(p);
            } else if (p.getPhone().contains(key)) {
                result.add(p);
            } else if (p.getAddress().contains(key)) {
                result.add(p);
            }
        }
        return result;
    }
}