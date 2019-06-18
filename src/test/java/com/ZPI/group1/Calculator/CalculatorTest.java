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

        Rate rate1 = new Rate();
        rate1.mid = 10.0;
        Rate rate2 = new Rate();
        rate2.mid = 15.0;
        Rate rate3 = new Rate();
        rate3.mid = 17.0;

        preparedRatesList.add(rate1);
        preparedRatesList.add(rate2);
        preparedRatesList.add(rate3);

    }

    @Test
    public void medianTest(){

        final double EXPECTED_MEDIAN = 15.0;
        Assertions.assertEquals(EXPECTED_MEDIAN,calculator.median(preparedRatesList));

    }

    @Test
    public void meanTest(){

        final double EXPECTED_MEAN = 14;
        Assertions.assertEquals(EXPECTED_MEAN, calculator.mean(preparedRatesList));

    }

    @Test
    public void deviationTest(){

        double expectedDeviation = 3.605551275464;
        expectedDeviation = expectedDeviation * 10000.0;
        expectedDeviation = (double) Math.round(expectedDeviation);
        expectedDeviation = expectedDeviation / 10000.0;

        double actualDeviation = calculator.deviation(preparedRatesList);
        actualDeviation = actualDeviation * 10000.0;
        actualDeviation = (double) Math.round(actualDeviation);
        actualDeviation = actualDeviation / 10000.0;

        Assertions.assertEquals(expectedDeviation,actualDeviation);

    }

}
