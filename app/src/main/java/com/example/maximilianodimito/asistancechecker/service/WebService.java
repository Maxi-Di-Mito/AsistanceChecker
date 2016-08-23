package com.example.maximilianodimito.asistancechecker.service;

import com.example.maximilianodimito.asistancechecker.model.Asistance;
import com.example.maximilianodimito.asistancechecker.model.Person;
import com.example.maximilianodimito.asistancechecker.model.PersonResponse;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public interface WebService {

    public static String baseUrl = "http://10.0.0.107:8080/api/";


    //List<Asistance> getAsistanceForDay(Date d);

    @GET("persons/list")
    Call<PersonResponse> getPersons();

    //void sendAsistances( List<Asistance> asistances);


}
