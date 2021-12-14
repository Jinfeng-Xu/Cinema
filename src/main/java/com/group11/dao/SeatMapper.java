package com.group11.dao;

import com.group11.pojo.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper {

    // get all seats from cloud db by timetable_id
    public List<Seat> getSeatByTimeTableId(@Param("timeTableId") String timeTableId);

    // get a seat from cloud db by id
    public Seat getSeatById(@Param("id") String id);

    // update a seat's status in cloud db
    public int changeSeatStatus(Seat seat);

    // add a seat to cloud db
    public int addSeat(Seat seat);

    // delete a seat from cloud db
    public int deleteSeatByTimeTableId(@Param("timeTableId") String timeTableId);

}
