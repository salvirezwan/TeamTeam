package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.sql.*;


public class FpController implements Initializable {

    public static String SENDMAILTOTHISADDRESS;

    @FXML
    public Button button_send_mail;

    @FXML
    public TextField tf_email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tf_email.setFocusTraversable(false);

        button_send_mail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                String mail = tf_email.getText().trim();
                SENDMAILTOTHISADDRESS = tf_email.getText().trim();
//                System.out.println(mail);
                MyEmail myEmail = null;
//                try {
//                    myEmail.Email(mail);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
                if (!mail.isEmpty()) {
                    try {
                        Connection connection = null;
                        PreparedStatement psInsert = null;
                        PreparedStatement psCheckUserExists = null;
                        ResultSet resultset = null;

                        try{
                            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
                            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
                            psCheckUserExists.setString(1, SENDMAILTOTHISADDRESS);
                            resultset = psCheckUserExists.executeQuery();

                            if(resultset.isBeforeFirst())
                            {
                                myEmail.Email(mail);
                                DBUtils.changeScene(actionEvent, "confirmMail.fxml", "Verify yourself!", null, null);


                            }
                            else {
                                System.out.println("User Does not exit!");
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("Sign up first!");
                                alert.show();
                                DBUtils.changeScene(actionEvent, "signup.fxml", "Sign Up!", null, null);

//                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
////
//                psInsert.setString (1, username);
//
//                psInsert.setString (2, password);
//
////                psInsert.setString (3);
//
//                psInsert.executeUpdate();
//
//                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//                alert.setContentText("Your account has been created successfully! You are now part of our community.");
//                alert.show();

//                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);

                            }

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        finally{
                            if(resultset !=  null)
                            {
                                try{
                                    resultset.close();
                                }
                                catch (SQLException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                            if(psCheckUserExists != null)
                            {
                                try
                                {
                                    psCheckUserExists.close();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            if(psInsert != null)
                            {
                                try
                                {
                                    psInsert.close();
                                }
                                catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(connection != null)
                            {
                                try{
                                    connection.close();
                                }
                                catch (SQLException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Mail is not provided!!");
                    alert.show();
                }


            }
        });

    }
}
