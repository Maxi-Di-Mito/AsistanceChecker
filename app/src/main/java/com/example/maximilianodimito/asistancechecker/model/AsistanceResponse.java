package com.example.maximilianodimito.asistancechecker.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class AsistanceResponse {

    @SerializedName("response")
    private boolean response;

    @SerializedName("asistances")
    private List<Asistance> asistances;


    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public List<Asistance> getAsistances() {
        return asistances;
    }

    public void setPersons(List<Asistance> asistances) {
        this.asistances = asistances;
    }
}
