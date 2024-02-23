package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int THREE = 3;
    private static final int FIVE = 5;

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int startAt = 1;
        Scanner scanner = new Scanner(System.in);
        Fool fool = new Fool();
        while (startAt < 100) {
            System.out.println(fool.getAnswer(startAt));

            startAt++;
            String answer = scanner.nextLine();

            if (!answer.equals(fool.getAnswer(startAt))) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public String getAnswer(int number) {
        String result;
        if (number % THREE == 0 && number % FIVE == 0) {
            result = FIZZ_BUZZ;
        } else if (number % THREE == 0) {
            result = FIZZ;
        } else if (number % FIVE == 0) {
            result = BUZZ;
        } else {
            result = String.valueOf(number);
        }
        return result;
    }
}
