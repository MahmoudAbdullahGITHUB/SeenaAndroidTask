package com.example.seenataskjava.Ui.Activity.HomeActivity;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.seenataskjava.Model.Root;
import com.example.seenataskjava.Network.ApiInterface;
import com.example.seenataskjava.Network.RetrofitClient;
import com.example.seenataskjava.Ui.Adapter.BookAdapter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeViewModel extends ViewModel {
    MutableLiveData<Root> rootLiveData = new MutableLiveData<>();


    public void getDataFromServer() {
        Retrofit retrofit;
        ApiInterface apiInterface;
        retrofit = RetrofitClient.getRetrofit();

        apiInterface = retrofit.create(ApiInterface.class);

        Observable observable = apiInterface.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observer<Root> observer = new Observer<Root>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Root root) {
                rootLiveData.postValue(root);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable.subscribe(observer);


    }


}


/**
 * before rxjava
 **/
//
//public void getDataFromServer() {
//    Retrofit retrofit;
//    ApiInterface apiInterface;
//    retrofit = RetrofitClient.getRetrofit();
//
//    apiInterface = retrofit.create(ApiInterface.class);
//
//    Call<Root> call = apiInterface.getBooks();
//
//    call.enqueue(new Callback<Root>() {
//        @Override
//        public void onResponse(Call<Root> call, Response<Root> response) {
//            if (response.body() != null) {
//                rootLiveData.postValue(response.body());
//
//            }
//        }
//
//        @Override
//        public void onFailure(Call<Root> call, Throwable t) {
//
//        }
//    });
//
//}
//
