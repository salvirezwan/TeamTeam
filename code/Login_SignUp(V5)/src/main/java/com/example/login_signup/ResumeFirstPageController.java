package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ResumeFirstPageController implements Initializable {


    @FXML
    public Button button_contact;

    @FXML
    public Button button_resume;

    @FXML
    public Button button_signIn;

    @FXML
    public ComboBox comboBox_resume;

    @FXML
    public ChoiceBox <String> myChoiceBox;
    private String [] choices = {"Resume Builder", "Resume Samples", "Resume Guidelines"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_signIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event,"hello-view.fxml","sign-In!",null,null);
            }
        });
        button_resume.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "ThreeResumeOptions.fxml", null, null, null);
            }
        });

    }
}
