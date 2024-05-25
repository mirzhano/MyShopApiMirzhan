package com.example.myshopapimirzhan.remote_data;

import com.example.myshopapimirzhan.models.ModelM;
import com.example.myshopapimirzhan.models.ModelM;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("products")
    Call<List<ModelM>> getStoreProducts();
}
