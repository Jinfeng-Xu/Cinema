package com.group11.dao;

import com.group11.pojo.TimeTable;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TimeTableMapper {

    public List<TimeTable> getTimeTable(Date time);

    public TimeTable getTimeTableById(@Param("id") String id);

    public int addTimeTable(TimeTable timeTable);

    public int deleteTimeTable(@Param("id") String id);

}
