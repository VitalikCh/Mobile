package com.carlosrd.recipepuppy.data.source.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static String mAPIBaseURL = "https://api.myjson.com";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(mAPIBaseURL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();


    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }


    public static <S> S createService(String newAPIBaseURL, Class<S> serviceClass) {


        if (!newAPIBaseURL.equals(mAPIBaseURL)) {

            mAPIBaseURL = newAPIBaseURL;

            builder = new Retrofit.Builder()
                    .baseUrl(mAPIBaseURL)
                    .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();

        }

        return retrofit.create(serviceClass);

    }
}
