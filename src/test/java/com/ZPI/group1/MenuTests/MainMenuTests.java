package com.ZPI.group1.MenuTests;

import com.ZPI.group1.Statistics;
import org.junit.Assert;
import org.junit.Test;

public class MainMenuTests {

    @Test
    public void validateCurrencyCodeShouldReturnTrue() {

        Statistics statistics = new Statistics();

        boolean EXPECTED_VALUE = true;

        Assert.assertEquals(EXPECTED_VALUE, statistics.validateCurrencyCode("PLN"));

    }

    @Test
    public void validateCurrencyCodeShouldReturnFalseWhenGivenCodeIsEmpty() {

        Statistics statistics = new Statistics();
        boolean EXPECTED_VALUE = false;
        Assert.assertEquals(EXPECTED_VALUE, statistics.validateCurrencyCode(""));

    }

    @Test
    public void validateCurrencyCodeShouldReturnFalseWhenGivenCodeHasLengthGraterThanThree() {

        Statistics statistics = new Statistics();
        boolean EXPECTED_VALUE = false;
        Assert.assertEquals(EXPECTED_VALUE, statistics.validateCurrencyCode("ABCDE"));

    }

    @Test
    public void validateCurrencyCodeShouldReturnFalseWhenGivenCodeHasLengthSmallerThanThree() {

        Statistics statistics = new Statistics();
        boolean EXPECTED_VALUE = false;
        Assert.assertEquals(EXPECTED_VALUE, statistics.validateCurrencyCode("E"));

    }


}
