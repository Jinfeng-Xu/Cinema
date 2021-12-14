package com.group11.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

@Alias("TimeTable")
public class TimeTable extends Observable implements Serializable {
    // Defining private properties
    private String id;
    private Date startTime;
    private String filmId;
    private String screenId;
    private String price;
    private Seat[][] seats;

    // A constructor with no arguments
    public TimeTable() {
    }

    // A constructor with arguments
    public TimeTable(String id, Date startTime, String filmId, String screenId, String price) {
        this.id = id;
        this.startTime = startTime;
        this.filmId = filmId;
        this.screenId = screenId;
        this.price = price;
    }

    // Set a seat from seats (Be observed)
    public void setSeat(Seat seat){
        this.seats[Integer.parseInt(seat.getSeatRow())][Integer.parseInt(seat.getSeatColumn())] = seat;
        setChanged();
        notifyObservers(seat);
//        System.out.println("+++++++++++++++++++++++++++++++++++");
    }

    // Getter and Setter
    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "id='" + id + '\'' +
                ", startTime=" + startTime +
                ", filmId='" + filmId + '\'' +
                ", screenId='" + screenId + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
