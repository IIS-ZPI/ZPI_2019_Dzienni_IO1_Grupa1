package com.ZPI.group1.CurrencyData;


public class Rate {
    public String no;
    public String effectiveDate;
    public Double mid;

    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid=" + mid +
                '}';
    }
}