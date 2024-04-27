package com.project.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCompanyController {
    private String address;
    private String city;
    private String email;
    private String name;
    private int number=0;
    private final AlertUpdateSuccessfully alertUpdateSuccessfully= new AlertUpdateSuccessfully();
    private final AlertUpdateUnsuccessfully alertUpdateUnsuccessfully =new AlertUpdateUnsuccessfully();

    static DataCompany datacompany=new DataCompany();
    public static ObservableList<String> companynamelist = datacompany.getDataCompanyNames();




    @FXML
    private TextField enterCompanyAddressTextField;

    @FXML
    private TextField enterCompanyCityTextField;

    @FXML
    private TextField enterCompanyEmailTextField;

    @FXML
    private TextField enterCompanyNameTextField;

    @FXML
    private TextField enterCompanyNumberTextField;

    @FXML
    private Button submitCompanyButton;

    @FXML
    void submit(ActionEvent event) {

            try{
                address= enterCompanyAddressTextField.getText();
                city=enterCompanyCityTextField.getText();
                email=enterCompanyEmailTextField.getText();
                name=enterCompanyNameTextField.getText();
                number=Integer.parseInt(enterCompanyNumberTextField.getText());
                checkvalid();
                alertUpdateSuccessfully.alert();

                DataCompany.addDataCompany(name,address,city,email,number);
                companynamelist.setAll(datacompany.getDataCompanyNames());
                RecordCompanyController.tabledata.setAll(datacompany.getDataCompanyTable());


                System.out.println(address + city + email + name + number);
                enterCompanyAddressTextField.clear();
                enterCompanyCityTextField.clear();
                enterCompanyEmailTextField.clear();
                enterCompanyNameTextField.clear();
                enterCompanyNumberTextField.clear();
                number = 0;

            }
            catch(Exception e){
                address="";
                city="";
                email="";
                name="";
                number=0;
                alertUpdateUnsuccessfully.alert();

            }



    }
    private void checkvalid() throws Exception {
        if (address.isEmpty() || city.isEmpty() || email.isEmpty() || name.isEmpty() || number == 0) {
            throw new Exception("Invalid data");
        }
    }





}


