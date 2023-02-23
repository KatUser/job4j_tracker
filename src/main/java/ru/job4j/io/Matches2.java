package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class Matches2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = new Random().nextBoolean();
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + ", введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches >= 1 && matches <= Math.min(3, count)) {
                count -= matches;
                turn = !turn;
                System.out.println("Осталось " + count + " спичек");
            } else {
                System.out.println("Ошибочка.");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}