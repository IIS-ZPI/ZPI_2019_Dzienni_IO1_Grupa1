package com.ZPI.group1;

import com.ZPI.group1.ApiController.DataReciver;
import com.ZPI.group1.Data.ApiResoult;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        DataReciver dataReciver = new DataReciver();
        ApiResoult apiResoult = dataReciver.apiTest();

        List<ApiResoult> apiResoults = new ArrayList<>();
        apiResoults.add(apiResoult);
        System.out.println(apiResoults.get(0).date);
        Statistics statistics = new Statistics();
        statistics.useMenu(apiResoults);
    }
}
