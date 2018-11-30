package com.example.vlad.androidapp.ServerUtilities;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LCBOUtility {
    private static Retrofit retrofit;
    private static LCBOClient request;

    public static LCBOClient generateRequest() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://lcboapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        request = retrofit.create(LCBOClient.class);
        return request;
    }
}
