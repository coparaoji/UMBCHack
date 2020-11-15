package com.example.myapplication;

import java.util.ArrayList;
import java.util.Objects;

public class Group {
    private static ArrayList<Group> listOfGroups = new ArrayList<Group>();
    private static int numOfGroups = 0;

    private int id;
    private User owner;
    private String name;
    private ArrayList<User> userArrayList;
    private ArrayList<Event> eventArrayList;

    public Group(User owner, String name) {
        this.owner = owner;
        this.name = name;
        listOfGroups.add(this);
        id  = listOfGroups.indexOf(this);
        userArrayList = new ArrayList<User>();
        userArrayList.add(owner);
        eventArrayList = new ArrayList<Event>();
    }

    //add event to events list
    public void add(Event a){
        eventArrayList.add(a);
    }

    //remove event
    public void remove(Event a){
        eventArrayList.remove(a);
    }

    //add user
    public void add(User a){
        userArrayList.add(a);
    }

    //remove user
    public void remove(User a){
        userArrayList.remove(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return getId() == group.getId() &&
                getOwner().equals(group.getOwner()) &&
                getName().equals(group.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOwner(), getName());
    }

    public static ArrayList<Group> getListOfGroups() {
        return listOfGroups;
    }

    public static void setListOfGroups(ArrayList<Group> listOfGroups) {
        Group.listOfGroups = listOfGroups;
    }

    public static int getNumOfGroups() {
        return numOfGroups;
    }

    public static void setNumOfGroups(int numOfGroups) {
        Group.numOfGroups = numOfGroups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<Event> getEventArrayList() {
        return eventArrayList;
    }

    public void setEventArrayList(ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
    }


}
