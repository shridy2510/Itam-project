module com.example.sam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.project.Admin to javafx.fxml;
    opens com.project.Main to javafx.fxml;
    exports com.project.Admin;
    exports com.project.Main;
}