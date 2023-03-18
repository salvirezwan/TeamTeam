package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ThreeResumeOptionsController implements Initializable {
    @FXML
    public Button button_resumebuilder;
    @FXML

    public Button button_resumesamples;
    @FXML
    public Button button_resumeguidelines;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        button_resumesamples.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "ResumeSamples.fxml", null, null, null);
            }
        });
        button_resumebuilder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "resume_builder.fxml", null, null, null);
            }
        });
        button_resumeguidelines.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "ResumeGuidelines.fxml", null, null, null);
            }
        });

    }
}
