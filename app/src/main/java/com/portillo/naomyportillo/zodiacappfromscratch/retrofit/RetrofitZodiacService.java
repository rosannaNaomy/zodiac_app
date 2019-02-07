package com.portillo.naomyportillo.zodiacappfromscratch.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitZodiacService {

    String ENDPOINT = "JDVila/storybook/master/zodiac.json";

    @GET(ENDPOINT)
    Call<ZodiacList> getList();
}
