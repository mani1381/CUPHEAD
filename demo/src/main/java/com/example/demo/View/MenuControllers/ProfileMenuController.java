package com.example.demo.View.MenuControllers;

import java.io.*;
import com.example.demo.Controller.*;
import com.example.demo.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.Random;
import java.util.Objects;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class ProfileMenuController {

    @FXML
    public ProfileController profileController = new ProfileController(Main.database.getActiveUser(), Main.database);
    @FXML
    public LoginController loginController = new LoginController(Main.database);
    String successMessage = "-fx-text-fill: GREEN;";
    String errorMessage = "-fx-text-fill: RED;";
    String errorStyle = "-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;";
    String successStyle = "-fx-border-color: #A9A9A9; -fx-border-width: 2; -fx-border-radius: 5;";
    @FXML
    private Button cancelButton;

    @FXML
    private Label invalidSignupCredentials;

    @FXML
    private TextField signUpUsernameTextField;

    @FXML
    private TextField signUpPasswordPasswordField;

    @FXML
    private Label invalidChangePasswordCredentials;


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void logoutButton(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginMenu.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void deleteAccountButton(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account");
        alert.setHeaderText("You're about to delete your account!");
        alert.setContentText("Are you sure you want to delete your account?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            profileController.deleteAccount();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("loginMenu.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    protected void onCancelButtonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("MainMenu.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onChangeUsernameButton() {

        if (signUpUsernameTextField.getText().isBlank()) {
            invalidSignupCredentials.setText("Please fill in all fields!");
            invalidSignupCredentials.setStyle(errorMessage);
            signUpUsernameTextField.setStyle(errorStyle);
            return;

        } else if (!loginController.isNewUser(signUpUsernameTextField.getText())) {
            invalidSignupCredentials.setText("There is another user with this username");
            invalidSignupCredentials.setStyle(errorMessage);
            signUpUsernameTextField.setStyle(errorStyle);
            return;

        }
            invalidSignupCredentials.setText("Username changed successfully!");
            invalidSignupCredentials.setStyle(successMessage);
            signUpUsernameTextField.setStyle(successStyle);
            profileController.changeUsername(Main.database.getActiveUser(), signUpUsernameTextField.getText());
    }

    @FXML
    protected void onChangePasswordButton() {

        if (signUpPasswordPasswordField.getText().isBlank()) {
            invalidChangePasswordCredentials.setText("Please fill in all fields!");
            invalidChangePasswordCredentials.setStyle(errorMessage);
            signUpPasswordPasswordField.setStyle(errorStyle);
            return;

        } else if (Main.database.getActiveUser().getPassword().equals(signUpPasswordPasswordField.getText())) {
            invalidChangePasswordCredentials.setText("New password can not be same as the old password");
            invalidChangePasswordCredentials.setStyle(errorMessage);
            signUpPasswordPasswordField.setStyle(errorStyle);
            return;

        }
            invalidChangePasswordCredentials.setText("Password changed successfully!");
            invalidChangePasswordCredentials.setStyle(successMessage);
            signUpPasswordPasswordField.setStyle(successStyle);
            profileController.changePassword(Main.database.getActiveUser(), signUpPasswordPasswordField.getText());
    }

    @FXML
    protected void randomAvatar() {

        Random rn = new Random();
        int answer = rn.nextInt(6);
        File file = new File("");
        String directoryName = file.getAbsoluteFile() + "/src/main/resources/com/example/demo/";
        switch (answer) {
            case 0: {
                directoryName += "cart.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
            case 1: {
                directoryName += "cupHead.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
            case 2: {
                directoryName += "kettle.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
            case 3: {
                directoryName += "goopy.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
            case 4: {
                directoryName += "kingDice.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
            case 5: {
                directoryName += "mugman.png";
                Main.database.getActiveUser().setProfilePicture(directoryName);
                break;
            }
        }


    }

    @FXML
    protected void onChooseAvatar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("chooseAvatar.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void start() {

        try {

            // create a File chooser
            FileChooser fil_chooser = new FileChooser();
            FileChooser.ExtensionFilter fileExtensions = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png");

            fil_chooser.getExtensionFilters().add(fileExtensions);
            File file = fil_chooser.showOpenDialog(stage);

            if (file != null) {

                Main.database.getActiveUser().setProfilePicture(file.getAbsolutePath());

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


}
