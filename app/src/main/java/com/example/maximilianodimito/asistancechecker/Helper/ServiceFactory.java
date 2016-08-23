package com.example.maximilianodimito.asistancechecker.helper;

import com.example.maximilianodimito.asistancechecker.service.WebService;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class ServiceFactory {

    private static WebService webService = null;

    public static WebService getWebService()
    {
        /*final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setLenient()
                .create();*/

        if(webService == null)
        {
            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(WebService.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .callbackExecutor(Executors.newFixedThreadPool(5))
                    .build();

            webService = retrofit.create(WebService.class);
        }
        return webService;
    }

}
