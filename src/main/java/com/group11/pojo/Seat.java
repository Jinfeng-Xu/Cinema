package com.group11.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;


@Alias("Seat")
public class Seat implements Serializable {
    // Defining private properties
    private String id;
    private String seatRow;
    private String seatColumn;
    private boolean isEmpty;
    private String timeTableId;

    // A constructor with no arguments
    public Seat() {
    }

    // A constructor with arguments
    public Seat(String id, String seatRow, String seatColumn, boolean isEmpty, String timeTableId) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.isEmpty = isEmpty;
        this.timeTableId = timeTableId;
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public String getTimeTableId() {
        return timeTableId;
    }

    public void setTimeTableId(String timeTableId) {
        this.timeTableId = timeTableId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", seatRow='" + seatRow + '\'' +
                ", seatColumn='" + seatColumn + '\'' +
                ", isEmpty=" + isEmpty +
                ", timeTableId='" + timeTableId + '\'' +
                '}';
    }
}
