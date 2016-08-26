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
    @SerializedName("_id")
    private String _id;

    @Override
    public String toString() {
        return this.lastName+", "+this.name;
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

    public String get_id() {return _id;}

    public void set_id(String _id) {this._id = _id;}
}
