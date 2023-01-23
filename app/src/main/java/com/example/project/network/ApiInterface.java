package com.example.project.network;

import com.example.project.model.Data;
import com.example.project.model.ProductDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({"Accept: application/json",
            "user-agent:BlibliAndroid/0.0.1"})
    @GET("/backend/search/products")
    Call<ProductDetail> search(@Query("searchTerm") String searchTerm , @Query("showFacets") Boolean showFacets, @Query("itemPerPage")
                     int itemPerPage, @Query("page") int page , @Query("start") int start);



}
