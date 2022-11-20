package com.example.ecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ecs.databinding.ActivityMainBinding;
import com.example.ecs.net.Ecdw;
import com.example.ecs.net.HttpService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /* 뷰 바인딩 */
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.btnUser1.setOnClickListener(this);
        binding.btnUser2.setOnClickListener(this);
        setContentView(binding.getRoot());




        /*Map<String, Object> body = new HashMap<>();
        body.put("ihidNum", "7205051067747");

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Map> future = executorService.submit(new EcsService(EcsConfig.API_5, EcsConfig.API_METHOD_GET, body));

        Map<String, Object> result = null;
        try {
            result = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(this.getClass().getName(), "RESULT=" + result);*/
    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        if( viewId == binding.btnUser1.getId() ) {
            EcsConfig.USER_ENR_NO = getString(R.string.user_name1_enrNo);
        } else if ( viewId == binding.btnUser2.getId() ) {
            EcsConfig.USER_ENR_NO = getString(R.string.user_name2_enrNo);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HttpService httpService = retrofit.create(HttpService.class);

        Call<Ecdw> callResult = httpService.getEcdwAdres(getString(R.string.ecdw_type_enr), EcsConfig.USER_ENR_NO);

        callResult.enqueue(new Callback<Ecdw>() {
            @Override
            public void onResponse(Call<Ecdw> call, Response<Ecdw> response) {
                EcsConfig.USER_ENR_NO = response.body().getEcdwAdres();
                Log.d(this.getClass().getName(), "ecdw=" + response.body());
            }

            @Override
            public void onFailure(Call<Ecdw> call, Throwable t) {
                Log.e(this.getClass().getName(), "Throwable=" + t);
            }
        });

        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }
}