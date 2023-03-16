package com.example.myappmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myappmusic.Activity.DanhsachtheloaitheochudeActivity;
import com.example.myappmusic.Model.ChuDe;
import com.example.myappmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.ViewHolder>{

    Context context;
    ArrayList<ChuDe> mangchude;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<ChuDe> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cacchude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        ChuDe chude = mangchude.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgChude);
    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgChude;
        public ViewHolder( View itemView) {
            super(itemView);
            imgChude = itemView.findViewById(R.id.imageviewdongcacchude);
            imgChude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude",mangchude.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
