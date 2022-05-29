package com.example.demo.View.MenuControllers;


import com.example.demo.Main;
import com.example.demo.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
import java.util.Objects;

public class LeaderboardController {
    @FXML
    ArrayList<TextField> playersTime = new ArrayList<>();
    @FXML
    ArrayList<TextField> playersHighScore = new ArrayList<>();
    @FXML
    ArrayList<TextField> playersUsername = new ArrayList<>();
    @FXML
    ArrayList<ImageView> playersAvatar = new ArrayList<>();

    @FXML
    protected void onCancelButtonClick(ActionEvent event) throws IOException {
        switchToProfileMenu(event);
    }

    @FXML
    public void initialize() throws FileNotFoundException {

        ArrayList<User> users = Main.database.getUsers();
        for (int i = 0; i < users.size(); i++) {

            for (int j = i + 1; j < users.size(); j++) {

                User tmp;
                if (users.get(j).getHighScore() > users.get(i).getHighScore()) {
                    tmp = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, tmp);
                } else if (users.get(j).getHighScore() == users.get(i).getHighScore()) {
                    if (users.get(j).getTime().compareTo(users.get(i).getTime()) < 0) {
                        tmp = users.get(i);
                        users.set(i, users.get(j));
                        users.set(j, tmp);
                    }
                }
            }

        }

        for (int i = 0; i < users.size(); i++) {
            playersUsername.get(i).setText(users.get(i).getUsername());
            playersTime.get(i).setText(users.get(i).getTime());
            playersHighScore.get(i).setText(Integer.toString(users.get(i).getHighScore()));
            playersAvatar.get(i).setImage(new Image(new FileInputStream(users.get(i).getProfilePicture())));


        }


    }

    public void switchToProfileMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("profileMenu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
