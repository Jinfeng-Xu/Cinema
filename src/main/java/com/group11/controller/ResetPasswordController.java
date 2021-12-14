package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.service.CoreSystem;
import com.group11.service.LoginService;
import com.group11.service.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ResetPasswordController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private Button resetBtn;

    @FXML
    private ComboBox<String> role;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private Button backBtn;

    @FXML
    private TextField oldPasswordTextField;

    @FXML
    private TextField confirmPasswordTextField;

    @FXML
    private TextField currentUserTextField;

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

        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userName;
                String oldPassword;
                String newPassword;
                String confirmPassword;
                boolean resetState;
                String type = role.getValue();
                if (type != null) {
                    userName = currentUserTextField.getText();
                    oldPassword = oldPasswordTextField.getText();
                    newPassword = newPasswordTextField.getText();
                    confirmPassword = confirmPasswordTextField.getText();
                    if (type.equals("Customer")) {
                        resetState = proxy.changeCustomer(userName, oldPassword, newPassword, confirmPassword);
                        if (resetState) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("reset Successfully (Customer)");
                            alert.showAndWait();
                            viewAlter.gotoLogin();
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("reset Filed (Customer)");
                            alert.showAndWait();
                        }
                    }
                    else {
                        resetState = proxy.changeAdministrator(userName, oldPassword, newPassword, confirmPassword);
                        if (resetState) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("reset Successfully (Administrator)");
                            alert.showAndWait();
                            viewAlter.gotoLogin();
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("reset Filed (Administrator)");
                            alert.showAndWait();
                        }
                    }
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Please choose your role.");
                    alert.showAndWait();
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
