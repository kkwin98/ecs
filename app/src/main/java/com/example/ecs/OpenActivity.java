package com.example.ecs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;

import com.example.ecs.databinding.ActivityOpenBinding;
import com.example.ecs.net.EcsDocUrl;
import com.example.ecs.net.HttpService;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenActivity extends Activity {

    ActivityOpenBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* 뷰 바인딩 */
        binding = ActivityOpenBinding.inflate(getLayoutInflater());
        binding.wvCertificate.setWebViewClient(new WebViewClient());
        setContentView(binding.getRoot());

        /* 데이터 */
        String ecdwAdres = getIntent().getStringExtra("ecdwAdres");
        String docId = getIntent().getStringExtra("docId");

        /* Retrofit */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                        .build();

        HttpService httpService = retrofit.create(HttpService.class);

        Call<EcsDocUrl> ecsDocUrlCall = httpService.getElecDocOpenUrl(ecdwAdres, docId);

        ecsDocUrlCall.enqueue(new Callback<EcsDocUrl>() {
            @Override
            public void onResponse(Call<EcsDocUrl> call, Response<EcsDocUrl> response) {
                binding.wvCertificate.loadUrl(response.body().getDownloadUrl());
            }
            @Override
            public void onFailure(Call<EcsDocUrl> call, Throwable t) {
                Log.e(this.getClass().getName(), "Thrwable=" + t);
            }
        });

    }
}
