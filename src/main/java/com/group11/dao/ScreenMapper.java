package com.group11.dao;

import com.group11.pojo.Screen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScreenMapper {

    // get all screens from cloud db
    public List<Screen> getScreen();

    // get a screen from cloud db by id
    public Screen getScreenById(@Param("id") String id);

    // add a screen to cloud db
    public int addScreen(Screen screen);

    // get a screen from cloud db by timetable_id
    public Screen getScreenByTimeTableId(@Param("tid") String id);
}
