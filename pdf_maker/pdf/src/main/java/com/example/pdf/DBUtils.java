package com.example.pdf;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {
    //public static String p = HelloController.USERNAME;
    //public static String signup_username = SignUpController.signUpUsername;
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String fav_channel) throws IOException {
        Parent root = null;
        Parent root1 = null;

        FXMLLoader loader  = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
        root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }


}
