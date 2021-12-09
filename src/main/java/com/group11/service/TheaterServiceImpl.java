package com.group11.service;

import com.group11.dao.BillMapper;
import com.group11.dao.FilmMapper;
import com.group11.dao.ScreenMapper;
import com.group11.dao.TimeTableMapper;
import com.group11.pojo.Bill;
import com.group11.pojo.Film;
import com.group11.pojo.Screen;
import com.group11.pojo.TimeTable;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TheaterServiceImpl implements TheaterService{

    public Film addFilm(String name, byte[] poster, String duration, String protagonist, Date releaseTime, String info){
        Film film = new Film(UUID.randomUUID().toString(), name, poster, duration, protagonist, releaseTime, info);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        int count = mapper.addFilm(film);
        if (count != 0){
            System.out.println("Add Successful");
            sqlSession.commit();
        }else {
            System.out.println("Add Unsuccessful");
        }
        sqlSession.close();
        return film;
    }

    public Film getFilmById(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        Film film = mapper.getFilmById(id);
        sqlSession.close();
        return film;
    }

    public boolean deleteFilm(String id){
        List<TimeTable> timeTables = getTimeTables();
        boolean flag = true;
        for (TimeTable timeTable: timeTables){
            if (timeTable.getFilmId().equals(id)) {
                flag = false;
                break;
            }
        }
        if (flag){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
            int count = mapper.deleteFilm(id);
            if (count != 0){
                sqlSession.commit();
                sqlSession.close();
                return true;
            }
            sqlSession.close();
        }
        return false;
    }

    public TimeTable addTimeTable(Date startTime, String screenId, String filmId, String price){
        TimeTable timeTable = new TimeTable(UUID.randomUUID().toString(), startTime, filmId, screenId, price);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        int count = mapper.addTimeTable(timeTable);
        if (count != 0){
            System.out.println("Add Successful");
            sqlSession.commit();
        }else {
            System.out.println("Add Unsuccessful");
        }
        sqlSession.close();
        return timeTable;
    }

    public List<TimeTable> getTimeTables(){
        Date now = new Date();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        List<TimeTable> timeTables = mapper.getTimeTable(now);
        sqlSession.close();
        return timeTables;
    }

    public List<Bill> getBillList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.getBill();
        sqlSession.close();
        return bills;
    }

    public List<Screen> getScreen(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        List<Screen> screens = mapper.getScreen();
        sqlSession.close();
        return screens;
    }

    public boolean cancelBill(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int count = mapper.deleteBill(id);
        if (count != 0){
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        sqlSession.close();
        return false;
    }

    public List<Film> getFilm(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        List<Film> films = mapper.getFilm();
        sqlSession.close();
        return films;
    }

}
