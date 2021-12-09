package com.group11.dao;

import com.group11.pojo.Screen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScreenMapper {

    public List<Screen> getScreen();

    public Screen getScreenById(@Param("id") String id);

    public int addScreen(Screen screen);

    public Screen getScreenByTimeTableId(@Param("tid") String id);
}
