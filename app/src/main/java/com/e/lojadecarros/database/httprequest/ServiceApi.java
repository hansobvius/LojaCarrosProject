package com.e.lojadecarros.database.httprequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceApi {

    private Retrofit mRetrofit = null;

    private static final String BASE_URL = "http://desafioonline.webmotors.com.br/api/OnlineChallenge/";

    public ServiceApi(){}

    public DataEndpoint getAPI(){
        if(mRetrofit == null){
            mRetrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit.create(DataEndpoint.class);
    }
}

