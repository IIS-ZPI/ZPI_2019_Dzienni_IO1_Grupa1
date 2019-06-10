package com.ZPI.group1.ApiController;

import com.ZPI.group1.Data.ApiResoult;
import org.junit.Test;

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
           EXPECTED_API_RESOULT = new ApiResoult("2019-06-05",45.34);
            when(mockedDataReciever.apiTest()).thenReturn(EXPECTED_API_RESOULT);

            assertEquals(mockedDataReciever.apiTest().cena,EXPECTED_API_RESOULT.cena);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        verify(mockedDataReciever,times(1)).apiTest();

    }
}
