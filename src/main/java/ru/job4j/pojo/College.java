package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivan Ivanov");
        student.setGroup("123");
        student.setDate("01/09/2025");
        System.out.println("Name: " + student.getName() + ". Group: " + student.getGroup() + ". Date: " + student.getDate());
    }
}
