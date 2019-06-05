package com.ZPI.group1.ApiController;

import com.ZPI.group1.Data.ApiResoult;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

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

        assertNotNull(DataReciver.ApiTest());

    }

    @Ignore
    @Test
    public void dataRecieverShouldReturnProperValueOfGold(){

        final Double EXPECTED_PRIZE = 161.98;

        assertEquals(EXPECTED_PRIZE, DataReciver.ApiTest().cena);

    }
}
