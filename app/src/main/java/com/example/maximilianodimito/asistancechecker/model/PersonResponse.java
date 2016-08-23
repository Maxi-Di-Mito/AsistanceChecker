package com.example.maximilianodimito.asistancechecker.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class PersonResponse {

    @SerializedName("response")
    private boolean response;

    @SerializedName("persons")
    private List<Person> persons;


    public boolean getResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
