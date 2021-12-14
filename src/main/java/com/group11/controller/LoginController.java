package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Administrator;
import com.group11.pojo.Customer;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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
    private Button resetBtn;

    @FXML
    private ComboBox<String> role;

    @FXML
    private Button loginBtn;

    @FXML
    private Button gotoRegisterBtn;



    public LoginController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        role.getItems().add("Customer");
        role.getItems().add("Administrator");

        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);


        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean type;
                String userName;
                String password;
                Object loginRole;
                userName = userNameTextField.getText();
                password = passwordTextField.getText();
//                System.out.println(role.getValue());
                if (role.getValue() != null) {
                    type = role.getValue().equals("Customer");
                    loginRole = proxy.login(userName, password, type);
                    if (loginRole == null) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setContentText("login failed");
                        alert.showAndWait();
                    } else if (loginRole instanceof Customer) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("login Successfully (Customer)");
                        alert.showAndWait();
                        viewAlter.initGotoCustomerMain(((Customer) loginRole).getId(), userName);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("login Successfully (Administrator)");
                        alert.showAndWait();
                        viewAlter.initGotoAdministratorMain(((Administrator) loginRole).getId(), userName);
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please choose your role.");
                    alert.showAndWait();
                }
            }
        });

        gotoRegisterBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoRegister();
            }
        });
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoResetPassword();
            }
        });
    }
}
