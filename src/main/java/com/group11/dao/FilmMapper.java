package com.group11.dao;

import com.group11.pojo.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FilmMapper {

    public List<Film> getFilm();

    public Film getFilmById(@Param("id") String id);

    public Film getFilmByName(@Param("name") String name);

    public int addFilm(Film film);

    public int deleteFilm(@Param("id") String id);

    public Film getFilmByTimeTableId(@Param("tid") String id);

}
