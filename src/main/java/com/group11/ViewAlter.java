package com.group11;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.group11.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewAlter extends Application {

    private static final Logger logger = Logger.getLogger(ViewAlter.class.getName());
    private static Properties properties = new Properties();
    private static InputStream instream;
    public static String administratorName;
    public static String customerName;

    static{
        try {
            instream = ViewAlter.class.getClassLoader().getResourceAsStream("static-config.properties");
            properties.load(instream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Stage currentStage;
    public static String customerID;
    public static String administratorID;
    private boolean isAdmin;
    private boolean isFromTimetable;
    private boolean isFromFilmList;
    public static String filmID;
    public static String billID;
    public static String timetableId;

    @Override
    public void start(Stage primaryStage) throws Exception {
        currentStage = primaryStage;
        currentStage.setTitle("Booking System");
        gotoLogin();
        currentStage.show();
    }

    /**
     * 跳转到登录界面
     */
    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent(properties.getProperty("LOGIN_VIEW_PATH"));
            login.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoRegister() {
        try {
            RegisterController register = (RegisterController) replaceSceneContent(properties.getProperty("REGISTER_VIEW_PATH"));
            register.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void initGotoCustomerMain(String customerID, String customerName) {
        try {
            this.isAdmin = false;
            this.customerID = customerID;
            this.administratorID = "";
            ViewAlter.customerName = customerName;
            CustomerMainController customerMain = (CustomerMainController) replaceSceneContent(properties.getProperty("CUSTOMER_MAIN_VIEW_PATH"));
            customerMain.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoCustomerMain() {
        try {
            CustomerMainController customerMain = (CustomerMainController) replaceSceneContent(properties.getProperty("CUSTOMER_MAIN_VIEW_PATH"));
            customerMain.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void initGotoAdministratorMain(String administratorID, String administratorName) {
        try {
            this.isAdmin = true;
            this.customerID = "";
            this.administratorID = administratorID;
            ViewAlter.administratorName = administratorName;
            AdministratorMainController administratorMain = (AdministratorMainController) replaceSceneContent(properties.getProperty("ADMIN_MAIN_VIEW_PATH"));
            administratorMain.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoAdministratorMain() {
        try {
            AdministratorMainController administratorMain = (AdministratorMainController) replaceSceneContent(properties.getProperty("ADMIN_MAIN_VIEW_PATH"));
            administratorMain.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }



    public void gotoResetPassword() {
        try {
            ResetPasswordController resetPassword = (ResetPasswordController) replaceSceneContent(properties.getProperty("RESET_PASSWORD_VIEW_PATH"));
            resetPassword.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoTimeTable() {
        try {
            isFromFilmList = false;
            isFromTimetable = true;
            TimetableController timetable = (TimetableController) replaceSceneContent(properties.getProperty("TIMETABLE_VIEW_PATH"));
            timetable.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoBillList() {
        try {
            BillListUIController billList = (BillListUIController) replaceSceneContent(properties.getProperty("BILL_LIST_VIEW_PATH"));
            billList.setApp(this);
            billList.setCustomerID(customerID);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoEditFilmList() {
        try {
            isFromTimetable = false;
            isFromFilmList = true;
            EditFilmListController editFilm = (EditFilmListController) replaceSceneContent(properties.getProperty("EDIT_FILM_VIEW_PATH"));
            editFilm.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoEditTimetable() {
        try {
            isFromFilmList = false;
            isFromTimetable = true;
            EditTimeTableController editTimetable = (EditTimeTableController) replaceSceneContent(properties.getProperty("EDIT_TIMETABLE_VIEW_PATH"));
            editTimetable.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoAllBillList() {
        try {
            AllBillListController allBillList = (AllBillListController) replaceSceneContent(properties.getProperty("ALL_BILL_LIST_VIEW_PATH"));
            allBillList.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoBillDetail(String billID) {
        try {
            ViewAlter.billID = billID;
            BillDetailController billDetail = (BillDetailController) replaceSceneContent(properties.getProperty("BILL_DETAIL_VIEW_PATH"));
            billDetail.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }


    public void gotoFilmDetail(String filmID) {
        try {
            ViewAlter.filmID = filmID;
            System.out.println("1111");
            FilmDetailController filmDetail = (FilmDetailController) replaceSceneContent(properties.getProperty("FILM_DETAIL_VIEW_PATH"));
            filmDetail.setApp(this);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void gotoSeats(String timetableId) {
        try {
            ViewAlter.timetableId = timetableId;
            SeatsUIController seats_4_8 = (SeatsUIController) replaceSceneContent(properties.getProperty("SEATS_VIEW_PATH"));
            seats_4_8.setApp(this);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }


    public void backFromFilmDetail() {
        if (isAdmin) {
            if (isFromFilmList) {
                gotoEditFilmList();
            }
            else {
                gotoEditTimetable();
            }
        }
        else{
            gotoTimeTable();
        }
    }

    public void backFromBillDetail() {
        if (isAdmin) {
            gotoAllBillList();
        }
        else {
            gotoBillList();
        }
    }

    /**
     * 替换场景
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        InputStream in = ViewAlter.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(ViewAlter.class.getResource(fxml));
        try {
            AnchorPane page = loader.load(in);
            Scene scene = new Scene(page, Double.parseDouble(properties.getProperty("STAGE_WIDTH")), Double.parseDouble(properties.getProperty("STAGE_HEIGHT")));
            currentStage.setScene(scene);
            currentStage.sizeToScene();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "页面加载异常！");
        } finally {
            in.close();
        }
        return (Initializable) loader.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }

}