package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("� ������� ������. ��� �� ������ ������? ");
        String question = scanner.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("��!");
        } else if (answer == 1) {
            System.out.println("���!");
        } else {
            System.out.println("����� ����!");
        }
    }
}
