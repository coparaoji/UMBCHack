package com.example.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {

    //Static for data keepinmg
    private static ArrayList<User> listOfUsers = new ArrayList<User>();
    private static int userCount = 0;

    //attributes
    private int idNum;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Group> groupsIn;
    private ArrayList<Event> eventsIn;
    private HashMap<Group, ArrayList<User> > invitesFrom;

    //Contructor
    public User( String firstName, String lastName, String email, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        listOfUsers.add(this);
        userCount++;
        idNum = listOfUsers.indexOf(this);
        groupsIn = new ArrayList<Group>();
        eventsIn = new ArrayList<Event>();
        invitesFrom = new HashMap<Group,ArrayList<User>>();

    }

    public static User find(String email){
        for(User i: listOfUsers){
            if(i.getEmail().equals(email)){
                return i;
            }
        }
        return null;
    }

    //temporary users for login
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static boolean loginCheck(User in) {
        if(User.listOfUsers.contains(in)){
            if(listOfUsers.contains(in)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) &&
                getPassword().equals(user.getPassword());
    }



    public static ArrayList<User> getListOfUsers() {
        return listOfUsers;
    }

    public static void setListOfUsers(ArrayList<User> listOfUsers) {
        User.listOfUsers = listOfUsers;
    }

    public static int getUserCount() {
        return userCount;
    }

    public static void setUserCount(int userCount) {
        User.userCount = userCount;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Group> getGroupsIn() {
        return groupsIn;
    }

    public void setGroupsIn(ArrayList<Group> groupsIn) {
        this.groupsIn = groupsIn;
    }

    public ArrayList<Event> getEventsIn() {
        return eventsIn;
    }

    public void setEventsIn(ArrayList<Event> eventsIn) {
        this.eventsIn = eventsIn;
    }

    public HashMap<Group, ArrayList<User>> getInvitesFrom() {
        return invitesFrom;
    }

    public void setInvitesFrom(HashMap<Group, ArrayList<User>> invitesFrom) {
        this.invitesFrom = invitesFrom;
    }


    /*
    this is to recieve an invitation from another user.
    This method will actually put the invite in the invite
    list so the user can accept or decline
     */
    public void invited(Group a, User b){
        //this will only be used when
        //check to see if you've been invited to this group
        if(invitesFrom.containsKey(a)){
            //if the group is there then then well add
            // user b to the list of people invint THIS user
            invitesFrom.get(a).add(b);
        }else{
            //If the group is not there then wee'll just have to create a new list
            // that will serve as the list that contains all the users from group a
            // that will ever send an invte to THIS user
            ArrayList<User> i = new ArrayList<User>();
            i.add(b);
            invitesFrom.put(a,i);
        }
    }

    //to invite another user
    //May need to add check to see if group exist
    public void invite(User a, Group b){
        if(User.listOfUsers.contains(a)){
            a.invited(b, this);
        }else{
            System.out.println("User does not exist");
        }
    }


    //adding a photo to an event
    public void add(Photo a, Event b){
        b.add(a);
    }

    //joining a group
    public void join(Group a){
        a.add(this);
    }

    //leaving group
    public void leave(Group a){
        a.remove(this);
    }



}
