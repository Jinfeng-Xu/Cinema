package com.group11.service;

import com.group11.pojo.*;

import java.util.Date;
import java.util.List;

public interface BookingService {

    public TimeTable getTimeTable(String id);

    public Film getFilm(String id);

    public Screen getScreen(String id);

    public List<Seat> getSeats(String screen_id);

    public Seat getSeat(String id);

    public List<Customer> getCustomers();

    public List<Bill> getBills();

    public boolean removeBill(String id);

    public Date getStartTime(String timetable_id);

    public List<TimeTable> getTimeTables();

    public boolean createBill(String customer_id, String timetable_id, String seat_id);
}
