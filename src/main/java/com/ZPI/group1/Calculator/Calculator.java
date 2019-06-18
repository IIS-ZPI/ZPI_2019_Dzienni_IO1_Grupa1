package com.ZPI.group1.Calculator;

import com.ZPI.group1.CurrencyData.Rate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Calculator {

    public double median(List<Rate> rates) {
        double median = 0;
        Collections.sort(rates, new Comparator<Rate>() {
            @Override
            public int compare(Rate a, Rate b) {
                return a.mid.compareTo(b.mid);
            }
        });
        if (rates.size() % 2 == 0) {
            median = (rates.get(rates.size() / 2).mid + rates.get((rates.size() / 2) + 1).mid) / 2.0;
        } else {
            median = rates.get(rates.size() / 2).mid;
        }

        return median;
    }

    public List<Double> dominant(List<Rate> rates) {
        List<Double> dominant = new ArrayList<>();
        int max = 0;
        int counter = 0;

        for (int i = 0; i < rates.size(); i++) {
            counter = 0;
            for (int k = 0; k < rates.size(); k++) {
                if (rates.get(i).mid.equals(rates.get(k).mid)) {
                    counter++;
                }
            }
            if (counter > max) {
                dominant.clear();
                dominant.add(rates.get(i).mid);
                max = counter;
            } else if (counter == max) {
                dominant.add(rates.get(i).mid);
            }
        }
        return dominant;
    }

    public double mean(List<Rate> rates) {

        double sum = 0;
        for (Rate x : rates) {
            sum = sum + x.mid;
        }

        return sum / rates.size();
    }

    public double deviation(List<Rate> rates) {
        double sum = 0;
        Calculator calc = new Calculator();
        double average = calc.mean(rates);
        for (int i = 0; i < rates.size(); i++) {
            sum += ((rates.get(i).mid - average) * (rates.get(i).mid - average));
        }
        return Math.sqrt(sum / (rates.size() - 1));

    }

    public double coefficientOfVariation(List<Rate> rates) {
        return deviation(rates) / mean(rates);
    }


}
