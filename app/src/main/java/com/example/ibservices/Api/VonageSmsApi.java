package com.example.ibservices.Api;


import com.example.ibservices.Data.SmsResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface VonageSmsApi {


    @FormUrlEncoded
    @POST("sms/")
    Call<SmsResponse> sendSmsOrderConfirmation (
            @Field("api_key") String apiKey,
            @Field("api_secret") String secret_key,
            @Field("from") String From,
            @Field("to") String To,
            @Field("text") String message);


}
