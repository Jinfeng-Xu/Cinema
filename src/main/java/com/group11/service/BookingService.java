package com.group11.service;

import com.group11.pojo.*;

import java.util.Date;
import java.util.List;

public interface BookingService {

    /**
     * This method gets a time table
     * @param id is used to identify the unique time table
     * @return a certain time table
     */
    public TimeTable getTimeTable(String id);

    /**
     * This method gets a film
     * @param id is used to identify the wanted film
     * @return a certain film
     */
    public Film getFilm(String id);

    /**
     * This method gets a screen
     * @param id is used to identify the wanted screen
     * @return a certain screen
     */
    public Screen getScreen(String id);

    /**
     * This method gets all seats of a screen
     * @param screen_id is used to identify the located screeen
     * @return all the seats
     */
    public List<Seat> getSeats(String screen_id);

    /**
     * This method gets a certain seat
     * @param id is used to identify the wanted seat
     * @return a certain seat
     */
    public Seat getSeat(String id);

    /**
     * This method gets all customers who has booked seats
     * @return a customer list
     */
    public List<Customer> getCustomers();

    /**
     * This method gets all bills in the backends
     * @return a bill list
     */
    public List<Bill> getBills();

    /**
     * This methods deletes a certain bill
     * @param id is used to identify the deleted bill
     * @return true or false to judge if the delete operation succeeded
     */
    public boolean removeBill(String id);

    /**
     * This method gets the start time of a time table
     * @param timetable_id is used to identify the related time table
     * @return the start time of the wanted time table
     */
    public Date getStartTime(String timetable_id);

    /**
     * This method gets all the time table
     * @return a time table list
     */
    public List<TimeTable> getTimeTables();

    /**
     * This method creates a bill
     * @param customer_id decides who this bill belongs to
     * @param timeTable decides when this film starts
     * @param seat_id decides where the customer sits
     * @return true or false to judge if the create operation succeeded
     */
    public boolean createBill(String customer_id, TimeTable timeTable, String seat_id);

    /**
     * Initialize all the set time table
     * @param timetableId
     * @return
     */
    public TimeTable getInitTimeTable(String timetableId);

    /**
     * This method gets all of a customer's bills
     * @param customerId presents this customer
     * @return a bill list
     */
    public List<Bill> getBillByCustomerId(String customerId);

    /**
     * This method get bill by id
     * @param id
     * @return a bill
     */
    public Bill getBillById(String id);
}
