package com.example.seenataskjava.Network;


import com.example.seenataskjava.Model.Root;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("hardcover-fiction.json?api-key=GAjpCfEX2ZBpoZFx3yJN9vys6uILLRDp")
    Observable<Root> getBooks();


}
