package com.group11.service;

import com.group11.pojo.Bill;
import com.group11.pojo.Film;
import com.group11.pojo.Screen;
import com.group11.pojo.TimeTable;

import java.util.Date;
import java.util.List;

public interface TheaterService {
    public Film addFilm(String name, byte[] poster, String duration, String protagonist, Date releaseTime, String info);

    public Film getFilmById(String id);

    public boolean deleteFilm(String id);

    public TimeTable addTimeTable(Date startTime, String screenId, String filmId, String price);

    public List<TimeTable> getTimeTables();

    public List<Bill> getBillList();

    public List<Screen> getScreen();

    public boolean cancelBill(String id);

    public List<Film> getFilm();
}
