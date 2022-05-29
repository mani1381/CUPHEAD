package com.example.demo.View.MenuControllers;

import com.example.demo.Main;
import com.example.demo.View.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    private Stage stage ;

    @FXML
    private Button cancelButton;

    @FXML
    public void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onLeaderboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("leaderboard.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onStartGame(ActionEvent event) throws Exception {
        Main.mediaPlayer.stop();
        GameScene gameScene = new GameScene();
        Scene scene = gameScene.getScene();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        scene.getRoot().getChildrenUnmodifiable().get(0).requestFocus();
        stage.setResizable(false);
        stage.show();
    }

}
