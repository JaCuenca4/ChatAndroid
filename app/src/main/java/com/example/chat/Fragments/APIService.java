package com.example.chat.Fragments;

import com.example.chat.Notificaciones.MyResponse;
import com.example.chat.Notificaciones.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAATgtHLG0:APA91bEcGvzsCgCxMfkcELlrk763-2V-LJfYrSIr1uRSEoR4ijse9g4NrzqhfLBqNUzC82FpPc9LN6KxC-i3ncbHR_K9IY1lK0vTkjvATXf3a91k9sBKQDIuIOP9EumZtb2BCyk-iUZD"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
