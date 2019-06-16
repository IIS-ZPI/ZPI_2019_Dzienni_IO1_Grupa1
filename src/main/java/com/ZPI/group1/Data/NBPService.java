package com.ZPI.group1.Data;

import com.ZPI.group1.CurrencyData.CurrencyTable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface NBPService {

    @GET("cenyzlota")
    Call<List<ApiResoult>> goldPrice();

    @GET("exchangerates/rates/a/{Currency}/last/{days}")
    Call<CurrencyTable> getCurrencyRate(@Path("Currency") String currency, @Path("days") Integer days);
}
