package com.group11.service;

import com.group11.pojo.*;
import com.group11.util.LogUtils;

import java.util.Date;
import java.util.List;

public class CoreSystem implements BookingService, TheaterService, LoginService{

    BookingService bsi;
    TheaterService tsi;
    LoginService ls;

    public void setBookingSystem(BookingService bsi){
        this.bsi = bsi;
    }

    public void setTheaterSystem(TheaterService tsi){
        this.tsi = tsi;
    }

    public void setLoginSystem(LoginService ls){
        this.ls = ls;
    }

    public TimeTable getTimeTable(String id) {
        TimeTable timeTable = bsi.getTimeTable(id);
        String info = "Get TimeTable";
        if (timeTable == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return timeTable;
    }

    public Film getFilm(String id) {
        Film film = bsi.getFilm(id);
        String info = "Get Film";
        if (film == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return film;
    }

    public Screen getScreen(String id) {
        Screen screen = bsi.getScreen(id);
        String info = "Get Screen";
        if (screen == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return screen;
    }

    public List<Seat> getSeats(String screen_id) {
        List<Seat> seats = bsi.getSeats(screen_id);
        String info = "Get Seats";
        if (seats == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return seats;
    }

    public Seat getSeat(String id) {
        Seat seat = bsi.getSeat(id);
        String info = "Get Seat";
        if (seat == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return seat;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = bsi.getCustomers();
        String info = "Get Customers";
        if (customers == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return customers;
    }

    public List<Bill> getBills() {
        List<Bill> bills = bsi.getBills();
        String info = "Get Bills";
        if (bills == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return bills;
    }



    public boolean removeBill(String id) {
        boolean remove = bsi.removeBill(id);
        String info = "Remove Bill";
        if (!remove){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return remove;
    }

    public Date getStartTime(String timetable_id) {
        Date startTime = bsi.getStartTime(timetable_id);
        String info = "Get StartTime";
        if (startTime == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return startTime;
    }

    public Film addFilm(String name, byte[] poster, String duration, String protagonist, Date releaseTime, String info) {
        Film film = tsi.addFilm(name, poster, duration, protagonist, releaseTime, info);
        String information = "Add Film";
        if (film == null){
            information += " Failed";
        }else {
            information += " Successful";
        }
        LogUtils.logToFile(information);
        return film;
    }

    public Film getFilmById(String id) {
        Film film = tsi.getFilmById(id);
        String info = "Get Film";
        if (film == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return film;
    }

    public boolean deleteFilm(String id) {
        boolean delete = tsi.deleteFilm(id);
        String info = "Remove Bill";
        if (!delete){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return delete;
    }

    public TimeTable addTimeTable(Date startTime, String screenId, String filmId, String price) {
        TimeTable timeTable = tsi.addTimeTable(startTime, screenId, filmId, price);
        String information = "Add TimeTable";
        if (timeTable == null){
            information += " Failed";
        }else {
            information += " Successful";
        }
        LogUtils.logToFile(information);
        return timeTable;
    }

    public List<TimeTable> getTimeTables() {
        List<TimeTable> timeTables = bsi.getTimeTables();
        String info = "Get TimeTables";
        if (timeTables == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return timeTables;
    }

    public List<Bill> getBillList() {
        List<Bill> bills = tsi.getBillList();
        String info = "Get Bills";
        if (bills == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return bills;
    }

    public List<Screen> getScreen() {
        List<Screen> screens = tsi.getScreen();
        String info = "Get Screens";
        if (screens == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return screens;
    }

    public boolean cancelBill(String id) {
        boolean cancel = tsi.cancelBill(id);
        String info = "Cancel Bill";
        if (!cancel){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return cancel;
    }

    @Override
    public List<Film> getFilm() {
        List<Film> films = tsi.getFilm();
        String info = "Get Films";
        if (films == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return films;
    }

    @Override
    public boolean deleteSeats(String timeTableId) {
        boolean b = tsi.deleteSeats(timeTableId);
        String information = "Delete Seats";
        if (!b){
            information += " Failed";
        }else {
            information += " Successful";
        }
        LogUtils.logToFile(information);
        return b;
    }


    @Override
    public boolean deleteTimeTable(String id) {
        boolean b = tsi.deleteTimeTable(id);
        String information = "Delete Timetable";
        if (!b){
            information += " Failed";
        }else {
            information += " Successful";
        }
        LogUtils.logToFile(information);
        return b;
    }

    public boolean createBill(String customer_id, TimeTable timeTable, String seat_id) {
        boolean create = bsi.createBill(customer_id, timeTable, seat_id);
        String information = "Create Bill";
        if (!create){
            information += " Failed";
        }else {
            information += " Successful";
        }
        LogUtils.logToFile(information);
        return create;
    }

    @Override
    public TimeTable getInitTimeTable(String timetableId) {
        TimeTable timeTable = bsi.getInitTimeTable(timetableId);
        String info = "Get TimeTable With Seats";
        if (timeTable == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return timeTable;

    }

    @Override
    public List<Bill> getBillByCustomerId(String customerId) {
        List<Bill> bills = bsi.getBillByCustomerId(customerId);
        String info = "Get Bills By CustomerId";
        if (bills == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return bills;
    }

    @Override
    public Bill getBillById(String id) {
        Bill bill = bsi.getBillById(id);
        String info = "Get Bill By Id";
        if (bill == null){
            info += " Failed";
        }else {
            info += " Successful";
        }
        LogUtils.logToFile(info);
        return bill;
    }


    public Object login(String username, String password, boolean type) {
        Object role = ls.login(username, password, type);
        String info = username + " login";
        if (role instanceof Customer){
            info += " as customer";
        }else if (role instanceof Administrator){
            info += " as administrator";
        }else {
            info += "failed";
        }
        LogUtils.logToFile(info);
        return role;
    }

    public int register(String username, String password, String confirm_password, boolean type) {
        int num = ls.register(username, password, confirm_password, type);
        String info = username + " register";
        if (num == 0){
            info += " as customer";
        }else if (num == 1){
            info += " as administrator";
        }else {
            info += " failed";
        }
        LogUtils.logToFile(info);
        return num;
    }

    @Override
    public boolean changeCustomer(String username, String origin, String password, String confirm_password) {
        boolean flag = ls.changeCustomer(username, origin, password, confirm_password);
        String info = username + " change password";
        if (flag){
            info += " successfully";
        }else{
            info += " failed";
        }
        LogUtils.logToFile(info);
        return flag;
    }

    @Override
    public boolean changeAdministrator(String username, String origin, String password, String confirm_password) {
        boolean flag = ls.changeAdministrator(username, origin, password, confirm_password);
        String info = username + " change password";
        if (flag){
            info += " successfully";
        }else{
            info += " failed";
        }
        LogUtils.logToFile(info);
        return flag;
    }

}
