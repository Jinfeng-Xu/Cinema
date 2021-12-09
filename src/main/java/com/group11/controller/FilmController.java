package com.group11.controller;

import com.group11.ViewAlter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class FilmController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private TextField directorTextField;

    @FXML
    private TextField releaseTimeTextField;

    @FXML
    private Label post;

    @FXML
    private TextField durationTextField;

    @FXML
    private ImageView postImageView;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button backBtn;

    @FXML
    private TextField filmInformationTextField;

    @FXML
    private Label film;

    @FXML
    private TextField protagonistTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}