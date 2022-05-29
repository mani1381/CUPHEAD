package com.example.demo.Controller;


import com.example.demo.Model.Database;
import com.example.demo.Model.User;

public class LoginController {

    private final Database database;

    public LoginController(Database database) {
        this.database = database;
    }

    public boolean isNewUser(String username) {
        for (int i = 0; i< database.getUsers().size();i++) {
            if (database.getUsers().get(i).getUsername().equals(username)) {
                return false;
            }
        }

        return true;
    }

    public boolean isPasswordCorrect(String username, String password) {
        for (User user : database.getUsers()) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void addUser(String username, String password, String profilePicture) {
        User user = new User(username, password, profilePicture);
        database.getUsers().add(user);

    }

    public User getUserByUsername(String username) {
        for (User user : database.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
