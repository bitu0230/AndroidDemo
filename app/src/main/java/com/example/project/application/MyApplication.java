package com.example.project.application;

import android.app.Application;

import com.example.project.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    public Retrofit retrofit;

    @Override
    public void onCreate()
    {
        super.onCreate();
        retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(new OkHttpClient())
                .build();
    }
}
