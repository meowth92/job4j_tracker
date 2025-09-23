package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 100);
        Book two = new Book("Two", 200);
        Book three = new Book("Three", 300);
        Book four = new Book("Four", 400);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = two;
        books[2] = three;
        books[3] = four;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPageCount());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("**********************");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPageCount());
        }
        System.out.println("**********************");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - " + books[i].getPageCount());
            }
        }
    }
}
