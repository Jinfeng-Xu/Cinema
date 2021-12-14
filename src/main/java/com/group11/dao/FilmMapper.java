package com.group11.dao;

import com.group11.pojo.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmMapper {

    // get all films from cloud db
    public List<Film> getFilm();

    // get a film from cloud db by id
    public Film getFilmById(@Param("id") String id);

    // get a film from cloud db by name
    public Film getFilmByName(@Param("name") String name);

    // add a film to cloud db
    public int addFilm(Film film);

    // delete a film from cloud db by id
    public int deleteFilm(@Param("id") String id);

    // get a film from cloud db by timetable_id
    public Film getFilmByTimeTableId(@Param("tid") String id);

}
