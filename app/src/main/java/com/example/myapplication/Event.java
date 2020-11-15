package com.example.myapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Event {
    private static ArrayList<Event> listOfEvents = new ArrayList<Event>();
    private static int numOfEvents = 0;

    private int id;
    private String name;
    private Date date;
    private ArrayList<Photo> pics;

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
        listOfEvents.add(this);
        id = listOfEvents.indexOf(this);
        pics = new ArrayList<Photo>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return getId() == event.getId() &&
                getName().equals(event.getName());
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
     */

    public void add(Photo a){
        this.pics.add(a);
    }

    public void remove(Photo a){
        this.pics.remove(a);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Photo> getPics() {
        return pics;
    }

    public void setPics(ArrayList<Photo> pics) {
        this.pics = pics;
    }
}
