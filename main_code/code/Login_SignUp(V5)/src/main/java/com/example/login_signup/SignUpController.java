package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public static String signUpUsername;
    @FXML
    public TextField tf_username;
    @FXML
    public TextField tf_password;
    @FXML
    public Button button_login;
    @FXML
    public Button button_sign_up;
    @FXML
    public RadioButton rb_wittcode;
    @FXML
    public RadioButton rb_someone_else;
    @FXML
    public PasswordField pf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ToggleGroup toggleGroup = new ToggleGroup();
//        rb_wittcode.setToggleGroup(toggleGroup);
//        rb_someone_else.setToggleGroup(toggleGroup);
//
//        rb_wittcode.setSelected(true);

        button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                if(!tf_username.getText().trim().isEmpty() && !pf_password.getText().trim().isEmpty())
                {
//                    System.out.println("aage" + signUpUsername);
                    signUpUsername = tf_username.getText();
//                    System.out.println("pore" + signUpUsername);
                    DBUtils.signUpUser(actionEvent, signUpUsername, pf_password.getText());
                }
                else
                {
                    System.out.println("Please fill in all information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up");
                    alert.show();
                }
            }
        });

        button_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DBUtils.changeScene(actionEvent,"hello-view.fxml", "Sign Up", null, null);
            }
        });
    }
}
