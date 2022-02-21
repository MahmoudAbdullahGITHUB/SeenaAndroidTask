package com.example.seenataskjava.Ui.Activity.HomeActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.seenataskjava.Model.Root;
import com.example.seenataskjava.Network.ApiInterface;
import com.example.seenataskjava.Network.RetrofitClient;
import com.example.seenataskjava.R;
import com.example.seenataskjava.Ui.Adapter.BookAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeActivity extends AppCompatActivity {

    Retrofit retrofit;
    ApiInterface apiInterface;
    String TAG = "MainActivity";
    RecyclerView recyclerView;
    HomeViewModel homeViewModel;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        initialViewModel();
        getPhotosFromServer();


    }


    void initialViewModel() {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.rootLiveData.observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                adapter = new BookAdapter(getApplicationContext(), root.results.books);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        });
    }

    private void getPhotosFromServer() {
        homeViewModel.getDataFromServer();
    }

}


/**
 * mvc
 */
//
//private void getDataFromNetwork() {
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
//                Log.d(TAG, "onResponse: " + response.body().status);
//
//                adapter = new BookAdapter(getApplicationContext(), response.body().results.books);
//                recyclerView.setAdapter(adapter);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//
//            }
//        }
//
//        @Override
//        public void onFailure(Call<Root> call, Throwable t) {
//            Log.d(TAG, "onFailure: ");
//        }
//    });
//
//}
//
