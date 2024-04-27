package com.project.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Text loginIncorrectText;

    @FXML
    private TextField loginNameTextField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Button loginSignInButton;
    String loginName;
    String loginPassword;
    @FXML
    void login(ActionEvent event) throws IOException {
        loginName=loginNameTextField.getText();
        loginPassword=loginPasswordField.getText();

        if(loginName.equals("Admin") && loginPassword.equals("12345")){
            System.out.println("Hello");
            Stage stage=(Stage)loginSignInButton.getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("/com/project/admin/MainAdmin.fxml"));
            Scene scene = new Scene(root,1250,800);//rộng, cao của scene
            stage.setTitle("IT ASSET MANAGEMENT SOFTWARE");
            stage.setScene(scene);
            stage.show();

            loginIncorrectText.setVisible(false);


        }
        else{
            loginfaied();
        }


    }

    private void loginfaied() {
        if (loginName.isEmpty()) {
            loginIncorrectText.setText("Please enter your username. ");
            loginIncorrectText.setVisible(true);
        }
        else {
            loginIncorrectText.setText("Your username or password is incorrect.");
            loginIncorrectText.setVisible(true);

        }
    }
}
