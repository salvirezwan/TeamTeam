package com.example.pdf;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Button button_hello;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {

        button_hello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    DBUtils.changeScene(actionEvent, "PDFForm.fxml", null, null, null);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
