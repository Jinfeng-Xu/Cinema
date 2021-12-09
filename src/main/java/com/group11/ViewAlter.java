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
    static{
        try {
            instream = ViewAlter.class.getClassLoader().getResourceAsStream("static-config.properties");
            properties.load(instream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Booking System");
        gotoLogin();
        stage.show();
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

    public void gotoCustomerMain() {
        try {
            CustomerMainController customerMain = (CustomerMainController) replaceSceneContent(properties.getProperty("CUSTOMER_MAIN_VIEW_PATH"));
            customerMain.setApp(this);
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
            stage.setScene(scene);
            stage.sizeToScene();
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


