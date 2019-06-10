package com.ZPI.group1;

import com.ZPI.group1.Data.ApiResoult;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Statistics offers methods for currency
 * exchange rate's statistic calculations.
 */
public final class Statistics {

    public static final int WEEK = 7;
    public static final int TWO_WEEKS = 14;
    public static final int MONTH = 31;
    public static final int QUARTER = 122;
    public static final int HALF_YEAR = 182;
    public static final int YEAR = 365;

    /**
     * Prints menu to help you with
     * handling class's options.
     *
     * @param apiResults Data to perform calculations on.
     */
    public void useMenu(List<ApiResoult> apiResults) {

        Scanner in = new Scanner(System.in);
        boolean skipPeriodMenu;
        int optionAnswer;
        int periodAnswer = 0;
        String firstCurrency;
        String secondCurrency = null;

        while (true) {
            printOptionMenu();
            while (!in.hasNextInt()) {
                in.next();
                printOptionMenu();
            }
            optionAnswer = in.nextInt();
            in.nextLine(); // take /n from buffer

            if (optionAnswer >= 1 && optionAnswer <= 9) {
                break;
            } else {
                System.out.println("Wybierz opcje od 1 do 9");
            }
        }

        skipPeriodMenu = (optionAnswer == 8 || optionAnswer == 9);

        if (skipPeriodMenu) {
            while (true) {
                //get first currency to compare
                while (true) {
                    printCurrencyMenu();
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
                if (firstCurrency.equals(secondCurrency)) {
                    System.out.println("Currencies should be different.");
                } else {
                    break;
                }
            }

        } else {
            //get period
            while (true) {
                printPeriodMenu();
                while (!in.hasNextInt()) {
                    in.next();
                    printPeriodMenu();
                }
                periodAnswer = in.nextInt();

                if (periodAnswer >= 1 && periodAnswer <= 6) {
                    break;
                } else {
                    System.out.println("Wybierz opcje od 1 do 6");
                }
            }

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
        performMethod(optionAnswer, periodAnswer, firstCurrency, secondCurrency);
    }

    private static void performMethod(int option, int period, String firstCurrency, String secondCurrency) {

        switch (period) {
            case 1:
                period = WEEK;
                break;
            case 2:
                period = TWO_WEEKS;
                break;
            case 3:
                period = MONTH;
                break;
            case 4:
                period = QUARTER;
                break;
            case 5:
                period = HALF_YEAR;
                break;
            case 6:
                period = YEAR;
                break;
            case 0: //when we skipPeriodMenu
                break;
            default:
                System.out.println("Cos poszlo nie tak...");
        }

        switch (option) {
            case 1:
                //method Ilość sesji wzrostowych
                break;
            case 2:
                //method Ilość sesji spadkowych
                break;
            case 3:
                //method Ilość sesji bez zmian
                break;
            case 4:
                //method Mediana
                break;
            case 5:
                //method Dominanta
                break;
            case 6:
                //method Odchylenie standardowe
                break;
            case 7:
                //method Współczynnik zmienności
                break;
            case 8:
                //method Rozkład zmian miesięcznych
                break;
            case 9:
                //method Rozkład zmian kwartalnych
                break;
            default:
                System.out.println("Cos poszlo nie tak...");
        }
    }

    public boolean validateCurrencyCode(String code) {

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
