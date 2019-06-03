package com.ZPI.group1;

import com.ZPI.group1.ApiController.DataReciver;
import com.ZPI.group1.Data.ApiResoult;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        ApiResoult apiResoult= DataReciver.ApiTest();

        Statistics.useMenu();
    }
}
