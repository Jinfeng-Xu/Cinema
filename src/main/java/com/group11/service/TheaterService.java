package com.group11.service;

import com.group11.pojo.Bill;
import com.group11.pojo.Film;
import com.group11.pojo.Screen;
import com.group11.pojo.TimeTable;

import java.util.Date;
import java.util.List;

public interface TheaterService {

    /**
     * This method adds a new film
     * @param name presents film's name
     * @param poster presents film's poster
     * @param duration presents film's duration
     * @param protagonist presents film's actors & actress
     * @param releaseTime presents film's release time
     * @param info presents film's basic information
     * @return the added new film object
     */
    public Film addFilm(String name, byte[] poster, String duration, String protagonist, Date releaseTime, String info);

    /**
     * This method gets a film according to film's id
     * @param id represents film's id
     * @return the selected film object
     */
    public Film getFilmById(String id);

    /**
     * This method deletes a film according to the film's id
     * @param id represents film's id
     * @return true or false to judge if the delete operation succeeded
     */
    public boolean deleteFilm(String id);

    /**
     * This method adds a new time table
     * @param startTime represents a film's start time
     * @param screenId represents the related screen's id
     * @param filmId represents the film's id
     * @param price represents the film's ticket price
     * @return a new TableTime object
     */
    public TimeTable addTimeTable(Date startTime, String screenId, String filmId, String price);

    /**
     * This method get all the time tables
     * @return a list of all the time tables
     */
    public List<TimeTable> getTimeTables();

    /**
     * This method get all the bills
     * @return a list of all the bills
     */
    public List<Bill> getBillList();

    /**
     * This method get all the screens
     * @return a list of all the screens
     */
    public List<Screen> getScreen();

    /**
     * This method cancel a bill
     * @param id presents the bill id
     * @return true or false ti judge if the cancel operation succeeded
     */
    public boolean cancelBill(String id);

    /**
     * This method get all the films
     * @return a list of all the films
     */
    public List<Film> getFilm();

    /**
     * This method delete seats which related about timetable by timetable id
     * @param timeTableId
     * @return true / false
     */
    public boolean deleteSeats(String timeTableId);

    /**
     * This method delete timetable by timetable id
     * @param id
     * @return true / false
     */
    public boolean deleteTimeTable(String id);

    /**
     * This method get bill by id
     * @param id
     * @return a bill
     */
    public Bill getBillById(String id);
}
