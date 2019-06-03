package com.ZPI.group1.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiResoult {
    public String temp;
    public Double cena;
    public Date date;


    public ApiResoult(String data, Double cena) throws ParseException {
        this.temp = data;
        this.cena = cena;
        date = new SimpleDateFormat("yyyy-MM-dd").parse(data);
    }

    @Override
    public String toString() {
        return "ApiResoult{" +
                "data=" + date +
                ", cena=" + cena +
                '}';
    }
}
