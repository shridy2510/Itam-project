package com.project.Admin;

import javafx.scene.control.Alert;

public  class AlertUpdateSuccessfully implements AlertHandler{
    @Override
    public  void alert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Update Successfully!");
        alert.setHeaderText(null);
        alert.setContentText("You have submit successfully");
        alert.showAndWait();


    }
}
