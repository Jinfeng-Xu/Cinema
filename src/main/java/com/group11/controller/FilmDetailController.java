package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Film;
import com.group11.service.*;
import com.group11.util.FormatUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class FilmDetailController implements Initializable {
    private ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    private String filmID;

    public String getFilmID() {
        return filmID;
    }
    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }

    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }

    @FXML
    private TextField releaseTimeTextField;

    @FXML
    private TextField durationTextField;

    @FXML
    private Button backBtn;

    @FXML
    private TextField nameTextField;

    @FXML
    private ImageView postImageView;

    @FXML
    private TextField filmInformationTextField;

    @FXML
    private TextField protagonistTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Film film = proxy.getFilm(ViewAlter.filmID);
        System.out.println(film.toString());
        System.out.println(ViewAlter.filmID);
        nameTextField.setText(film.getName());
        durationTextField.setText(film.getDuration());
        releaseTimeTextField.setText(dateFormat.format(film.getReleaseTime()));
        protagonistTextField.setText(film.getProtagonist());
        filmInformationTextField.setText(film.getInfo());

        FormatUtils.byte2image(film.getBase64(), "src/main/posters/" + film.getName() + ".jpg");
        Image image = new Image("file:src/main/posters/" + film.getName() + ".jpg");
        postImageView.setImage(image);

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.backFromFilmDetail();
            }
        });
    }
}