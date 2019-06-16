package com.ZPI.group1.Calculator;

import com.ZPI.group1.CurrencyData.Rate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {

    private static double median(List<Rate> prices) {
        double median = 0;
        Collections.sort(prices, new Comparator<Rate>() {
            @Override
            public int compare(Rate a, Rate b) {
                return a.mid.compareTo(b.mid);
            }
        });
        if (prices.size() % 2 == 0) {
            median = (prices.get(prices.size() / 2).mid + prices.get((prices.size() / 2) + 1).mid) / 2.0;
        } else {
            median = prices.get(prices.size() / 2).mid;
        }

        return median;
    }

    private static List<Double> dominant(double[] prices) {
        List<Double> dominant = new ArrayList<>();
        int max = 0;
        int counter = 0;

        for (int i = 0; i < prices.length; i++) {
            counter = 0;
            for (int k = 0; k < prices.length; k++) {
                if (prices[i] == prices[k]) {
                    counter++;
                }
            }
            if (counter > max) {
                dominant.clear();
                dominant.add(prices[i]);
                max = counter;
            } else if (counter == max) {
                dominant.add(prices[i]);
            }
        }
        return dominant;
    }

    private static double average(double[] prices) {

        double sum = 0;
        double average = 0;
        for (double x : prices) {
            sum = sum + x;
        }

        average = sum / prices.length;

        return average;
    }
}
