package com.project.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;


public class AddAssetController implements Initializable {
    private String name;
    private int quantity;
    private final AlertUpdateSuccessfully alertUpdateSuccessfully= new AlertUpdateSuccessfully();
    private final AlertUpdateUnsuccessfully alertUpdateUnsuccessfully =new AlertUpdateUnsuccessfully();

    @FXML
    private AnchorPane addAssetAnchorPane;

    @FXML
    private TextField enterAssetNameTextField;

    @FXML
    private TextField enterQuantityTextfield;

    @FXML
    private ChoiceBox<String> selectCategoryChoiceBox;

    @FXML
    private ChoiceBox<String> selectCompanyChoiceBox;

    @FXML
    private ChoiceBox<String> selectEmployeeChoiceBox;

    @FXML
    private ChoiceBox<String> selectLicenseChoiceBox;


    @FXML
    private Button submitAssetButton;
    public static DataAsset dataasset=new DataAsset();




    @FXML
    void submit(ActionEvent event) {

            try {
                name = enterAssetNameTextField.getText();
                quantity = Integer.parseInt(enterQuantityTextfield.getText());
                checkvalid();

                alertUpdateSuccessfully.alert();
                dataasset.addDataAsset(name, quantity, selectEmployeeChoiceBox.getValue(), selectCompanyChoiceBox.getValue(), selectCategoryChoiceBox.getValue(), selectLicenseChoiceBox.getValue());


                RecordAssetController.tabledata.setAll(dataasset.getDataAssetTable());

                System.out.println(quantity + name);

                enterAssetNameTextField.clear();
                enterQuantityTextfield.clear();
                selectCompanyChoiceBox.setValue(null);
                selectEmployeeChoiceBox.setValue(null);
                selectCategoryChoiceBox.setValue(null);
                selectLicenseChoiceBox.setValue(null);



            } catch (Exception e) {
                quantity = 0;
                name = "";
                alertUpdateUnsuccessfully.alert();

            }



    }

    private void checkvalid() throws Exception {
        if(name.isEmpty() || quantity==0 ||selectCategoryChoiceBox.getValue() == null ||selectCompanyChoiceBox.getValue() == null
                ||selectEmployeeChoiceBox.getValue() == null||selectLicenseChoiceBox.getValue() == null){
            throw new Exception("Invalid data");
        }
    }



    DataLicense datalicense=new DataLicense();
    String[] arraylicense=datalicense.getLicense();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        selectLicenseChoiceBox.getItems().addAll(arraylicense);
        selectCompanyChoiceBox.setItems(AddCompanyController.companynamelist);//đưa vào choice box list
        selectEmployeeChoiceBox.setItems(AddEmployeeController.employeenamelist);
        selectCategoryChoiceBox.setItems(AddCategoryController.categorynamelist);








    }


}



