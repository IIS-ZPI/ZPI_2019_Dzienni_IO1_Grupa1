package com.ZPI.group1.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface NBPService {

    @GET("cenyzlota")
    Call<List<ApiResoult>> goldPrice();

}
