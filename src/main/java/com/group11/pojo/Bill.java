package com.group11.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Bill")
public class Bill {
    // Defining private properties
    private String id;
    private Date billDate, startTime;
    private String filmName, screenType, filmDuration;
    private String screenId, customerId;
    private String seatRow, seatColumn;
    private String price;

    // A constructor with no arguments
    public Bill() {
    }

    // A constructor with arguments
    public Bill(String id, Date billDate, Date startTime, String filmName, String screenType, String filmDuration, String screenId, String customerId, String seatRow, String seatColumn, String price) {
        this.id = id;
        this.billDate = billDate;
        this.startTime = startTime;
        this.filmName = filmName;
        this.screenType = screenType;
        this.filmDuration = filmDuration;
        this.screenId = screenId;
        this.customerId = customerId;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.price = price;
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getFilmDuration() {
        return filmDuration;
    }

    public void setFilmDuration(String filmDuration) {
        this.filmDuration = filmDuration;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public String getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(String seatColumn) {
        this.seatColumn = seatColumn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", billDate=" + billDate +
                ", startTime=" + startTime +
                ", filmName='" + filmName + '\'' +
                ", screenType='" + screenType + '\'' +
                ", filmDuration='" + filmDuration + '\'' +
                ", screenId='" + screenId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", seatColumn='" + seatColumn + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
