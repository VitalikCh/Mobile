package com.example.vlad.androidapp.ServerUtilities;

import com.example.vlad.androidapp.Entities.ProductResponse;
import com.example.vlad.androidapp.Entities.Products;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LCBOClient {

    @GET("/products")
    Call<Products> allProducts();

    @GET("/products/{id}")
    Call<ProductResponse> getProduct(@Path("id") int id);
}
