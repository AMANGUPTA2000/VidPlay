package com.example.vidplay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("wishlist.php")
    Call<List<List_Data>> geData();

}
