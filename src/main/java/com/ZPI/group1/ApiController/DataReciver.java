package com.ZPI.group1.ApiController;

import com.ZPI.group1.Data.ApiResoult;
import com.ZPI.group1.Data.NBPService;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class DataReciver {
    public ApiResoult apiTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.nbp.pl/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NBPService nbpService = retrofit.create(NBPService.class);
        Call<List<ApiResoult>> call = nbpService.goldPrice();
        try {

            ApiResoult apiResoult = call.execute().body().get(0);
            System.out.println(apiResoult);
            return apiResoult;
        } catch (IOException e) {
            System.out.println(e.getMessage() + " blad");
        }
        return null;

    }

}
