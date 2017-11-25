package com.labs.maverick.projectevo.model;

/**
 * Created by Maverick on 25/11/2017.
 */

public class Servicios {
    private String name;
    private String date;
    private String time;

    public Servicios(){

    }

    public Servicios(String name,String date,String time){
        this.name = name;
        this.date = date;
        this.time = time;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
