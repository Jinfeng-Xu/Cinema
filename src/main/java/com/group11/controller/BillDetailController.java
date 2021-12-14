package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Bill;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class BillDetailController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = admin;
    }

    private String billID;

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField filmNameTextField;

    @FXML
    private TextField screenTypeTextField;

    @FXML
    private TextField screenIDTextField;

    @FXML
    private Button removeBtn;

    @FXML
    private TextField columnTextField;

    @FXML
    private Button backBtn;

    @FXML
    private TextField rowTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Bill bill = proxy.getBillById(ViewAlter.billID);

        dateTextField.setText(dateFormat.format(bill.getBillDate()));
        filmNameTextField.setText(bill.getFilmName());
        screenTypeTextField.setText(bill.getScreenType());
        screenIDTextField.setText(bill.getScreenId());
        rowTextField.setText(bill.getSeatRow());
        columnTextField.setText(bill.getSeatColumn());

        removeBtn.setText("Remove");
        removeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                proxy.removeBill(ViewAlter.billID);
                viewAlter.backFromBillDetail();
            }
        });

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.backFromBillDetail();
            }
        });

    }
}
