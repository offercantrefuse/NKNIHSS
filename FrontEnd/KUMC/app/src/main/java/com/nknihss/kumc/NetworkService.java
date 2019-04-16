package com.nknihss.kumc;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NetworkService {
    @POST("/process/send")
    Call<Information> createUser(@Body Information information);
}
