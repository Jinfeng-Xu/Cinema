package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.service.CoreSystem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdministratorMainController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private Label userRoleLabel;

    @FXML
    private Button editTimetableBtn;

    @FXML
    private Button checkBillsBtn;

    @FXML
    private Button editFilmListBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Label userNameLabel;

    @FXML
    private Button resetPasswordBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userRoleLabel.setText("Administrator");
        userNameLabel.setText(ViewAlter.administratorName);
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoLogin();
            }
        });
        resetPasswordBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoResetPassword();
            }
        });
        editFilmListBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoEditFilmList();
            }
        });
        editTimetableBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoEditTimetable();
            }
        });
        checkBillsBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoAllBillList();
            }
        });
    }
}
