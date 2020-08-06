package com.example.chat.Notificaciones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Client.
 */
public class Client {

    private static Retrofit retrofit = null;

    /**
     * Get client retrofit.
     *
     * @param url the url
     * @return the retrofit
     */
    public static Retrofit getClient(String url){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
