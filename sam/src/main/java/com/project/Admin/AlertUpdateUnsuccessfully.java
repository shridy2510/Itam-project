package com.project.Admin;

import javafx.scene.control.Alert;

public class AlertUpdateUnsuccessfully implements AlertHandler {

    @Override
    public void alert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Seem like something is wrong! Your ìnformation is not submitted! Please enter your information and submit again !");
        alert.showAndWait();




        }


    }

