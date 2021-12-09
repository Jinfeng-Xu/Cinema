package com.group11.controller;

import com.group11.ViewAlter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ResetPasswordController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private Button resetBtn;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private TextField oldPasswordTextField;

    @FXML
    private Button backBtn;

    @FXML
    private TextField confirmPasswordTextField;

    @FXML
    private TextField currentUserTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoCustomerMain();
            }
        });
    }
}
