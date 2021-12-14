package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Bill;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class BillListUIController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    private String customerID;

    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private Button backBtn;

    @FXML
    private VBox containerVBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
//        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
//        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);

        final List<Bill> billList = proxy.getBillByCustomerId(ViewAlter.customerID);
        HBox[] item = new HBox[billList.size()];
//        HBox[] item = new HBox[10];
        Label[] filmNameLabel = new Label[billList.size()];
        Label[] dateLabel = new Label[billList.size()];
        Label[] ticketPriceLabel = new Label[billList.size()];
        Button[] detailsButton = new Button[billList.size()];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < item.length; i++) {
            item[i] = new HBox();
            filmNameLabel[i] = new Label();
            dateLabel[i] = new Label();
            ticketPriceLabel[i] = new Label();
            detailsButton[i] = new Button();

            filmNameLabel[i].setText(billList.get(i).getFilmName());
            dateLabel[i].setText(dateFormat.format(billList.get(i).getBillDate()));
//            ticketPriceLabel[i].setText(billList.get(i).get);
            ticketPriceLabel[i].setText("999");
            detailsButton[i].setText("Details");

            filmNameLabel[i].setMinSize(120, 36);
            dateLabel[i].setMinSize(190, 36);
            ticketPriceLabel[i].setMinSize(120, 36);
            detailsButton[i].setMinSize(120, 36);

            filmNameLabel[i].setAlignment(Pos.CENTER);
            dateLabel[i].setAlignment(Pos.CENTER);
            ticketPriceLabel[i].setAlignment(Pos.CENTER);
            detailsButton[i].setAlignment(Pos.CENTER);
//            filmNameLabel[i].setStyle("-fx-text-fill:blue;");
            final int finalI = i;

            detailsButton[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    viewAlter.gotoBillDetail(billList.get(finalI).getId());
                }
            });

            item[i].getChildren().add(filmNameLabel[i]);
            item[i].getChildren().add(dateLabel[i]);
            item[i].getChildren().add(ticketPriceLabel[i]);
            item[i].getChildren().add(detailsButton[i]);

            containerVBox.getChildren().add(item[i]);
        }

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoCustomerMain();
            }
        });
    }
}
