package com.group11.dao;

import com.group11.pojo.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper {

    public List<Seat> getSeatByTimeTableId(@Param("timeTableId") String timeTableId);

    public Seat getSeatById(@Param("id") String id);

    public int changeSeatStatus(Seat seat);

    public int addSeat(Seat seat);

}
