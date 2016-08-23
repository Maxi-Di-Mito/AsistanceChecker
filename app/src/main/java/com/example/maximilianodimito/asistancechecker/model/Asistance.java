package com.example.maximilianodimito.asistancechecker.model;

import java.util.Date;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class Asistance {
    private Person person;
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
}
