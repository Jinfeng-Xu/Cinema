package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.observer.SeatsObserver;
import com.group11.pojo.Screen;
import com.group11.pojo.Seat;
import com.group11.pojo.TimeTable;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class SeatsUIController implements Initializable, Observer {
    private static ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private TextField screenTypeTextField;

    @FXML
    private VBox SeatsVBox;

    @FXML
    private TextField screenIDTextField;

    @FXML
    private Button backBtn;

    @FXML
    private Button confirmBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);

        TimeTable timeTable = proxy.getInitTimeTable(ViewAlter.timetableId);
        Screen screen = proxy.getScreen(timeTable.getScreenId());
        Seat[][] seatList = timeTable.getSeats();
        CheckBox[][] currentSeat = new CheckBox[seatList.length][seatList[0].length];
        HBox[] hBox = new HBox[seatList[0].length];
        screenIDTextField.setText(screen.getId());
        screenTypeTextField.setText(screen.getType());

        for (int m = 0; m < seatList.length; m++) {
            hBox[m] = new HBox();
            for (int n = 0; n < seatList[m].length; n++) {
                currentSeat[m][n] = new CheckBox();
                currentSeat[m][n].setMinSize(36, 36);
                currentSeat[m][n].setDisable(!seatList[m][n].isEmpty());
                hBox[m].getChildren().add(currentSeat[m][n]);
            }
            SeatsVBox.getChildren().add(hBox[m]);
        }

        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String seatId = null;
                for (int i = 0; i < seatList.length; i++) {
                    for (int j = 0; j < seatList[i].length; j++) {
                        if (((CheckBox) ((HBox) SeatsVBox.getChildren().get(i)).getChildren().get(j)).isSelected()) {
                            seatId = seatList[i][j].getId();
                            seatList[i][j].setEmpty(false);
                        }
                    }
                }
                boolean createState = proxy.createBill(ViewAlter.customerID, timeTable, seatId);
                if (createState) {
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setContentText("Create Successfully");
//                    alert.show();
                    viewAlter.gotoSeats(timeTable.getId());
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Create Failed");
                    alert.showAndWait();
                }
            }
        });

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoTimeTable();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Seat seat = (Seat)arg;
        System.out.println("Order Row: " + seat.getSeatRow()+", Coloum: " + seat.getSeatColumn() + " successfully.");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Order Row: " + seat.getSeatRow()+", Coloum: " + seat.getSeatColumn() + " successfully.");
        alert.showAndWait();
    }
}