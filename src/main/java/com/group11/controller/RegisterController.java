package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.service.CoreSystem;
import com.group11.service.LoginService;
import com.group11.service.LoginServiceImpl;
import com.group11.service.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }
    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerBtn;

    @FXML
    private Button backBtn;

    @FXML
    private ComboBox<String> role;

    @FXML
    private PasswordField confirmPasswordTextField;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        role.getItems().add("Customer");
        role.getItems().add("Administrator");

        //        BookingService bookingService = new BookingServiceImpl();
//        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

//        proxy.setBookingSystem(bookingService);
//        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);

        registerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean type;
                String userName;
                String password;
                String confirmPassword;
                Integer registerState;
                userName = userNameTextField.getText();
                password = passwordTextField.getText();
                confirmPassword = confirmPasswordTextField.getText();
                if (role.getValue() != null) {
                    type = role.getValue().equals("Customer");
                    registerState = proxy.register(userName, password, confirmPassword, type);
                    if (registerState == 2) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("register failed");
                        alert.show();
                    }
                    else if (registerState == 1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("register Successfully (Administrator)");
                        alert.show();
                        viewAlter.gotoLogin();
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("register Successfully (Customer)");
                        alert.show();
                        viewAlter.gotoLogin();
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please choose your role.");
                    alert.show();
                }
            }
        });

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoLogin();
            }
        });
    }
}
