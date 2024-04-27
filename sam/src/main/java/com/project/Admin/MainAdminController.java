package com.project.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainAdminController {
        private final AlertLogoutConfirmation alert=new AlertLogoutConfirmation();


        @FXML
        private Tab addAssetTab;

        @FXML
        private Tab addCategoryTab;

        @FXML
        private Tab addCompanyTab;

        @FXML
        private Tab addEmployeeTab;

        @FXML
        private Tab recordAssetTab;

        @FXML
        private Tab recordCategoryTab;

        @FXML
        private Tab recordCompanyTab;

        @FXML
        private Tab recordEmployeeTab;

        @FXML
        private TabPane tabPane;
        @FXML
        private Button logoutAdminButton;
        @FXML
        void addAssetButton() {
                if(addAssetTab!=null){
                        tabPane.getTabs().add(addAssetTab);
                }
                tabPane.getSelectionModel().select(addAssetTab);

        }

        @FXML
        void addCategoryButton(ActionEvent event) {
                if(addCategoryTab!=null){
                        tabPane.getTabs().add(addCategoryTab);
                }
                tabPane.getSelectionModel().select(addCategoryTab);


        }

        @FXML
        void addCompanyButton(ActionEvent event) {
                if(addCompanyTab!=null){
                        tabPane.getTabs().add(addCompanyTab);
                }
                tabPane.getSelectionModel().select(addCompanyTab);




        }

        @FXML
        void addEmployeeButton(ActionEvent event) {
                if(addEmployeeTab!=null){
                        tabPane.getTabs().add(addEmployeeTab);
                }
                tabPane.getSelectionModel().select(addEmployeeTab);


        }

        @FXML
        void recordAssetButton(ActionEvent event) {
                if(recordAssetTab!=null){
                        tabPane.getTabs().add(recordAssetTab);
                }
                tabPane.getSelectionModel().select(recordAssetTab);


        }

        @FXML
        void recordCategoryButton(ActionEvent event) {
                if(recordCategoryTab!=null){
                        tabPane.getTabs().add(recordCategoryTab);
                }
                tabPane.getSelectionModel().select(recordCategoryTab);


        }

        @FXML
        void recordCompanyButton(ActionEvent event) {
                if(recordCompanyTab!=null){
                        tabPane.getTabs().add(recordCompanyTab);
                }
                tabPane.getSelectionModel().select(recordCompanyTab);


        }

        @FXML
        void recordEmployeeButton(ActionEvent event) {
                if(recordEmployeeTab!=null){
                        tabPane.getTabs().add(recordEmployeeTab);
                }
                tabPane.getSelectionModel().select(recordEmployeeTab);


        }

        @FXML
        void logout(ActionEvent event) throws IOException {
                alert.alert();
                if(alert.isBool()){
                System.out.println("Hello");
                Stage stage=(Stage)logoutAdminButton.getScene().getWindow();
                Parent root= FXMLLoader.load(getClass().getResource("/com/project/Main/Main.fxml"));
                Scene scene = new Scene(root,1250,800);//rộng, cao của scene
                stage.setTitle("IT ASSET MANAGEMENT SOFTWARE");
                stage.setScene(scene);
                stage.show();}
                alert.setBool(false);

        }


}
