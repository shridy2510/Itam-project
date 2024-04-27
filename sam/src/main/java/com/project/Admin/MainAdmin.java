package com.project.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAdmin extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Parent root=FXMLLoader.load(getClass().getResource("MainAdmin.fxml"));
        Scene scene = new Scene(root,1250,800);//rộng, cao của scene
        stage.setTitle("IT ASSET MANAGEMENT SOFTWARE");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}