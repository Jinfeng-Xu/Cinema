package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();

    @FXML
    private TextField userNameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private ComboBox<String> role;

    @FXML
    private Button loginBtn;

    @FXML
    private Button gotoRegisterBtn;

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    public LoginController() {
    }

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


        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean type;
                String userName;
                String password;
                int loginState;
                userName = userNameTextField.getText();
                password = passwordTextField.getText();
                System.out.println(role.getValue());
                if (role.getValue() != null) {
                    type = role.getValue().equals("Customer");
                    loginState = proxy.login(userName, password, type);
                    if (loginState == 2) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("login failed");
                        alert.show();
                    } else if (loginState == 0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("login Successfully (Customer)");
                        alert.show();
                        viewAlter.gotoCustomerMain();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("login Successfully (Administrator)");
                        alert.show();
                        viewAlter.gotoAdministratorMain();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please choose your role.");
                    alert.show();
                }
            }
        });

        gotoRegisterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoRegister();
            }
        });
    }
}
