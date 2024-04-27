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

public class RecordAssetController implements Initializable {
    static DataAsset dataasset= new DataAsset();
    static ObservableList<Asset> tabledata= dataasset.getDataAssetTable();
    private final AlertDeleteConfirmation deletealert=new AlertDeleteConfirmation();
    private final AlertEditConfirmation editalert=new AlertEditConfirmation();

    @FXML
    private Button deleteAssetRecordButton;

    @FXML
    private Button editAssetRecordButton;
    @FXML
    private TableColumn<Asset, String> RecordLicenseAssetColumn;

    @FXML
    private TableView<Asset> recordAssetTableView;

    @FXML
    private TableColumn<Asset, String> recordCategoryAssetColumn;

    @FXML
    private TableColumn<Asset, String> recordCompanyAssetColumn;

    @FXML
    private TableColumn<Asset, String> recordEmployeeAssetColumn;

    @FXML
    private TableColumn<Asset, String> recordNameAssetColumn;

    @FXML
    private TableColumn<Asset, Integer> recordNoAssetColumn;

    @FXML
    private TableColumn<Asset, Integer> recordQuantityAssetColumn;

    @FXML
    private ChoiceBox<String> editAssetCategoryChoiceBox;

    @FXML
    private ChoiceBox<String> editAssetCompanyChoiceBox;

    @FXML
    private ChoiceBox<String> editAssetEmployeeChoiceBox;

    @FXML
    private ChoiceBox<String> editAssetLicenseChoiceBox;

    @FXML
    private TextField editAssetNameTextField;

    @FXML
    private TextField editAssetQuantityTextField;

    @FXML
    void delete(ActionEvent event) {
        Asset assetrow= recordAssetTableView.getSelectionModel().getSelectedItem();
        if(assetrow!=null){deletealert.alert();}
        if (assetrow != null && deletealert.isBool()) {
            int id=assetrow.getNo();
            dataasset.deleteRowFromDB(id);
            //chỉnh lại table,
            tabledata.setAll(dataasset.getDataAssetTable());



            deletealert.setBool(false);
            editAssetNameTextField.setText("");
            editAssetQuantityTextField.setText("");
            editAssetEmployeeChoiceBox.setValue(null);
            editAssetCompanyChoiceBox.setValue(null);
            editAssetCategoryChoiceBox.setValue(null);
            editAssetLicenseChoiceBox.setValue(null);

        }

    }

    @FXML
    void edit(ActionEvent event) {
        Asset assetrow= recordAssetTableView.getSelectionModel().getSelectedItem();
        if(assetrow!=null){editalert.alert();}
        if (assetrow != null && editalert.isBool()) {
            int id=assetrow.getNo();
            String name=editAssetNameTextField.getText();
            int quantity=Integer.parseInt(editAssetQuantityTextField.getText());
            String employee=editAssetEmployeeChoiceBox.getValue();
            String company=editAssetCompanyChoiceBox.getValue();
            String category=editAssetCategoryChoiceBox.getValue();
            String license= editAssetLicenseChoiceBox.getValue();
            dataasset.updateRowAsset(id,name,quantity,employee,company,category,license);
            tabledata.setAll(dataasset.getDataAssetTable());

            //xoá hiển thị sau khi chọn xong, đưa về trạng thái ban đầu
            editalert.setBool(false);
            editAssetNameTextField.setText("");
            editAssetQuantityTextField.setText("");
            editAssetEmployeeChoiceBox.setValue(null);
            editAssetCompanyChoiceBox.setValue(null);
            editAssetCategoryChoiceBox.setValue(null);
            editAssetLicenseChoiceBox.setValue(null);


        }




    }
    @FXML
    void onMouseClick(MouseEvent event) {
        Asset assetrow= recordAssetTableView.getSelectionModel().getSelectedItem();
        editAssetNameTextField.setText(String.valueOf(assetrow.getName()));
        editAssetQuantityTextField.setText(String.valueOf(assetrow.getQuantity()));
        editAssetCompanyChoiceBox.setValue(assetrow.getCompanyName());
        editAssetCategoryChoiceBox.setValue(assetrow.getCategoryName());
        editAssetEmployeeChoiceBox.setValue(assetrow.getEmployeeName());
        editAssetLicenseChoiceBox.setValue(assetrow.getLicense());


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//hiển thị bảng
        recordNoAssetColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        recordNameAssetColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        recordQuantityAssetColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        recordEmployeeAssetColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        recordCompanyAssetColumn.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        recordCategoryAssetColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        RecordLicenseAssetColumn.setCellValueFactory(new PropertyValueFactory<>("license"));
        recordAssetTableView.setItems(tabledata);
//hiển thị choicebox
        DataLicense datalicense=new DataLicense();
        String[] arraylicense=datalicense.getLicense();
        editAssetLicenseChoiceBox.getItems().addAll(arraylicense);
        ObservableList<String> companynameList= AddCompanyController.companynamelist;
        editAssetCompanyChoiceBox.setItems(companynameList);//thay list mới hoàn toàn
        ObservableList<String> employeenameList= AddEmployeeController.employeenamelist;
        editAssetEmployeeChoiceBox.setItems(employeenameList);
        ObservableList<String> categorynameList= AddCategoryController.categorynamelist;
        editAssetCategoryChoiceBox.setItems(categorynameList);

    }
}
