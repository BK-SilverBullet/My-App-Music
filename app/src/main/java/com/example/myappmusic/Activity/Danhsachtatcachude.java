package com.example.myappmusic.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myappmusic.Adapter.DanhsachtatcachudeAdapter;
import com.example.myappmusic.Model.ChuDe;
import com.example.myappmusic.R;
import com.example.myappmusic.Sercvice.APIService;
import com.example.myappmusic.Sercvice.Dataservicer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Danhsachtatcachude extends AppCompatActivity {
    Toolbar toolbarallchude;
    RecyclerView recyclerViewallchude;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        init();
        GetData();
    }

    private void GetData() {
        Dataservicer dataservicer = APIService.getService();
        Call<List<ChuDe> >callback = dataservicer.GetAllChuDe();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(Danhsachtatcachude.this,mangchude);
                recyclerViewallchude.setLayoutManager(new GridLayoutManager(Danhsachtatcachude.this,1));
                recyclerViewallchude.setAdapter(danhsachtatcachudeAdapter);
            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewallchude = findViewById(R.id.recyclerviewallchude);
        toolbarallchude = findViewById(R.id.toolbarallchude);
        setSupportActionBar(toolbarallchude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tất Cả Chủ Đề");
        toolbarallchude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}