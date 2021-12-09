package com.group11.controller;

import com.group11.ViewAlter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerMainController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private Label userRoleLabel;

    @FXML
    private Button backBtn;

    @FXML
    private Button purchaseTicketsBtn;

    @FXML
    private Button resetPasswordBtn;

    @FXML
    private Button checkBillsBtn;

    @FXML
    private Label userNameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    }
}
