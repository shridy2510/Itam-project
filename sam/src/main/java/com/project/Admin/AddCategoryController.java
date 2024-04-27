package com.project.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddCategoryController {
    private  String name;
    private String description;
    private final AlertUpdateSuccessfully alertUpdateSuccessfully= new AlertUpdateSuccessfully();
    private final AlertUpdateUnsuccessfully alertUpdateUnsuccessfully =new AlertUpdateUnsuccessfully();

    static DataCategory datacategory=new DataCategory();
    public static ObservableList<String> categorynamelist = datacategory.getDataCategoryNames();


    @FXML
    private TextArea enterCategoryDescriptionTextArea;


    @FXML
    private TextField enterCategoryNameTextField;

    @FXML
    private Button submitCategoryButton;

    @FXML
    void submit(ActionEvent event) {

            try {
                name = enterCategoryNameTextField.getText();
                description = enterCategoryDescriptionTextArea.getText();
                checkvalid();
                alertUpdateSuccessfully.alert();
                System.out.println(description + name);


                DataCategory.addDataCategory(name, description);
                categorynamelist.setAll(datacategory.getDataCategoryNames());//thay đổi list toàn bộ
                RecordCategoryController.tabledata.setAll(datacategory.getDataCategoryTable());//thay đổi table toàn bộ

                enterCategoryDescriptionTextArea.clear();
                enterCategoryNameTextField.clear();

            } catch (Exception e) {
                description = "";
                name = "";
                alertUpdateUnsuccessfully.alert();

            }


    }
    private void checkvalid() throws Exception {
        if(description.isEmpty() || name.isEmpty() ){
            throw new Exception("Invalid data");
        }
    }


}
