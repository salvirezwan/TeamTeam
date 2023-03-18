package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class ResumeSamplesController implements Initializable {


    @FXML
    public Button button_accountant;
    @FXML

    public Button button_business;
    @FXML
    public Button button_cashier;

    @FXML
    public Button button_engineer;

    @FXML
    public Button button_designer;

    @FXML
    public Button button_developer;

    @FXML
    public Button button_manager;

    @FXML
    public Button button_nurse;

    @FXML
    public Button button_intern;

    @FXML
    public Button button_doctor;

    @FXML
    public Button button_tutor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





            button_accountant.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DBUtils.changeScene(actionEvent, "Accountant.fxml", null, null, null);
                }
            });


    }
}
