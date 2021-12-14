package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.TimeTable;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

public class TimetableController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();

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
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);

        final List<TimeTable> timeTableList = proxy.getTimeTables();
        HBox[] item = new HBox[timeTableList.size()];
        final Label[] filmNameLabel = new Label[timeTableList.size()];
        Label[] startTimeLabel = new Label[timeTableList.size()];
        Label[] screenIDLabel = new Label[timeTableList.size()];
        Label[] ticketPriceLabel = new Label[timeTableList.size()];
        Button[] buyButton = new Button[timeTableList.size()];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < item.length; i++) {
            item[i] = new HBox();
            filmNameLabel[i] = new Label();
            startTimeLabel[i] = new Label();
            screenIDLabel[i] = new Label();
            ticketPriceLabel[i] = new Label();
            buyButton[i] = new Button();

            filmNameLabel[i].setText(proxy.getFilm(timeTableList.get(i).getFilmId()).getName());
            startTimeLabel[i].setText(dateFormat.format(timeTableList.get(i).getStartTime()));
            screenIDLabel[i].setText(timeTableList.get(i).getScreenId());
            ticketPriceLabel[i].setText(timeTableList.get(i).getPrice());
            buyButton[i].setText("Buy");

            filmNameLabel[i].setPrefSize(90, 36);
            startTimeLabel[i].setPrefSize(190, 36);
            screenIDLabel[i].setPrefSize(90, 36);
            ticketPriceLabel[i].setPrefSize(90, 36);
            buyButton[i].setPrefSize(90, 36);

            filmNameLabel[i].setAlignment(Pos.CENTER);
            startTimeLabel[i].setAlignment(Pos.CENTER);
            screenIDLabel[i].setAlignment(Pos.CENTER);
            ticketPriceLabel[i].setAlignment(Pos.CENTER);
            buyButton[i].setAlignment(Pos.CENTER);
            filmNameLabel[i].setStyle("-fx-text-fill:blue;");
            final int finalI = i;

            filmNameLabel[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    viewAlter.gotoFilmDetail(timeTableList.get(finalI).getFilmId());
                }
            });


            buyButton[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    viewAlter.gotoSeats(timeTableList.get(finalI).getId());
                }
            });

            item[i].getChildren().add(filmNameLabel[i]);
            item[i].getChildren().add(startTimeLabel[i]);
            item[i].getChildren().add(screenIDLabel[i]);
            item[i].getChildren().add(ticketPriceLabel[i]);
            item[i].getChildren().add(buyButton[i]);

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
