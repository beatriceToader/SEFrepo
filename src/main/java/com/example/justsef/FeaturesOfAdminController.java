package com.example.justsef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FeaturesOfAdminController {

    @FXML
    private Button concertsButton;
    @FXML
    private Button rezervationsButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
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


    public void concertsButtonOnAction(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("listOfConcerts.fxml"));
            root=loader.load();

            ListOfConcertsController scene2=loader.getController();
            scene2.displayConcerts();

            //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResultRAMScene.fxml")));
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void rezervationsButtonOnAction(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("reservations.fxml"));
            root=loader.load();

            ReservationsController scene2=loader.getController();
            scene2.displayRezervations();

            //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ResultRAMScene.fxml")));
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void deleteButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("listOfConcerts.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newConcert.fxml")));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void backButtonOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginAdmin.fxml")));
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
