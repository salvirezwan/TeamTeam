package com.example.pdf;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PDFController {
    @FXML
    private TextField searchCV;
    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField contact;
    @FXML
    private TextField permAdd;
    @FXML
    private TextField jobTitle1;
    @FXML
    private TextField jobTitle2;
    @FXML
    private TextField jobTitle3;
    @FXML
    private TextField comp1;
    @FXML
    private TextField comp2;
    @FXML
    private TextField comp3;
    @FXML
    private TextField jobStart1;
    @FXML
    private TextField jobStart2;
    @FXML
    private TextField jobStart3;
    @FXML
    private TextField jobEnd1;
    @FXML
    private TextField jobEnd2;
    @FXML
    private TextField jobEnd3;
    @FXML
    private TextField SSCyear;
    @FXML
    private TextField SSCinst;
    @FXML
    private TextField SSCGPA;
    @FXML
    private TextField HSCyear;
    @FXML
    private TextField HSCinst;
    @FXML
    private TextField HSCGPA;
    @FXML
    private TextField batchelorYear;
    @FXML
    private TextField batchelorInst;
    @FXML
    private TextField batchelorCGPA;
    @FXML
    private TextField gitLink;
    @FXML
    private ImageView photo;
    @FXML
    private TextArea Interests;
    @FXML
    private TextArea References;

    @FXML
    protected void onCLickSave(ActionEvent event) throws IOException {
        String searchcv = searchCV.getText();
        String nam = name.getText();
        String mail = email.getText();
        String cont = contact.getText();
        String peradd = permAdd.getText();
        String jt1 = jobTitle1.getText();
        String jt2 = jobTitle2.getText();
        String jt3 = jobTitle3.getText();
        String c1 = comp1.getText();
        String c2 = comp2.getText();
        String c3 = comp3.getText();
        String js1 = jobStart1.getText();
        String js2 = jobStart2.getText();
        String js3 = jobStart3.getText();
        String je1 = jobEnd1.getText();
        String je2 = jobEnd2.getText();
        String je3 = jobEnd3.getText();
        String ssy = SSCyear.getText();
        String ssi = SSCinst.getText();
        String ssgpa = SSCGPA.getText();
        String hsy = HSCyear.getText();
        String hsi = HSCinst.getText();
        String hsgpa = HSCGPA.getText();
        String by = batchelorYear.getText();
        String bi = batchelorInst.getText();
        String bcg = batchelorCGPA.getText();
        String git = gitLink.getText();
        Image i = photo.getImage();
        String intr = Interests.getText();
        String ref = References.getText();




        try {
            FileWriter fw = new FileWriter("info.txt");
            PrintWriter outf = new PrintWriter(fw);

            outf.println("--------Swift CV--------");
            outf.println("-------------Your CV Info-------------");
            outf.println("_________________________________");

            outf.println("CV type: " + searchcv + "\n");
            outf.println("Name:\t\t " + nam + "\n");
            outf.println("Email:\t\t " + mail + "\n");
            outf.println("Contact:\t\t " + cont + "\n");
            outf.println("Permanent Address:\t\t " + peradd + "\n");
            outf.println("Job Title 1:\t\t " + jt1 + "\n");
            outf.println("Job Title 2:\t\t " + jt2 + "\n");
            outf.println("Job Title 3:\t\t " + jt3 + "\n");
            outf.println("Company 1:\t\t " + c1 + "\n");
            outf.println("Company 2:\t\t " + c2 + "\n");
            outf.println("Company 3:\t\t " + c3 + "\n");
            outf.println("SSC Year:\t\t " + ssy + "\n");
            outf.println("SSC Institution:\t\t " + ssi + "\n");
            outf.println("SSC GPA:\t\t " + ssgpa + "\n");
            outf.println("HSC Year:\t\t " + hsy + "\n");
            outf.println("HSC Institution:\t\t " + hsi + "\n");
            outf.println("HSC GPA:\t\t " + hsgpa + "\n");
            outf.println("Bachelor Year:\t\t " + by + "\n");
            outf.println("Bachelor Institution:\t\t " + bi + "\n");
            outf.println("Bachelor GPA:\t\t " + bcg + "\n");
            outf.println("Git link:\t\t " + git + "\n");
            outf.println("Interests:\t\t " + intr + "\n");
            outf.println("References:\t\t " + ref + "\n");

            outf.close();

            System.out.println("Data written to the file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(searchcv + " " + nam + " " + mail);




        //Platform.exit();
    }

    @FXML
    protected void onClickDownload(ActionEvent event) throws IOException {

    }

    @FXML
    protected void onClickAddPhoto(ActionEvent event) throws IOException {

    }


    @FXML
    protected void filltexts() {
        String searchcv = searchCV.getText();
        String nam = name.getText();
        String mail = email.getText();
        String cont = contact.getText();
        String peradd = permAdd.getText();
        String jt1 = jobTitle1.getText();
        String jt2 = jobTitle2.getText();
        String jt3 = jobTitle3.getText();
        String c1 = comp1.getText();
        String c2 = comp2.getText();
        String c3 = comp3.getText();
        String js1 = jobStart1.getText();
        String js2 = jobStart2.getText();
        String js3 = jobStart3.getText();
        String je1 = jobEnd1.getText();
        String je2 = jobEnd2.getText();
        String je3 = jobEnd3.getText();
        String ssy = SSCyear.getText();
        String ssi = SSCinst.getText();
        String ssgpa = SSCGPA.getText();
        String hsy = HSCyear.getText();
        String hsi = HSCinst.getText();
        String hsgpa = HSCGPA.getText();
        String by = batchelorYear.getText();
        String bi = batchelorInst.getText();
        String bcg = batchelorCGPA.getText();
        String git = gitLink.getText();
        Image i = photo.getImage();
        String intr = Interests.getText();
        String ref = References.getText();









        System.out.println(searchcv + " " + nam + " " + mail);

    }
}