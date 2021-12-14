package com.group11.service;

import com.group11.dao.*;
import com.group11.pojo.*;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

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

    public Screen getScreenById(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        Screen screen = mapper.getScreenById(id);
        sqlSession.close();
        return screen;
    }

    public TimeTable addTimeTable(Date startTime, String screenId, String filmId, String price){
        TimeTable timeTable = new TimeTable(UUID.randomUUID().toString(), startTime, filmId, screenId, price);
        Screen screen = getScreenById(screenId);
        String type = screen.getType();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper_t = sqlSession.getMapper(TimeTableMapper.class);
        SeatMapper mapper_s = sqlSession.getMapper(SeatMapper.class);
        int count = mapper_t.addTimeTable(timeTable);
        if (count != 0){
            System.out.println("Add Successful");
            int num = 1;
            if (type.equals("small")){
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 8; j++){
                        Seat seat;
                        if (num < 10){
                            seat = new Seat(timeTable.getId() + "_0" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }else {
                            seat = new Seat(timeTable.getId() + "_" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }
                        int flag = mapper_s.addSeat(seat);
                        if (flag != 0){
                            System.out.println("Add Seat Successful");
                        }else {
                            System.out.println("Add Seat Failed");
                        }
                        num++;
                    }
                }
            }else if(type.equals("middle")){
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 10; j++){
                        Seat seat;
                        if (num < 10){
                            seat = new Seat(timeTable.getId() + "_0" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }else {
                            seat = new Seat(timeTable.getId() + "_" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }
                        int flag = mapper_s.addSeat(seat);
                        if (flag != 0){
                            System.out.println("Add Seat Successful");
                        }else {
                            System.out.println("Add Seat Failed");
                        }
                        num++;
                    }
                }
            }else if (type.equals("large")){
                for (int i = 0; i < 6; i++){
                    for (int j = 0; j < 12; j++){
                        Seat seat;
                        if (num < 10){
                            seat = new Seat(timeTable.getId() + "_0" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }else {
                            seat = new Seat(timeTable.getId() + "_" + num, String.valueOf(i), String.valueOf(j), true, timeTable.getId());
                        }
                        int flag = mapper_s.addSeat(seat);
                        if (flag != 0){
                            System.out.println("Add Seat Successful");
                        }else {
                            System.out.println("Add Seat Failed");
                        }
                        num++;
                    }
                }

            }
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

    @Override
    public boolean deleteSeats(String timeTableId) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        int i = mapper.deleteSeatByTimeTableId(timeTableId);
        if(i!=0){
            sqlSession.commit();
            sqlSession.close();
            System.out.println("OKOK");
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTimeTable(String id) {
        deleteSeats(id);
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        int count = mapper.deleteTimeTable(id);
        System.out.println("----------------" + count);
        if( count != 0 ){
            sqlSession.commit();
            sqlSession.close();
            System.out.println("OKOK");
            return true;
        }
        return false;
    }

    @Override
    public Bill getBillById(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = mapper.getBillById(id);
        sqlSession.close();
        return bill;
    }
}
