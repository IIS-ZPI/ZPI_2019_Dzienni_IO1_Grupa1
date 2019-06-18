package com.ZPI.group1.Calculator;

import com.ZPI.group1.ApiController.DataReciver;
import com.ZPI.group1.CurrencyData.CurrencyTable;
import com.ZPI.group1.CurrencyData.Rate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTest {

    private  Calculator calculator = new Calculator();
    List<Rate> preparedRatesList;

    @BeforeEach
    public void setup(){

        preparedRatesList = new ArrayList<>();

        Rate rate = new Rate();
        rate.mid = 14.0;
        Rate rate1 = new Rate();
        rate1.mid = 10.0;
        Rate rate2 = new Rate();
        rate2.mid = 15.0;
        Rate rate3 = new Rate();
        rate3.mid = 17.0;
        Rate rate4 = new Rate();
        rate4.mid = 14.0;

        preparedRatesList.add(rate);
        preparedRatesList.add(rate1);
        preparedRatesList.add(rate2);
        preparedRatesList.add(rate3);
        preparedRatesList.add(rate4);

    }

    @Test
    public void medianShouldReturnProperValueTest(){

        final double EXPECTED_MEDIAN = 14.0;
        Assertions.assertEquals(EXPECTED_MEDIAN,calculator.median(preparedRatesList));

    }

    @Test
    public void meanShouldReturnProperValueTest(){

        final double EXPECTED_MEAN = 14;
        Assertions.assertEquals(EXPECTED_MEAN, calculator.mean(preparedRatesList));

    }

    @Test
    public void deviationShouldReturnProperValueTest(){

        double expectedDeviation = 2.5495097567964;
        expectedDeviation = expectedDeviation * 10000.0;
        expectedDeviation = (double) Math.round(expectedDeviation);
        expectedDeviation = expectedDeviation / 10000.0;

        double actualDeviation = calculator.deviation(preparedRatesList);
        actualDeviation = actualDeviation * 10000.0;
        actualDeviation = (double) Math.round(actualDeviation);
        actualDeviation = actualDeviation / 10000.0;

        Assertions.assertEquals(expectedDeviation,actualDeviation);

    }

    @Test
    public void coefficientOfVariationShouldReturnProperValueTest(){

        double expectedCofficientOfVariation = 2.5495097567964/14;
        expectedCofficientOfVariation = expectedCofficientOfVariation * 10000.0;
        expectedCofficientOfVariation = (double) Math.round(expectedCofficientOfVariation);
        expectedCofficientOfVariation = expectedCofficientOfVariation / 10000.0;

        double actualCofficientOfVariation = calculator.deviation(preparedRatesList) / calculator.mean(preparedRatesList);
        actualCofficientOfVariation = actualCofficientOfVariation * 10000.0;
        actualCofficientOfVariation = (double) Math.round(actualCofficientOfVariation);
        actualCofficientOfVariation = actualCofficientOfVariation / 10000.0;

        Assertions.assertEquals(expectedCofficientOfVariation, actualCofficientOfVariation);

    }

    @Test
    public void dominantShouldReturnProperValueTest(){

        final double EXPECTED_DOMINANT = 14.0;

        Assertions.assertEquals(EXPECTED_DOMINANT, calculator.dominant(preparedRatesList));

    }

}
