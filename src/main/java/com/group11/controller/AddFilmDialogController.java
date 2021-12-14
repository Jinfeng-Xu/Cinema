package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Film;
import com.group11.service.*;
import com.group11.util.FormatUtils;
import com.group11.util.TimeUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AddFilmDialogController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private DatePicker releaseTimeDatePicker;

    @FXML
    private TextArea infoTextArea;

    @FXML
    private TextField nameTextFiled;

    @FXML
    private TextField durationTextFiled;

    @FXML
    private TextField protagonistTextFiled;

    @FXML
    private Button addFilmBtn;

    @FXML
    private Button posterChooseBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);
        final File[] result = new File[1];
        posterChooseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select the file you want to open");
                fileChooser.setInitialDirectory(new File("."));
                result[0] = fileChooser.showOpenDialog(viewAlter.currentStage);
            }
        });

        addFilmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextFiled.getText();
                String duration = durationTextFiled.getText();
                String protagonist = protagonistTextFiled.getText();
                LocalDate releaseTime = releaseTimeDatePicker.getValue();
                Date time = TimeUtils.LocalDateToUpdate(releaseTime);
                String info = infoTextArea.getText();
                System.out.println(result[0]);
                byte[] poster = FormatUtils.transferFileToByte(result[0]);
                Film film = proxy.addFilm(name, poster, duration, protagonist, time, info);
                if (film != null) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Add Successfully");
                    alert.showAndWait();
                    EditFilmListController.refresh();
                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setContentText("Add Filed");
                    alert.showAndWait();
                }
            }
        });

    }
}
