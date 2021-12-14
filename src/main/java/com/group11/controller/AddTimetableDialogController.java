package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Film;
import com.group11.pojo.TimeTable;
import com.group11.service.*;
import com.group11.util.TimeUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class AddTimetableDialogController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private DatePicker startTimeDatePicker;

    @FXML
    private ComboBox<String> filmIdComboBox;

    @FXML
    private ComboBox<String> screenIdComboBox;

    @FXML
    private Button addTimetableBtn;

    @FXML
    private TextField priceTextFiled;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);

        screenIdComboBox.getItems().add("1");
        screenIdComboBox.getItems().add("2");
        screenIdComboBox.getItems().add("3");
        screenIdComboBox.getItems().add("4");
        screenIdComboBox.getItems().add("5");

        List<Film> filmList = proxy.getFilm();
        Map<String, String> nameToId = new HashMap<>();
        for (int i = 0; i < filmList.size(); i++) {
            filmIdComboBox.getItems().add(filmList.get(i).getName());
            nameToId.put(filmList.get(i).getName(), filmList.get(i).getId());
        }

        addTimetableBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String filmId = nameToId.get(filmIdComboBox.getValue());
                String screenId = screenIdComboBox.getValue();
                String priceText = priceTextFiled.getText();
                LocalDate releaseTime = startTimeDatePicker.getValue();
                Date time = TimeUtils.LocalDateToUpdate(releaseTime);
                TimeTable timeTable = proxy.addTimeTable(time, screenId, filmId, priceText);
                if (timeTable != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Add Successfully");
                    alert.showAndWait();
                    EditTimeTableController.refresh();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Add Filed");
                    alert.showAndWait();
                }
            }
        });
    }
}
