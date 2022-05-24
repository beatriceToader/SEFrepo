package com.example.justsef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Objects;

public class NewAccountController {

    @FXML
    private Label createAccountMessage;
    @FXML
    private TextField fullnameTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    @FXML
    private Button backButton;
    @FXML
    private Button createButton;
    @FXML
    private Button exitButton;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    private String str="";

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginClient.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public int validateRegistration()  {
        try{
            InputStream file=getClass().getResourceAsStream("users.txt");
            InputStreamReader fr = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(fr);
            String fullname;
            while ((fullname = br.readLine()) != null) {
                str=str+fullname+"\n";
                String email= br.readLine();
                str=str+email+"\n";
                String username= br.readLine();
                str=str+username+"\n";
                String password= br.readLine();
                str=str+password+"\n";
                if(username.equals((String)usernameTextField.getText())){
                    return 1;
                }
            }
            return 0;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public void createButtonOnAction(ActionEvent event) throws IOException {
        if(usernameTextField.getText().isBlank()==false && enterPasswordField.getText().isBlank()==false && emailTextField.getText().isBlank()==false && fullnameTextField.getText().isBlank()==false){
            if(validateRegistration()==0){
                try{
                    str=str+fullnameTextField.getText()+"\n";
                    str=str+emailTextField.getText()+"\n";
                    str=str+usernameTextField.getText()+"\n";
                    str=str+enterPasswordField.getText()+"\n";
                    PrintStream out;
                    out=new PrintStream(new FileOutputStream("users.txt"));
                    out.append(str);
                    str = "";
                }catch(Exception e){
                    e.printStackTrace();
                }
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("accountCreatedSuccessfully.fxml")));
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                createAccountMessage.setText("INVALID LOGIN. The username is already used.");
            }
        }
        else {
            createAccountMessage.setText("INVALID LOGIN. Please enter username and password.");
        }
    }

    public void exitButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
