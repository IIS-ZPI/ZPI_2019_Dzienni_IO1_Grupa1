package com.ZPI.group1;

import com.ZPI.group1.ApiController.DataReciver;
import com.ZPI.group1.Calculator.Calculator;
import com.ZPI.group1.CurrencyData.CurrencySession;
import com.ZPI.group1.CurrencyData.CurrencyTable;
import com.ZPI.group1.Data.ApiResoult;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class Statistics offers methods for currency
 * exchange rate's statistic calculations.
 */
public class Statistics {

    public int week = 7;
    public int twoWeeks = 14;
    public int month = 31;
    public int quarter = 122;
    public int halfYear = 182;
    public int year = 365;

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

    private void performMethod(int option, int period, String firstCurrency, String secondCurrency) {
        DataReciver dataReciver = new DataReciver();

        switch (period) {
            case 1:
                period = week;
                break;
            case 2:
                period = twoWeeks;
                break;
            case 3:
                period = month;
                break;
            case 4:
                period = quarter;
                break;
            case 5:
                period = halfYear;
                break;
            case 6:
                period = year;
                break;
            case 0: //when we skipPeriodMenu
                break;
            default:
                System.out.println("Cos poszlo nie tak...");
        }
        CurrencyTable currencyTable = dataReciver.getCurrencyRate(firstCurrency, period);
        CurrencySession currencySession = new CurrencySession(currencyTable);
        Calculator calculator = new Calculator();
        switch (option) {
            case 1:
                //method Ilość sesji wzrostowych
                System.out.println("Ilość sesji wzrostowych to " + currencySession.getCurrencyGrowthSessionAmount());
                break;
            case 2:
                //method Ilość sesji spadkowych
                System.out.println("Ilość sesji spadkowych to " + currencySession.getCurrencyDownwardSessionAmount());
                break;
            case 3:
                //method Ilość sesji bez zmian
                System.out.println("Ilość sesji spadkowych to " + currencySession.getCurrencyConstantSessionAmount());
                break;
            case 4:
                //method Mediana
                calculator.median(currencyTable.rates);
                break;
            case 5:
                //method Dominanta
                calculator.dominant(currencyTable.rates);
                break;
            case 6:
                //method Odchylenie standardowe
                calculator.deviation(currencyTable.rates);
                break;
            case 7:
                //method Współczynnik zmienności
                calculator.coefficientOfVariation(currencyTable.rates);
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

    private void printOptionMenu() {

        System.out.println("1. Ilosc sesji wzrostowych.");
        System.out.println("2. Ilosc sesji spadkowych.");
        System.out.println("3. Ilosc sesji bez zmian.");
        System.out.println("4. Mediana");
        System.out.println("5. Dominanta");
        System.out.println("6. Odchylenie standardowe.");
        System.out.println("7. Wspolczynnik zmiennosci");
        System.out.println("8. Rozklad zmian miesiecznych");
        System.out.println("9. Rozklad zmian kwartalnych");
    }

    private void printPeriodMenu() {

        System.out.println("1. Jeden tydzien");
        System.out.println("2. Dwa tygodnie");
        System.out.println("3. Jeden miesiac");
        System.out.println("4. Jeden kwartal");
        System.out.println("5. Pol roku");
        System.out.println("6. Rok");
    }

    private void printCurrencyMenu() {

        System.out.println("Wprowadz kod waluty: ");
    }
}
