package com.example.demo.Model;

import java.util.ArrayList;

public class Database {

    private ArrayList<User> users = new ArrayList<>();

    private User activeUser;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
