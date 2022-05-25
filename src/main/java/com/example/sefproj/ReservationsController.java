package com.example.sefproj;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class ReservationsController {

    @FXML
    private Text madeRezervationsText;
    @FXML
    private Label rezervationsDetailsMessage;
    @FXML
    private Button backButton;
    @FXML
    private Button exitButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    private String str="";

    public void displayRezervations(){
        try{
            InputStream file=getClass().getResourceAsStream("reservations.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String username;
            while ((username = br.readLine()) != null) {
                str=str+"USERNAME: "+username+"         ";
                String concert= br.readLine();
                str=str+"CONCERT: "+concert+" ";
                String date= br.readLine();
                str=str+"DATE: "+date+" ";
                String time= br.readLine();
                str=str+"TIME: "+time+"\n";
            }
            rezervationsDetailsMessage.setText(str);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("featuresOfAdmin.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}