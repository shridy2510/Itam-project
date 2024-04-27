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

public class RecordEmployeeController implements Initializable {
    static DataEmployee dataemployee= new DataEmployee();
    static ObservableList<Employee> tabledata= dataemployee.getDataEmployeeTable();
    private final AlertDeleteConfirmation deletealert=new AlertDeleteConfirmation();
    private final AlertEditConfirmation editalert=new AlertEditConfirmation();
    @FXML
    private Button deleteEmployeeRecordButton;

    @FXML
    private Button editEmployeeRecordButton;

    @FXML
    private TableColumn<Employee, String> recordAddressEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> recordCityEmployeeColumn;

    @FXML
    private TableColumn<Employee, Integer> recordContactEmployeeColumn;

    @FXML
    private TableColumn<Employee, String> recordEmailEmployeeColumn;

    @FXML
    private TableView<Employee> recordEmployeeTableView;

    @FXML
    private TableColumn<Employee, String> recordNameEmployeeColumn;

    @FXML
    private TableColumn<Employee, Integer> recordNoEmployeeColumn;

    @FXML
    private TextField editEmployeeAddressTextField;

    @FXML
    private TextField editEmployeeCityTextField;

    @FXML
    private TextField editEmployeeContactTextField;

    @FXML
    private TextField editEmployeeEmailTextField;

    @FXML
    private TextField editEmployeeNameTextField;

    @FXML
    void delete(ActionEvent event) {
        Employee employeerow= recordEmployeeTableView.getSelectionModel().getSelectedItem();
        if(employeerow!=null){deletealert.alert();}
        if (employeerow != null && deletealert.isBool()) {
            int id=employeerow.getNo();
            dataemployee.deleteRowFromDB(id);

            tabledata.setAll(dataemployee.getDataEmployeeTable());
            AddEmployeeController.employeenamelist.setAll(dataemployee.getDataEmployeeNames());

            System.out.println(id);
            deletealert.setBool(false);
            editEmployeeNameTextField.setText("");
            editEmployeeAddressTextField.setText("");
            editEmployeeCityTextField.setText("");
            editEmployeeEmailTextField.setText("");
            editEmployeeContactTextField.setText("");
        }

    }

    @FXML
    void edit(ActionEvent event) {
        Employee employeerow= recordEmployeeTableView.getSelectionModel().getSelectedItem();
        if(employeerow!=null){editalert.alert();}
        if (employeerow != null && editalert.isBool()) {
            int id=employeerow.getNo();
            String name=editEmployeeNameTextField.getText();
            String address =editEmployeeAddressTextField.getText();
            String city =editEmployeeCityTextField.getText();
            String email =editEmployeeEmailTextField.getText();
            int contact =Integer.parseInt(editEmployeeContactTextField.getText());
            dataemployee.updateRowEmployee(id,name,address,city,email,contact);

            tabledata.setAll(dataemployee.getDataEmployeeTable());
            AddEmployeeController.employeenamelist.setAll(dataemployee.getDataEmployeeNames());

            editalert.setBool(false);
            editEmployeeNameTextField.setText("");
            editEmployeeAddressTextField.setText("");
            editEmployeeCityTextField.setText("");
            editEmployeeEmailTextField.setText("");
            editEmployeeContactTextField.setText("");
        }

    }
    @FXML
    void onMouseClick(MouseEvent event) {
        Employee employeerow= recordEmployeeTableView.getSelectionModel().getSelectedItem();
        editEmployeeAddressTextField.setText(String.valueOf(employeerow.getAddress()));
        editEmployeeCityTextField.setText(String.valueOf(employeerow.getCity()));
        editEmployeeContactTextField.setText(String.valueOf(employeerow.getContact()));
        editEmployeeEmailTextField.setText(String.valueOf(employeerow.getEmail()));
        editEmployeeNameTextField.setText(String.valueOf(employeerow.getName()));

    }



        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        recordNoEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        recordNameEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        recordAddressEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        recordCityEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        recordEmailEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        recordContactEmployeeColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));
        recordEmployeeTableView.setItems(tabledata);

    }


}
