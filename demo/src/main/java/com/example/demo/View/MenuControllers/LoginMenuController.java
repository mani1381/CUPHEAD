package com.example.demo.View.MenuControllers;


import com.example.demo.Controller.LoginController;
import com.example.demo.Main;
import com.example.demo.View.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.*;
import java.util.Objects;

public class LoginMenuController {

    // Strings which hold css elements to easily re-use in the application
    protected String successMessage = "-fx-text-fill: GREEN;";
    LoginController loginController = new LoginController(Main.database);
    String errorMessage = "-fx-text-fill: RED;";
    String errorStyle = "-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;";
    String successStyle = "-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;";

    // Import the application's controls


    @FXML
    private TextField signUpUsernameTextField;






    public static Stage stage;
   public static Scene scene;


    // Creation of methods which are activated on events in the forms

    @FXML
    private TextField loginUsernameTextField;

    @FXML
    protected void onCancelButtonClick() {
        Main.saveData.saveUsers(Main.database);
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Label invalidSignupCredentials;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException {
        if (loginUsernameTextField.getText().isBlank() || loginPasswordPasswordField.getText().isBlank()) {
            invalidLoginCredentials.setText("The Login fields are required!");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidSignupCredentials.setText("");

            if (loginUsernameTextField.getText().isBlank()) {
                loginUsernameTextField.setStyle(errorStyle);
            } else if (loginPasswordPasswordField.getText().isBlank()) {
                loginPasswordPasswordField.setStyle(errorStyle);
            }
        } else if (loginController.isNewUser(loginUsernameTextField.getText()) || !loginController.isPasswordCorrect(loginUsernameTextField.getText(), loginPasswordPasswordField.getText())) {
            invalidLoginCredentials.setText("Incorrect username or password");
            invalidLoginCredentials.setStyle(errorMessage);
            invalidSignupCredentials.setText("");
        } else {
            Main.database.setActiveUser(loginController.getUserByUsername(loginUsernameTextField.getText()));
            switchToProfileMenu(event);
        }
    }

    @FXML
    private TextField signUpPasswordPasswordField;

    @FXML
    protected void onSignUpButtonClick() {

        if (signUpUsernameTextField.getText().isBlank() || signUpPasswordPasswordField.getText().isBlank()) {
            invalidSignupCredentials.setText("Please fill in all fields!");
            invalidSignupCredentials.setStyle(errorMessage);
            invalidLoginCredentials.setText("");

            if (signUpUsernameTextField.getText().isBlank()) {
                signUpUsernameTextField.setStyle(errorStyle);
            } else if (signUpPasswordPasswordField.getText().isBlank()) {
                signUpPasswordPasswordField.setStyle(errorStyle);
            }
        } else if (!loginController.isNewUser(signUpUsernameTextField.getText())) {
            invalidSignupCredentials.setText("There is another user with this username");
            invalidSignupCredentials.setStyle(errorMessage);
            invalidLoginCredentials.setText("");
            signUpUsernameTextField.setStyle(errorStyle);

        } else {
            invalidSignupCredentials.setText("You are set!");
            invalidSignupCredentials.setStyle(successMessage);
            signUpUsernameTextField.setStyle(successStyle);
            signUpPasswordPasswordField.setStyle(successStyle);
            invalidLoginCredentials.setText("");
            File file = new File("");
            String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/users.png";
            loginController.addUser(signUpUsernameTextField.getText(), signUpPasswordPasswordField.getText(), directoryName);
        }
    }

    @FXML
    private Button cancelButton;
    public void switchToProfileMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("profileMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onLoginAsGuest(ActionEvent event) throws Exception {

        Main.database.setActiveUser(null);

        Main.mediaPlayer.stop();
        GameScene gameScene = new GameScene();
        Scene scene = gameScene.getScene();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        scene.getRoot().getChildrenUnmodifiable().get(0).requestFocus();
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private Label invalidLoginCredentials;

    @FXML
    private TextField loginPasswordPasswordField;


}