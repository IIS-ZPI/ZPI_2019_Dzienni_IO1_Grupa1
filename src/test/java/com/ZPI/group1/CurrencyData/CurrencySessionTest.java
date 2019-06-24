package com.ZPI.group1.CurrencyData;


import com.ZPI.group1.Exceptions.NoDataFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CurrencySessionTest {
    @Mock
    private CurrencySession currencySessionMock;

    private CurrencySession currencySessionForTests;

    private CurrencyTable testValue;

    @Before
    public void setup(){

        testValue=new CurrencyTable();
        currencySessionMock=mock(CurrencySession.class);
    }

    @Test
    public void getCurrencyGrowthSessionAmountShouldReturnOne() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.46d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.87d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(1,currencySessionForTests.getCurrencyGrowthSessionAmount());
    }

    @Test
    public void getCurrencyDownwardSessionAmountShouldReturnOne() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.30d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.23d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(1,currencySessionForTests.getCurrencyDownwardSessionAmount());
    }

    @Test
    public void getCurrencyConstantSessionAmount() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(1,currencySessionForTests.getCurrencyConstantSessionAmount());
    }

    @Test
    public void getCurrencyGrowthSessionAmountShouldReturnTwo() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.46d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.87d);
        listOfRatesForTest.add(rate);
        rate=new Rate("3","12.06.2019",4.60d);
        listOfRatesForTest.add(rate);
        rate=new Rate("4","13.06.2019",4.65d);
        listOfRatesForTest.add(rate);
        rate=new Rate("5","14.06.2019",4.70d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(2,currencySessionForTests.getCurrencyGrowthSessionAmount());
    }

    @Test
    public void getCurrencyDownwardSessionAmountShouldReturnTwo() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.30d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.40d);
        listOfRatesForTest.add(rate);
        rate=new Rate("3","12.06.2019",4.38d);
        listOfRatesForTest.add(rate);
        rate=new Rate("4","13.06.2019",4.36d);
        listOfRatesForTest.add(rate);
        rate=new Rate("5","14.06.2019",4.32d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(2,currencySessionForTests.getCurrencyDownwardSessionAmount());
    }

    @Test
    public void getCurrencyConstantSessionAmountShouldReturnTwo() throws NoDataFoundException {
        List<Rate> listOfRatesForTest =new ArrayList<>();
        Rate rate=new Rate("0","12.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("1","13.06.2019",4.45d);
        listOfRatesForTest.add(rate);
        rate=new Rate("2","14.06.2019",4.60d);
        listOfRatesForTest.add(rate);
        rate=new Rate("3","12.06.2019",4.70d);
        listOfRatesForTest.add(rate);
        rate=new Rate("4","13.06.2019",4.70d);
        listOfRatesForTest.add(rate);
        rate=new Rate("5","14.06.2019",4.70d);
        listOfRatesForTest.add(rate);
        testValue.rates=listOfRatesForTest;
        currencySessionForTests=new CurrencySession(testValue);
        Assert.assertEquals(2,currencySessionForTests.getCurrencyConstantSessionAmount());
    }


    @Test
    public void currencySessionShouldInvokeMethodgetCurrencyConstantSessionAmountOnce(){
        when(currencySessionMock.getCurrencyConstantSessionAmount()).thenReturn(1);
        currencySessionMock.getCurrencyConstantSessionAmount();
        verify(currencySessionMock,times(1)).getCurrencyConstantSessionAmount();
    }

    @Test
    public void currencySessionShouldInvokeMethodgetCurrencyGrowthSessionAmountOnce(){
        when(currencySessionMock.getCurrencyGrowthSessionAmount()).thenReturn(1);
        currencySessionMock.getCurrencyGrowthSessionAmount();
        verify(currencySessionMock,times(1)).getCurrencyGrowthSessionAmount();
    }

    @Test
    public void currencySessionShouldInvokeMethodgetCurrencyDownwardSessionAmountOnce(){
        when(currencySessionMock.getCurrencyDownwardSessionAmount()).thenReturn(1);
        currencySessionMock.getCurrencyDownwardSessionAmount();
        verify(currencySessionMock,times(1)).getCurrencyDownwardSessionAmount();
    }
}