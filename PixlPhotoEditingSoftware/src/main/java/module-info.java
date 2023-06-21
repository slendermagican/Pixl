module com.example.pixlphotoeditingsoftware {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pixlphotoeditingsoftware to javafx.fxml;
    exports com.example.pixlphotoeditingsoftware;
}