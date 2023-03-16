package com.example.myappmusic.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myappmusic.Adapter.DanhsachplaylistAdapter;
import com.example.myappmusic.Model.Play;
import com.example.myappmusic.R;
import com.example.myappmusic.Sercvice.APIService;
import com.example.myappmusic.Sercvice.Dataservicer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachplaylistActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerViewdanhsachcacplaylist;
    DanhsachplaylistAdapter danhsachplaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachplaylist);
        anhxa();
        init();
        GetData();
    }

    private void GetData() {
        Dataservicer dataservicer = APIService.getService();
        Call<List<Play>> callback = dataservicer.GetDanhsachcacplaylist();
        callback.enqueue(new Callback<List<Play>>() {
            @Override
            public void onResponse(Call<List<Play>> call, Response<List<Play>> response) {
                ArrayList<Play> mangplaylist = (ArrayList<Play>) response.body();
                danhsachplaylistAdapter = new DanhsachplaylistAdapter(DanhsachplaylistActivity.this,mangplaylist);
                recyclerViewdanhsachcacplaylist.setLayoutManager(new GridLayoutManager(DanhsachplaylistActivity.this,2));
                recyclerViewdanhsachcacplaylist.setAdapter(danhsachplaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Play>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play List");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    private void anhxa() {
        toolbar = findViewById(R.id.toolbardanhsachcacplaylist);
        recyclerViewdanhsachcacplaylist = findViewById(R.id.recyclerviewdanhsachcacplaylist);
    }
}