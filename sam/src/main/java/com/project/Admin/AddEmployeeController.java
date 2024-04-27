
package com.project.Admin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddEmployeeController {
    private String address;
    private String city;
    private String email;
    private String name;
    private int number=0;
    private final AlertUpdateSuccessfully alertUpdateSuccessfully= new AlertUpdateSuccessfully();
    private final AlertUpdateUnsuccessfully alertUpdateUnsuccessfully =new AlertUpdateUnsuccessfully();

    private boolean bool=false;

    @FXML
    private AnchorPane addEmployeeAnchorPane;

    @FXML
    private TextField enterEmployeeAddressTextField;

    @FXML
    private TextField enterEmployeeCityTextField;

    @FXML
    private TextField enterEmployeeEmailTextField;

    @FXML
    private TextField enterEmployeeNameTextField;

    @FXML
    private TextField enterEmployeeNumberTextField;

    @FXML
    private Button submitEmployeeButton;

    static DataEmployee dataemployee=new DataEmployee();
    public static ObservableList<String> employeenamelist = dataemployee.getDataEmployeeNames();

    @FXML
    void submit(ActionEvent event) {

            try {
                address = enterEmployeeAddressTextField.getText();
                city = enterEmployeeCityTextField.getText();
                email = enterEmployeeEmailTextField.getText();
                name = enterEmployeeNameTextField.getText();
                number = Integer.parseInt(enterEmployeeNumberTextField.getText());
                checkvalid();
                alertUpdateSuccessfully.alert();


                DataEmployee.addDataEmployee(name, address, city, email, number);
                employeenamelist.setAll(dataemployee.getDataEmployeeNames());
                RecordEmployeeController.tabledata.setAll(dataemployee.getDataEmployeeTable());

                System.out.println(address + city + email + name + number);
                enterEmployeeAddressTextField.clear();
                enterEmployeeCityTextField.clear();
                enterEmployeeEmailTextField.clear();
                enterEmployeeNameTextField.clear();
                enterEmployeeNumberTextField.clear();
                number = 0;

            } catch (Exception e) {
                address = "";
                city = "";
                email = "";
                name = "";
                number = 0;
                alertUpdateUnsuccessfully.alert();

            }


    }
    private void checkvalid() throws Exception {
        if(address.isEmpty() || city.isEmpty() || email.isEmpty() || name.isEmpty() || number == 0){
            throw new Exception("Invalid data");
        }

    }





}