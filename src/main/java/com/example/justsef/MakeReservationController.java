package com.example.justsef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class MakeReservationController {

    @FXML
    private Text makeReservationText;
    @FXML
    private Label reservationSuccessfullyMessage;
    @FXML
    private TextField concertNameTextField;
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button exitButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("featuresOfClient.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private String str="";
    public int validateReservation()  {
        try{
            InputStream file=getClass().getResourceAsStream("concerts.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String artist;
            while ((artist = br.readLine()) != null) {
                String date= br.readLine();
                String time= br.readLine();
                if(artist.equals((String)concertNameTextField.getText())){
                    str=str+artist+"\n";
                    str=str+date+"\n";
                    str=str+time+"\n";
                    return 1;
                }
            }
            return 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void saveButtonOnAction(ActionEvent event) throws IOException {
        if(concertNameTextField.getText().isBlank()==false) {
            str=str+LoginClientController.getTheUsername()+"\n";
            if(validateReservation()==1) {
                try{
                    PrintStream out;
                    out=new PrintStream(new FileOutputStream("reservations.txt"));
                    out.append(str);
                    str = "";
                }catch(Exception e){
                    e.printStackTrace();
                }
                reservationSuccessfullyMessage.setText("Your reservation has been added successfully");
            }
            else {
                reservationSuccessfullyMessage.setText("INVALID RESERVATION. Please enter the name of another concert!");
            }
        }
        else {
            reservationSuccessfullyMessage.setText("INVALID RESERVATION. Please enter the name of the concert!");
        }
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
