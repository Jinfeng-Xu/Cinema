package com.group11.controller;

import com.group11.ViewAlter;
import com.group11.pojo.Film;
import com.group11.service.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

public class EditFilmListController implements Initializable {
    private static ViewAlter viewAlter = new ViewAlter();
    private CoreSystem proxy = new CoreSystem();
    public void setApp(ViewAlter viewAlter) {
        this.viewAlter = viewAlter;
    }
    private static Properties properties = new Properties();

    @FXML
    private Button backBtn;

    @FXML
    private VBox containerVBox;

    @FXML
    private Button addBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingService bookingService = new BookingServiceImpl();
        TheaterService theaterService = new TheaterServiceImpl();
        LoginService loginService = new LoginServiceImpl();

        proxy.setBookingSystem(bookingService);
        proxy.setTheaterSystem(theaterService);
        proxy.setLoginSystem(loginService);


        final List<Film> filmList = proxy.getFilm();
        HBox[] item = new HBox[filmList.size()];
        Label[] filmNameLabel = new Label[filmList.size()];
        Label[] releaseTimeLabel = new Label[filmList.size()];
        Label[] durationLabel = new Label[filmList.size()];
        Button[] deleteButton = new Button[filmList.size()];
        final String[] filmID = new String[filmList.size()];
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int i = 0; i < item.length; i++) {
            item[i] = new HBox();
            filmNameLabel[i] = new Label();
            releaseTimeLabel[i] = new Label();
            durationLabel[i] = new Label();
            deleteButton[i] = new Button();

            filmID[i] = filmList.get(i).getId();
            System.out.println(filmID[i]);

            filmNameLabel[i].setText(filmList.get(i).getName());
            releaseTimeLabel[i].setText(dateFormat.format(filmList.get(i).getReleaseTime()));
            durationLabel[i].setText(filmList.get(i).getDuration());
            deleteButton[i].setText("Delete");

            filmNameLabel[i].setPrefSize(120, 36);
            releaseTimeLabel[i].setPrefSize(190, 36);
            durationLabel[i].setPrefSize(120, 36);
            deleteButton[i].setPrefSize(120, 36);

            filmNameLabel[i].setAlignment(Pos.CENTER);
            releaseTimeLabel[i].setAlignment(Pos.CENTER);
            durationLabel[i].setAlignment(Pos.CENTER);
            deleteButton[i].setAlignment(Pos.CENTER);
            filmNameLabel[i].setStyle("-fx-text-fill:blue;");
            final int finalI = i;

            filmNameLabel[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    viewAlter.gotoFilmDetail(filmID[finalI]);
                }
            });

            deleteButton[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    proxy.deleteFilm(filmID[finalI]);
                    viewAlter.gotoEditFilmList();
                }
            });

            item[i].getChildren().add(filmNameLabel[i]);
            item[i].getChildren().add(releaseTimeLabel[i]);
            item[i].getChildren().add(durationLabel[i]);
            item[i].getChildren().add(deleteButton[i]);

            containerVBox.getChildren().add(item[i]);
        }

        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(viewAlter.currentStage);
                dialog.initModality(Modality.NONE);

                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/addFilmDialogUI.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene dialogScene = new Scene(root, 400, 300);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });

        backBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                viewAlter.gotoAdministratorMain();
            }
        });
    }

    public static void refresh() {
        viewAlter.gotoEditFilmList();
    }
}