package com.example.maximilianodimito.asistancechecker.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class Asistance {

    @SerializedName("person")
    private Person person;
    @SerializedName("date")
    private Date date;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date.toString()+"- "+this.person.toString();
    }
}
