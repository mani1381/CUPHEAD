package com.example.demo.Model;

public class User {

    private String username;
    public void setUsername(String username) {
        this.username = username;
    }
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    private String profilePicture;
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    public String getProfilePicture() {
        return profilePicture;
    }
    private int highScore = 0;

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore() {
        return highScore;
    }

    private String time = "00:00";

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }
    public String getTime() {
        return time;
    }

    public String getPassword() {
        return password;
    }

    public User(String username, String password, String profilePicture) {
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;

    }



}

