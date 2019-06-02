package com.ZPI.group1;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Statistics offers methods for
 * exchange rate's statistic calculations.
 */
public final class Statistics {

    /**
     * Prints menu to help you with
     * handling class's options.
     */
    public static void useMenu() {

        Scanner in = new Scanner(System.in);
        boolean skipPeriodMenu;
        int optionAnswer;
        int periodAnswer = 0;
        String firstCurrency;
        String secondCurrency = null;

        printOptionMenu();
        while (!in.hasNextInt()) {
            in.next();
            printOptionMenu();
        }
        optionAnswer = in.nextInt();

        skipPeriodMenu = (optionAnswer == 8 || optionAnswer == 9);

        if (skipPeriodMenu) {
            //get first currency to compare
            while (true) {
                printCurrencyMenu();
                in.nextLine(); // clear input
                firstCurrency = in.nextLine().trim().toUpperCase();
                if (validateCurrencyCode(firstCurrency)) {
                    break;
                } else {
                    System.out.println("Currency code should be 3 letters long");
                }
            }
            //get second currency to compare
            while (true) {
                printCurrencyMenu();
                secondCurrency = in.nextLine().trim().toUpperCase();
                if (validateCurrencyCode(secondCurrency)) {
                    break;
                } else {
                    System.out.println("Currency code should be 3 letters long");
                }
            }

        } else {
            //get period
            printPeriodMenu();
            while (!in.hasNextInt()) {
                in.next();
                printPeriodMenu();
            }
            periodAnswer = in.nextInt();

            //get currency to perform method for
            while (true) {
                printCurrencyMenu();
                in.nextLine(); // clear input
                firstCurrency = in.nextLine().trim().toUpperCase();
                if (validateCurrencyCode(firstCurrency)) {
                    break;
                } else {
                    System.out.println("Currency code should be 3 letters long.");
                }
            }
        }
    }

    private static boolean validateCurrencyCode(String code) {

        if (code == null || code.isEmpty() || code.length() != 3 || Pattern.matches("[^a-zA-Z]+", code)) {
            return false;
        } else {
            return true;
        }


    }

    private static void printOptionMenu() {

        System.out.println("1. Ilość sesji wzrostowych.");
        System.out.println("2. Ilość sesji spadkowych.");
        System.out.println("3. Ilość sesji bez zmian.");
        System.out.println("4. Mediana");
        System.out.println("5. Dominanta");
        System.out.println("6. Odchylenie standardowe.");
        System.out.println("7. Współczynnik zmienności");
        System.out.println("8. Rozkład zmian miesięcznych");
        System.out.println("9. Rozkład zmian kwartalnych");
    }

    private static void printPeriodMenu() {

        System.out.println("1. Jeden tydzień");
        System.out.println("2. Dwa tygodnie");
        System.out.println("3. Jeden miesiąc");
        System.out.println("4. Jeden kwartał");
        System.out.println("5. Pół roku");
        System.out.println("6. Rok");
    }

    private static void printCurrencyMenu() {

        System.out.println("Wprowadź kod waluty: ");
    }
}
