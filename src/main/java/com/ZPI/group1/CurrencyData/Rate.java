package com.ZPI.group1.CurrencyData;


public class Rate {
    public String no;
    public String effectiveDate;
    public Double mid;

    public Rate(String no, String effectiveDate, Double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", mid=" + mid +
                '}';
    }
}