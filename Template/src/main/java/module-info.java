module com.example.templateaddview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.templateaddview to javafx.fxml;
    exports com.example.templateaddview;
}