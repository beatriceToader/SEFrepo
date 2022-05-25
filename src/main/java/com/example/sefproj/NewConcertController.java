package com.example.sefproj;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class NewConcertController implements Initializable {

    @FXML
    private Text addText;
    @FXML
    private Label addConcertMessage;
    @FXML
    private ImageView newConcertView;
    @FXML
    private TextField artistTextField;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField timeTextField;
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

    private String str="";
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image myImage=new Image(getClass().getResourceAsStream("Concert.png"));
        newConcertView.setImage(myImage);
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("featuresOfAdmin.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public int validateRegistration()  {
        try{
            InputStream file=getClass().getResourceAsStream("concerts.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String artist;
            while ((artist = br.readLine()) != null) {
                str=str+artist+"\n";
                String date= br.readLine();
                str=str+date+"\n";
                String time= br.readLine();
                str=str+time+"\n";
                if(artist.equals((String)artistTextField.getText())&&date.equals((String)dateTextField.getText())&&time.equals((String)timeTextField.getText())){
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
        if(artistTextField.getText().isBlank()==false && dateTextField.getText().isBlank()==false && timeTextField.getText().isBlank()==false) {
            if(validateRegistration()==0) {
                try{
                    str=str+artistTextField.getText()+"\n";
                    str=str+dateTextField.getText()+"\n";
                    str=str+timeTextField.getText()+"\n";
                    PrintStream out;
                    out=new PrintStream(new FileOutputStream("concerts.txt"));
                    out.append(str);
                    str = "";
                }catch(Exception e){
                    e.printStackTrace();
                }
                addConcertMessage.setText("Concert added succesfully");
            }
            else {
                addConcertMessage.setText("Concert already added!");
            }
        }
        else {
            addConcertMessage.setText("INVALID ADD. Please enter informations.");
        }
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}

