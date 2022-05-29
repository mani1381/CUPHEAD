package com.example.demo.View.MenuControllers;

import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ChooseAvatar {


    @FXML
    public void switchToProfileMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("profileMenu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void chooseDevil() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "cart.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);
    }

    @FXML
    protected void chooseCuphead() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "cupHead.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);
    }


    @FXML
    protected void chooseKettle() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "kettle.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);
    }

    @FXML
    protected void chooseGoopy() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "goopy.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);
    }

    @FXML
    protected void chooseKingDice() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "kingDice.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);
    }

    @FXML
    protected void chooseMugMan() {


        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        directoryName += "mugman.png";
        Main.database.getActiveUser().setProfilePicture(directoryName);

    }
}




