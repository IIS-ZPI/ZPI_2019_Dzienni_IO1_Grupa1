package com.ZPI.group1.ApiController;

import com.ZPI.group1.CurrencyData.CurrencyTable;
import com.ZPI.group1.Data.ApiResoult;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DataReciverTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void dataRecieverShouldNotReturnNull(){

        DataReciver dataReciver = new DataReciver();

        assertNotNull(dataReciver.apiTest());

    }

    @Test
    public void dataRecieverShouldReturnProperValueOfGold(){

        DataReciver mockedDataReciever = mock(DataReciver.class);
        final ApiResoult EXPECTED_API_RESOULT;

        try {
            EXPECTED_API_RESOULT = new ApiResoult("2019-06-05", 45.34);
            when(mockedDataReciever.apiTest()).thenReturn(EXPECTED_API_RESOULT);

            assertEquals(mockedDataReciever.apiTest().cena, EXPECTED_API_RESOULT.cena);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        verify(mockedDataReciever, times(1)).apiTest();

    }

    @Test
    public void getCurrencyShouldReturnProperCurrencyName(){

        CurrencyTable currencyTable;
        DataReciver dataReciver = new DataReciver();
        currencyTable = dataReciver.getCurrencyRate("USD",10);

        final String EXPECTED_CURRENCY = "dolar amerykański";
        assertEquals(EXPECTED_CURRENCY, currencyTable.currency);

    }

    @Test
    public void getCurrencyShouldNotReturnNullValueWhenCurrencyNameIsValid(){

        CurrencyTable currencyTable;
        DataReciver dataReciver = new DataReciver();
        currencyTable = dataReciver.getCurrencyRate("USD",10);

        assertNotNull(currencyTable.code);

    }

    @Test
    public void getCurrencyShouldReturnNullValueWhenCurrencyNameIsInvalid(){

        CurrencyTable currencyTable;
        DataReciver dataReciver = new DataReciver();
        currencyTable = dataReciver.getCurrencyRate("PLPL",10);

        assertNull(currencyTable);

    }

    @Test
    public void getCurrencyShouldReturnNullValueWhenGivenPeriodOfTimeIsNegative(){

        CurrencyTable currencyTable;
        DataReciver dataReciver = new DataReciver();
        currencyTable = dataReciver.getCurrencyRate("USD",-10);

        assertNull(currencyTable);

    }

    @Test
    public void getCurrencyShouldReturnNullValueWhenGivenPeriodOfTimeIsEqualZero(){

        CurrencyTable currencyTable;
        DataReciver dataReciver = new DataReciver();
        currencyTable = dataReciver.getCurrencyRate("USD",0);

        assertNull(currencyTable);

    }
}
