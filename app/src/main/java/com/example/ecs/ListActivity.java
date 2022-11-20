package com.example.ecs;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.ecs.databinding.ActivityListBinding;
import com.example.ecs.net.EcsDoc;
import com.example.ecs.net.HttpService;
import com.example.ecs.net.WifiHandler;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends Activity implements View.OnClickListener{

    private ActivityListBinding binding;

    private DatePickerDialog datePickerDialogFrom;
    private DatePickerDialog datePickerDialogTo;

    private int selectedYearFrom = 0;
    private int selectedMonthFrom = 0;
    private int selectedDayFrom = 0;

    private int selectedYearTo = 0;
    private int selectedMonthTo = 0;
    private int selectedDayTo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* 뷰 바인딩 */
        binding = ActivityListBinding.inflate(getLayoutInflater());
        binding.txtDateFrom.setOnClickListener(this);
        binding.txtDateTo.setOnClickListener(this);
        binding.btnSrch.setOnClickListener(this);
        setContentView(binding.getRoot());

        /* 날짜 */
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        selectedYearFrom = selectedYearTo = year;
        selectedMonthFrom = selectedMonthTo = month;
        selectedDayFrom = selectedDayTo = day;

        binding.txtDateFrom.setText(year + "-" + month + "-" + (day));
        binding.txtDateTo.setText(year + "-" + month + "-" + day);

        /* DatePicker */
        datePickerDialogFrom = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                selectedYearFrom = y;
                selectedMonthFrom = m + 1;
                selectedDayFrom = d;
                binding.txtDateFrom.setText(selectedYearFrom + "-" + selectedMonthFrom + "-" + selectedDayFrom);
            }
        }, year, month-1, day);

        datePickerDialogTo = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                selectedYearTo = y;
                selectedMonthTo = m + 1;
                selectedDayTo = d;
                binding.txtDateTo.setText(selectedYearTo + "-" + selectedMonthTo + "-" + selectedDayTo);
            }
        }, year, month-1, day);

    }

    @Override
    public void onClick(View view) {

        int viewId = view.getId();

        if(viewId == binding.txtDateFrom.getId()) {
            datePickerDialogFrom.show();
        } else if(viewId == binding.txtDateTo.getId()) {
            datePickerDialogTo.show();
        } else if(viewId == binding.btnSrch.getId()) {
            getElecDocList();
        }

    }

    public void getElecDocList() {

        /* Retrofit */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        HttpService httpService = retrofit.create(HttpService.class);

        Call<EcsDoc> ecsDocCall = httpService.getElecDocList(EcsConfig.USER_ECDW_ADRES
                                    , (""+selectedYearFrom+selectedMonthFrom+selectedDayFrom)
                                    , (""+selectedYearTo+selectedMonthTo+selectedDayTo));

        ecsDocCall.enqueue(new Callback<EcsDoc>() {
            @Override
            public void onResponse(Call<EcsDoc> call, Response<EcsDoc> response) {

                final List<EcsDoc.Proofs> proofs = response.body().getProofs();
                ListAdapter listAdapter = new ListAdapter(getApplicationContext(), proofs);

                binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent intent = new Intent(getApplicationContext(), OpenActivity.class);
                        intent.putExtra("ecdwAdres", EcsConfig.USER_ECDW_ADRES);
                        intent.putExtra("docId", proofs.get(i).getDocId());
                        WifiHandler.specifyWifiNetwork(getApplicationContext(), intent);
                    }
                });
                binding.listView.setAdapter(listAdapter);
            }
            @Override
            public void onFailure(Call<EcsDoc> call, Throwable t) {
                Log.e(this.getClass().getName(), "Throwable=" + t);
            }
        });



    }

}
