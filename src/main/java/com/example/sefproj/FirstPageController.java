package com.example.sefproj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FirstPageController implements Initializable {

    @FXML
    private Text ConcertHallText;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Button adminButton;
    @FXML
    private Button clientButton;
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
        /*File brandingFile = new File("src/images/concertHall.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);*/
        Image myImage=new Image(getClass().getResourceAsStream("concertHall.jpg"));
        brandingImageView.setImage(myImage);
    }

    public void adminButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginAdmin.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void clientButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginClient.fxml")));
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