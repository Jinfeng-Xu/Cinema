package com.group11.dao;

import com.group11.pojo.TimeTable;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TimeTableMapper {

    // get all timetables which start time later than now from cloud db
    public List<TimeTable> getTimeTable(Date time);

    // get a timetable from cloud db by id
    public TimeTable getTimeTableById(@Param("id") String id);

    // add a timetable to cloud db
    public int addTimeTable(TimeTable timeTable);

    // delete a timetable from cloud db by id
    public int deleteTimeTable(@Param("id") String id);

}
