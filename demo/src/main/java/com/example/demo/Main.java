package com.example.demo;

import com.example.demo.Controller.saveData;
import com.example.demo.Model.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {
    public static saveData saveData = new saveData();
    public static Database database = new Database();



    public static MediaPlayer mediaPlayer;
    public static boolean turnOnMusic = true;

    public static void main(String[] args) {
        launch();
    }

    // Set up a stage to show the window
    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        saveData.loadUsers(database);
        mediaPlayer = new MediaPlayer(new Media(Main.class.getResource("MenuMusic.mp3").toURI().toString()));
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 700);
        stage.setScene(scene);
        stage.setTitle("CUPHEAD");
        stage.setResizable(false);
        stage.show();
    }

}