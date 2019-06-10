package com.ZPI.group1.CurrencyData;

import java.util.List;

public class CurrencyTable {
    public String table;
    public String currency;
    public String code;
    public List<Rate> rates = null;

    @Override
    public String toString() {
        return "CurrencyTable{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}