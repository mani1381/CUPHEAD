package com.example.demo.Controller;
import com.example.demo.Model.Database;
import com.example.demo.Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.nio.file.*;
import java.util.List;
public class saveData {

    public void saveUsers(Database database) {
        try {
            FileWriter Writer = new FileWriter("src/main/resources/Users.json");
            Writer.write(new Gson().toJson(database.getUsers()));
            Writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(Database database) {
        try {

            String Users = new String(Files.readAllBytes(Paths.get("src/main/resources/Users.json")));
            if (new Gson().fromJson(Users, new TypeToken<List<User>>() {
            }.getType()) != null) {
                database.setUsers(new Gson().fromJson(Users, new TypeToken<List<User>>() {
                }.getType()));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}