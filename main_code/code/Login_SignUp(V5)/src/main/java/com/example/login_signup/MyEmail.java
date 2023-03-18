package com.example.login_signup;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;


public class MyEmail
{
    public static int randomNumber;

    public static void Email(String mail) throws Exception {

//        String uniqueID = UUID.randomUUID().toString();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocol","smtp");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("adnanahmad8015@gmail.com","edtvxbdjumifylxf");
            }
        });

        Message message = new MimeMessage(session);

        message.setSubject("Your Verification Code");
        int min = 100000; // minimum value
        int max = 999999; // maximum value

        // create an instance of the Random class
        Random random = new Random();

        // generate a random integer between min and max (inclusive)
        randomNumber = random.nextInt(max - min + 1) + min;

        // print the random number
       // System.out.println("Random number between " + min + " and " + max + " : " + randomNumber);

        // message.setContent("<h1>uniqeuID</h1>","text/html");
        message.setText(Integer.toString(randomNumber));
        Address addressTo = new InternetAddress(mail);
        message.setRecipient(Message.RecipientType.TO, addressTo);

        Transport.send(message);
    }
}
////import java.sql.*;
//
//   //     import java.util.Random;
//       // import javax.mail.*;
//  //      import javax.mail.internet.*;
//
// = 6;
//
//    public static void main(String[] args) {
//        String userFirstName = "John";
//        String userLastName = "Doe";
//        String userEmail = "johndoe@example.com";
//        String userCompanyDomain = getEmailDomain(userEmail);
//        String companyDomain = getCompanyDomainFromDB();
//
//        if (userCompanyDomain.equals(companyDomain)) {
//            String otp = generateOTP();
//            sendOTP(otp, userEmail);
//            System.out.println("OTP has been sent to " + userEmail);
//            // code to insert user data and OTP to database
//        } else {public class MyEmail {
//
//            private static final String DB_URL = "jdbc:mysql://localhost:3306/";
//            private static final String DB_USER = "root";
//            private static final String DB_PASSWORD = "password";
//            private static final String COMPANY_EMAIL = "company@example.com";
//            private static final String COMPANY_EMAIL_PASSWORD = "password";
//            private static final String OTP_CHARS = "0123456789";
//            private static final int OTP_LENGTH
//            System.out.println("Invalid email domain");
//        }
//    }
//
//    private static String getEmailDomain(String email) {
//        String[] parts = email.split("@");
//        return parts[1];
//    }
//
//    private static String getCompanyDomainFromDB() {
//        String domain = null;
//        try {
//            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//            Statement stmt = conn.createStatement();
//            String sql = "SELECT domain FROM companies WHERE name='Example Company'";
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                domain = rs.getString("domain");
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return domain;
//    }
//
//    private static String generateOTP() {
//        StringBuilder sb = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < OTP_LENGTH; i++) {
//            int index = random.nextInt(OTP_CHARS.length());
//            char c = OTP_CHARS.charAt(index);
//            sb.append(c);
//        }
//        return sb.toString();
//    }
//
//    private static void sendOTP(String otp, String toEmail) {
//        String fromEmail = COMPANY_EMAIL;
//        String password = COMPANY_EMAIL_PASSWORD;
//        String host = "smtp.gmail.com";
//        String port = "587";
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", host);
//        props.put("mail.smtp.port", port);
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        });
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(fromEmail));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            message.setSubject("OTP for sign-up");
//            message.setText("Your OTP for sign-up is: " + otp);
//            Transport.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//}
