package com.project.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class RecordCategoryController implements Initializable {
    static DataCategory datacategory= new DataCategory();
    static ObservableList<Category> tabledata= datacategory.getDataCategoryTable();
    private final AlertDeleteConfirmation deletealert=new AlertDeleteConfirmation();
    private final AlertEditConfirmation editalert=new AlertEditConfirmation();


    @FXML
    private Button deleteCategoryRecordButton;

    @FXML
    private Button editCategoryRecordButton;

    @FXML
    private TableView<Category> recordCategoryTableView;

    @FXML
    private TableColumn<Category, String> recordDescriptionCategoryColumn;

    @FXML
    private TableColumn<Category, String> recordNameCategoryColumn;

    @FXML
    private TableColumn<Category, Integer> recordNoCategoryColumn;
    @FXML
    private TextArea editCategoryDescriptionTextArea;

    @FXML
    private TextField editCategoryNameTextField;


    @FXML
    void delete(ActionEvent event) {
        Category categoryrow= recordCategoryTableView.getSelectionModel().getSelectedItem();
        if(categoryrow!=null){deletealert.alert();}
        if (categoryrow != null && deletealert.isBool()) {
            int id=categoryrow.getNo();
            datacategory.deleteRowFromDB(id);
            //chỉnh lại table , choice box
            tabledata.setAll(datacategory.getDataCategoryTable());
            AddCategoryController.categorynamelist.setAll(datacategory.getDataCategoryNames());

            System.out.println(id);
            deletealert.setBool(false);
            editCategoryNameTextField.setText("");
            editCategoryDescriptionTextArea.setText("");
        }

    }

    @FXML
    void edit(ActionEvent event) {
        Category categoryrow= recordCategoryTableView.getSelectionModel().getSelectedItem();
        if(categoryrow!=null){editalert.alert();}
        if (categoryrow != null && editalert.isBool()) {
            int id=categoryrow.getNo();
            String name=editCategoryNameTextField.getText();
            String description=editCategoryDescriptionTextArea.getText();
            datacategory.updateRowCategory(id,name,description);

            tabledata.setAll(datacategory.getDataCategoryTable());
            AddCategoryController.categorynamelist.setAll(datacategory.getDataCategoryNames());

            editalert.setBool(false);
            editCategoryNameTextField.setText("");
            editCategoryDescriptionTextArea.setText("");
        }

    }
    @FXML
    void onMouseClick(MouseEvent event) {
        Category categoryrow= recordCategoryTableView.getSelectionModel().getSelectedItem();
        editCategoryNameTextField.setText(String.valueOf(categoryrow.getName()));
        editCategoryDescriptionTextArea.setText(String.valueOf(categoryrow.getDescription()));
    }



        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordNoCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        recordNameCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        recordDescriptionCategoryColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        recordCategoryTableView.setItems(tabledata);




    }

}
