package com.example.demo.Controller;

import com.example.demo.Model.*;

public class ProfileController {

    public void changePassword(User user, String password) {
        user.setPassword(password);
    }

    private final Database database;

    public void changeUsername(User user, String username) {
        user.setUsername(username);
    }
    private final User user;

    public ProfileController(User user, Database database) {
        this.user = user;
        this.database = database;
    }

    public void deleteAccount() {
        this.database.getUsers().remove(this.user);
    }






}
