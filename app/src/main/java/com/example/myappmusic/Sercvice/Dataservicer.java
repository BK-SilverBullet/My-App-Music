package com.example.myappmusic.Sercvice;

import com.example.myappmusic.Model.Album;
import com.example.myappmusic.Model.BaiHat;
import com.example.myappmusic.Model.ChuDe;
import com.example.myappmusic.Model.Play;
import com.example.myappmusic.Model.QuangCao;
import com.example.myappmusic.Model.TheLoai;
import com.example.myappmusic.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservicer {
    @GET("Songbanner.php")
    Call<List<QuangCao>> GetDataBanner();

    @GET("PlaylistForcurrentDay.php")
    Call<List<Play>> GetPlaylistCurrenDay();

    @GET("ChudevaTheLoaiTrongNgay.php")
    Call<Theloaitrongngay> GetCategory();

    @GET("Albumhot.php")
    Call<List<Album>> GetAlbumHot();

    @GET("baihatduocthich.php")
    Call<List<BaiHat>> GetBaiHatHot();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>>Getdanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachplaylist.php")
    Call<List<Play>> GetDanhsachcacplaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>>Getdanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("Tatcachude.php")
    Call<List<ChuDe>> GetAllChuDe();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>>Gettheloaitheochude(@Field("idchude") String idchude);


    @GET("Tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>>GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);


    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String>Updateluotthich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<BaiHat>>GetSearchBaihat(@Field("tukhoa") String tukhoa);

}
