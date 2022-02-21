package com.example.seenataskjava.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient INSTANCE;

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("https://api.nytimes.com/svc/books/v3/lists/current/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitClient getINSTANCE(){
        if (null==INSTANCE){
            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }


}
