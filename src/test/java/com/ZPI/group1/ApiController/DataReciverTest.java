package com.ZPI.group1.ApiController;

import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void dataRecieverShouldReturnProperValueOfGold(){

        final Double EXPECTED_PRIZE = 162.17;

        assertEquals(EXPECTED_PRIZE, DataReciver.ApiTest().cena);

    }
}
