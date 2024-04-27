package com.project.Admin;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertLogoutConfirmation implements AlertHandler{
    private boolean bool;
    AlertLogoutConfirmation(){
        this.bool=false;
    }
    @Override
    public  void alert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Required");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to Log out ?");
        ButtonType buttonTypeYes = new ButtonType("Yes, Iam Sure");
        ButtonType buttonTypeCancel = new ButtonType("Cancel");

        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeYes) {
            bool=true;

        } else if (result.get() == buttonTypeCancel) {
            bool=false;
        }
    }
    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
