package com.example.myappmusic.Sercvice;

public class APIService {
    private  static  String base_url="https://clactonian-shops.000webhostapp.com/Server/";
    public  static Dataservicer getService(){
        return APIRetrofitClient.getclient(base_url).create(Dataservicer.class);
    }
}
