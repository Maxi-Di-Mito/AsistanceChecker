package com.example.maximilianodimito.asistancechecker.modules.dashboard;

import com.example.maximilianodimito.asistancechecker.helper.CalendarHelper;
import com.example.maximilianodimito.asistancechecker.helper.ServiceFactory;
import com.example.maximilianodimito.asistancechecker.model.AsistanceResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardPresenter {

    private DashBoardView view;


    public DashBoardPresenter(DashBoardView dashBoardView)
    {
        if (dashBoardView == null) {
            throw new IllegalArgumentException("dashBoard shouldn't be null");
        }
        this.view = dashBoardView;
    }


    public void loadAsistancesPersonsForDay(Date day)
    {
        Call<AsistanceResponse> call = ServiceFactory.getWebService().getAsistancesByDate(CalendarHelper.dateToString(day));
        call.enqueue(new Callback<AsistanceResponse>() {
            @Override
            public void onResponse(Call<AsistanceResponse> call, final Response<AsistanceResponse> response) {
                if(response.isSuccessful() && response.body().getResponse())
                {
                    view.setAsistancesList(response.body().getAsistances());
                }
            }

            @Override
            public void onFailure(Call<AsistanceResponse> call, Throwable t) {

            }
        });
    }


    public static DashBoardPresenter getInstance(DashBoardView dashBoardView) {
        return new DashBoardPresenter(dashBoardView);
    }
}
