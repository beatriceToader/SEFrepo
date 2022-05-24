package com.example.justsef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginAdminController implements Initializable {

    @FXML
    private Label loginMessage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private ImageView adminImageView;
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Button exitButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    private Object Users;

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //File brandingFile = new File("adminImage.png");
        // Image brandingImage = new Image(brandingFile.toURI().toString());
        // adminImageView.setImage(brandingImage);
        Image myImage=new Image(getClass().getResourceAsStream("adminImage.png"));
        adminImageView.setImage(myImage);
    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstPage.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public int validateLogin() {
        try{
            InputStream file=getClass().getResourceAsStream("admin.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String username;
            while ((username = br.readLine()) != null) {
                String password= br.readLine();
                if(username.equals((String)usernameTextField.getText())&&password.equals((String)enterPasswordField.getText())){
                    return 1;
                }
            }
            return 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if(usernameTextField.getText().isBlank()==false && enterPasswordField.getText().isBlank()==false) {
            if (validateLogin() == 1) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("featuresOfAdmin.fxml")));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                loginMessage.setText("INVALID LOGIN. Please try again.");
            }
        }
        else {
            loginMessage.setText("INVALID LOGIN. Please enter username and password.");
        }
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
