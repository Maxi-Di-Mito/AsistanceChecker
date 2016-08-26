package com.example.maximilianodimito.asistancechecker.service;

import com.example.maximilianodimito.asistancechecker.model.AsistanceResponse;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public interface WebService {

    public String baseUrl = "http://10.0.0.107:8080/api/";


    //List<Asistance> getAsistanceForDay(Date d);

    @GET("persons/list")
    Call<AsistanceResponse> getPersons();


    @GET("asistances/{date}")
    Call<AsistanceResponse> getAsistancesByDate(@Path("date") String date);

    //void sendAsistances( List<Asistance> asistances);


}
