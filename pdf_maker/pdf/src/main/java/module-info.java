module com.example.pdf {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.pdf to javafx.fxml;
    exports com.example.pdf;
}