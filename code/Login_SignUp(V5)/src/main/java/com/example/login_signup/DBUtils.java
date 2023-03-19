package com.example.login_signup;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DBUtils {
    public static String p = HelloController.USERNAME;
    public static String signup_username = SignUpController.signUpUsername;
//    public static String PASSWORD = null;
//    public static String HashedPass;
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username, String fav_channel)
    {
        Parent root = null;
        Parent root1 = null;

        if(username != null && fav_channel != null)
        {
            try {
                FXMLLoader loader  = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                LoggedInController loggedInController = loader.getController();
                loggedInController.setUserInformation(username, fav_channel);

//                FXMLLoader loader1  = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
//                root1 = loader1.load();
//                BlogpostController blogpostController = loader1.getController();
//                blogpostController.setUserInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
        {
            try{
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();

    }
    public static void checkUserIsAvailable(ActionEvent event, String username)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if(!resultset.isBeforeFirst())
            {
                System.out.println("User Does not exit!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Sign up first!");
                alert.show();

            }
            else {
//
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

    }
    public static void updatePassword(ActionEvent event, String username, String password)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");

            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");

            psCheckUserExists.setString(1, username);

            resultset = psCheckUserExists.executeQuery();
//            UPDATE users SET password = ? WHERE username = ?
            psInsert = connection.prepareStatement("UPDATE users SET password = ? WHERE email = ?");
//            Encrypt encryptor = new Encrypt();
//            String hashedPass = Encrypt.encryptor.encryptString(password);
//            System.out.println(hashedPass);

            Encrypt.encryptString(password);

          //  psInsert.setString(1, password);
            psInsert.setString(1,Encrypt.hashedPass);
            psInsert.setString (2, username);


            psInsert.executeUpdate();

            changeScene(event, "hello-view.fxml", "Login & Register", username, null);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally{
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

    }
    public static void signUpUser(ActionEvent event, String username, String password)
    {
//        System.out.println(username);
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
            psCheckUserExists.setString(1, username);
            resultset = psCheckUserExists.executeQuery();

            if(resultset.isBeforeFirst())
            {
                System.out.println("User Already exists!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("You cannot use this username");
                alert.show();
            }
            else {
//
                psInsert = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
//
                psInsert.setString (1, username);
//                Encrypt encryptor = new Encrypt();

                Encrypt.encryptString(password);
//                System.out.println(HashedPass);
                System.out.println(Encrypt.hashedPass);
                psInsert.setString (2, Encrypt.hashedPass);

//                psInsert.setString (3);

                psInsert.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Your account has been created successfully! You are now part of our community.");
                alert.show();

//                changeScene(event, "loggedin.fxml", "sofol login", username, fav_channel);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally{
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
    }
    public static void logInUser(ActionEvent event, String username, String password)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
            preparedStatement = connection.prepareStatement("SELECT password FROM users where email = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.isBeforeFirst())
            {
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect");
                alert.show();
            }
            else {
                while(resultSet.next())
                {
                    String retrievedPassword = resultSet.getString("password");
                    String retrievedChannel = null;
                    password = Encrypt.encryptString(password);
//                    Encrypt.encryptString(password);
//                    resultSet.getInt();
                    if(password.equals(Encrypt.hashedPass))
                    {
                        changeScene(event, "loggedin.fxml", "Welcome!", username, retrievedChannel);
                    }
                    else {
                        System.out.println("Passwords didn't match");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect");
                        alert.getDialogPane().setPrefSize(600,400);
                        alert.showAndWait();
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } finally{
            if(resultSet!=null)
            {
                try{
                    resultSet.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null)
            {
                try{
                    preparedStatement.close();;
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void writeYourBlogPost(ActionEvent event, String username, String _title, String _content)
    {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultset = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shiperdb", "root", "12345");
//            System.out.println("SELECT query er aage" + username);
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE email  = ?");
//            System.out.println("NO");
            psCheckUserExists.setString(1, username);
//            System.out.println("NO");
            resultset = psCheckUserExists.executeQuery();
//            System.out.println("NO");

//            System.out.println(_title);
//            System.out.println(_content);
            psInsert = connection.prepareStatement("INSERT INTO users (title, content, email, password) VALUES (?, ?, ?, ?)");
//
            psInsert.setString (1, _title);
            psInsert.setString (2, _content);
            psInsert.setString (3, username);
            psInsert.setString (4, HelloController.PASSWORD);

//            System.out.println("NO");


//            System.out.println("NO");


//            System.out.println("NO");

            psInsert.executeUpdate();
//            System.out.println("NO");

            changeScene(event, "loggedin.fxml", "sofol login", username, null);
//            System.out.println("NO");

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

    }

}
