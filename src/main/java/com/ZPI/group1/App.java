package com.ZPI.group1;

import com.ZPI.group1.Exceptions.NoDataFoundException;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Statistics statistics = new Statistics();
        while (true) {
            try {
                statistics.useMenu();
            } catch (NoDataFoundException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("\nType 'exit' to finish or anything else to continue");
            if ("exit".equals(in.nextLine().trim())) {
                break;
            } else {
                System.out.println("\n");
            }
        }
    }
}
