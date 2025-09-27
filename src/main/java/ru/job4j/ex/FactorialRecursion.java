package ru.job4j.ex;
// if else, ���� n == 0 ��� n == 1, �� ����� ������� �������� return 1,
// ����� ����� ��������� �������� calc(n - 1) * n.

public class FactorialRecursion {
    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return calc(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        int result = calc(3);
        System.out.println(result);
    }
}