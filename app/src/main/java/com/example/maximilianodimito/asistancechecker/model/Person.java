package com.example.maximilianodimito.asistancechecker.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by maximiliano.dimito on 8/23/2016.
 */
public class Person {
    @SerializedName("name")
    private String name;
    @SerializedName("lastName")
    private String lastName;

    @Override
    public String toString() {
        return lastName+", "+name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
