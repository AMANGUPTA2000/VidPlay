package com.example.vidplay;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MyVerticalViewPager viewPager;
    private ViewPagerAdapter adapter;
    private MyApi myApi;
    private List<List_Data>list_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(MyVerticalViewPager)findViewById(R.id.view_pager);
        myApi= RetrofitInstance.getRetrofitInstance().create(MyApi.class);


        Call<List<List_Data>> call=myApi.geData();
        call.enqueue(new Callback<List<List_Data>>() {
            @Override
            public void onResponse(Call<List<List_Data>> call, Response<List<List_Data>> response) {
                list_data=response.body();
                adapter=new ViewPagerAdapter(MainActivity.this,list_data);
                viewPager.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<List_Data>> call, Throwable t) {

            }
        });


    }
}