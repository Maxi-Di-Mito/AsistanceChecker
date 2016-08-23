package com.example.maximilianodimito.asistancechecker.modules.dashboard;

import com.example.maximilianodimito.asistancechecker.helper.ServiceFactory;
import com.example.maximilianodimito.asistancechecker.model.PersonResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardPresenter implements  Callback<PersonResponse> {

    private DashBoardView view;


    public DashBoardPresenter(DashBoardView dashBoardView)
    {
        if (dashBoardView == null) {
            throw new IllegalArgumentException("dashBoard shouldn't be null");
        }
        this.view = dashBoardView;
    }


    public void loadPersonsForDay(Date day)
    {
        Call<PersonResponse> call = ServiceFactory.getWebService().getPersons();
        call.enqueue(this);
    }

    // Calback
    @Override
    public void onResponse(Call<PersonResponse> call, final Response<PersonResponse> response) {
        if(response.isSuccessful() && response.body().getResponse())
        {
            view.setPersonsList(response.body().getPersons());
        }
    }

    @Override
    public void onFailure(Call<PersonResponse> call, Throwable t) {

    }

    public static DashBoardPresenter getInstance(DashBoardView dashBoardView) {
        return new DashBoardPresenter(dashBoardView);
    }
}
