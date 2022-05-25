package com.example.justsef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DeleteConcertController implements Initializable {

    @FXML
    private Text deleteText;
    @FXML
    private Label deleteConcertMessage;
    @FXML
    private ImageView deleteConcertView;
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

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image myImage=new Image(getClass().getResourceAsStream("Concert.png"));
        deleteConcertView.setImage(myImage);
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("featuresOfAdmin.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private String str="";
    public int validateDelete()  {
        int flag=0;
        try{
            InputStream file=getClass().getResourceAsStream("concerts.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String artist;
            while ((artist = br.readLine()) != null) {
                String date= br.readLine();
                String time= br.readLine();
                if(artist.equals((String)artistTextField.getText())&&date.equals((String)dateTextField.getText())&&time.equals((String)timeTextField.getText())){
                    flag=1;
                }
                else{
                    str=str+artist+"\n";
                    str=str+date+"\n";
                    str=str+time+"\n";
                }
            }
            return flag;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public void saveButtonOnAction(ActionEvent event) throws IOException {
        if(artistTextField.getText().isBlank()==false && dateTextField.getText().isBlank()==false && timeTextField.getText().isBlank()==false) {
            if(validateDelete()==1) {
                try{
                    PrintStream out;
                    out=new PrintStream(new FileOutputStream("concerts.txt"));
                    out.append(str);
                    str = "";
                }catch(Exception e){
                    e.printStackTrace();
                }
                deleteConcertMessage.setText("Concert deleted successfully");
            }
            else {
                deleteConcertMessage.setText("Concert does not exist in the list!");
            }
        }
        else {
            deleteConcertMessage.setText("INVALID DELETE. Please enter informations.");
        }
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}