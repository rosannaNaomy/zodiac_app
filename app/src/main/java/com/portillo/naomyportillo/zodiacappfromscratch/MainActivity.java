package com.portillo.naomyportillo.zodiacappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.portillo.naomyportillo.zodiacappfromscratch.model.ZodiacModel;
import com.portillo.naomyportillo.zodiacappfromscratch.recyclerview.ZodiacAdapter;
import com.portillo.naomyportillo.zodiacappfromscratch.retrofit.RetrofitZodiacService;
import com.portillo.naomyportillo.zodiacappfromscratch.retrofit.RetrofitZodiacSingleton;
import com.portillo.naomyportillo.zodiacappfromscratch.retrofit.ZodiacList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = ".MainActivity" ;
    List<ZodiacModel> zodiacModelList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.zodiac_recycler_container);
        retrofitCall();
    }

    private void retrofitCall(){
        Retrofit retrofit = RetrofitZodiacSingleton.getInstance();
        RetrofitZodiacService zodiacService= retrofit.create(RetrofitZodiacService.class);
        Call<ZodiacList> zodiacCall = zodiacService.getList();
        zodiacCall.enqueue(new Callback<ZodiacList>() {
            @Override
            public void onResponse(Call<ZodiacList> call, Response<ZodiacList> response) {
                zodiacModelList = response.body().getZodiac();
                Log.d(TAG, "Nummy - This retrofit call was successful" + response.body().toString());
                Log.d(TAG, "Nummy - " + response.body().getZodiac().toString());

                recyclerView.setAdapter(new ZodiacAdapter(zodiacModelList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ZodiacList> call, Throwable t) {
                Log.d(TAG, "Nummy - On Failure, This retrofit call was not successful" + t.getMessage());

            }
        });
    }
}
