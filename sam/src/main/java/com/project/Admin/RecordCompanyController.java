package com.project.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class RecordCompanyController implements Initializable {
    static DataCompany datacompany= new DataCompany();
    static ObservableList<Company> tabledata= datacompany.getDataCompanyTable();
    private final AlertDeleteConfirmation deletealert=new AlertDeleteConfirmation();
    private final AlertEditConfirmation editalert=new AlertEditConfirmation();
    @FXML
    private Button deleteCompanyRecordButton;

    @FXML
    private Button editCompanyRecordButton;

    @FXML
    private TableColumn<Company, String> recordAddressCompanyColumn;

    @FXML
    private TableColumn<Company, String> recordCityCompanyColumn;

    @FXML
    private TableView<Company> recordCompanyTableView;

    @FXML
    private TableColumn<Company, Integer> recordContactCompanyColumn;

    @FXML
    private TableColumn<Company, String> recordEmailCompanyColumn;

    @FXML
    private TableColumn<Company, String> recordNameCompanyColumn;

    @FXML
    private TableColumn<Company, Integer> recordNoCompanyColumn;

    @FXML
    private TextField editCompanyAddressTextField;

    @FXML
    private TextField editCompanyCityTextField;

    @FXML
    private TextField editCompanyContactTextField;

    @FXML
    private TextField editCompanyEmailTextField;

    @FXML
    private TextField editCompanyNameTextField;





    @FXML
    void delete(ActionEvent event) {
        Company companyrow= recordCompanyTableView.getSelectionModel().getSelectedItem();
        if(companyrow!=null){deletealert.alert();}
        if (companyrow != null && deletealert.isBool()) {
            int id=companyrow.getNo();
            datacompany.deleteRowFromDB(id);

            tabledata.setAll(datacompany.getDataCompanyTable());
            AddCompanyController.companynamelist.setAll(datacompany.getDataCompanyNames());;


            System.out.println(id);
            deletealert.setBool(false);
            editCompanyNameTextField.setText("");
            editCompanyAddressTextField.setText("");
            editCompanyCityTextField.setText("");
            editCompanyEmailTextField.setText("");
            editCompanyContactTextField.setText("");
        }
    }

    @FXML
    void edit(ActionEvent event) {
        Company companyrow= recordCompanyTableView.getSelectionModel().getSelectedItem();
        if(companyrow!=null){editalert.alert();}
        if (companyrow != null && editalert.isBool()) {
            int id=companyrow.getNo();
            String name=editCompanyNameTextField.getText();
            String address =editCompanyAddressTextField.getText();
            String city =editCompanyCityTextField.getText();
            String email =editCompanyEmailTextField.getText();
            int contact =Integer.parseInt(editCompanyContactTextField.getText());
            datacompany.updateRowCompany(id,name,address,city,email,contact);

            tabledata.setAll(datacompany.getDataCompanyTable());
            AddCompanyController.companynamelist.setAll(datacompany.getDataCompanyNames());


            editalert.setBool(false);
            editCompanyNameTextField.setText("");
            editCompanyAddressTextField.setText("");
            editCompanyCityTextField.setText("");
            editCompanyEmailTextField.setText("");
            editCompanyContactTextField.setText("");

        }

    }
    @FXML
    void onMouseClick(MouseEvent event) {
        Company companyrow= recordCompanyTableView.getSelectionModel().getSelectedItem();
        editCompanyAddressTextField.setText(String.valueOf(companyrow.getAddress()));
        editCompanyCityTextField.setText(String.valueOf(companyrow.getCity()));
        editCompanyContactTextField.setText(String.valueOf(companyrow.getContact()));
        editCompanyEmailTextField.setText(String.valueOf(companyrow.getEmail()));
        editCompanyNameTextField.setText(String.valueOf(companyrow.getName()));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordNoCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        recordNameCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        recordAddressCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        recordCityCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        recordEmailCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        recordContactCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        recordCompanyTableView.setItems(tabledata);

    }
}
