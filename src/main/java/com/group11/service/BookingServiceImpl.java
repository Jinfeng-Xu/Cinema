package com.group11.service;

import com.group11.dao.*;
import com.group11.pojo.*;
import com.group11.util.MybatisUtils;
import com.group11.util.PersistentUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookingServiceImpl implements BookingService{

    public TimeTable getTimeTable(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        TimeTable timeTable = mapper.getTimeTableById(id);
        sqlSession.close();
        return timeTable;
    }

    public Film getFilm(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        Film film = mapper.getFilmById(id);
        sqlSession.close();
        return film;
    }

    public Screen getScreen(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        Screen screen = mapper.getScreenById(id);
        sqlSession.close();
        return screen;
    }

    public List<Seat> getSeats(String timeTableId){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        List<Seat> seats = mapper.getSeatByTimeTableId(timeTableId);
        sqlSession.close();
        return seats;
    }

    public Seat getSeat(String id){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        Seat seat = mapper.getSeatById(id);
        sqlSession.close();
        return seat;
    }

    public List<Customer> getCustomers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customer = mapper.getCustomer();
        sqlSession.close();
        return customer;
    }

    public List<Bill> getBills() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bill = mapper.getBill();
        sqlSession.close();
        return bill;
    }

    public boolean removeBill(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int count = mapper.deleteBill(id);
        sqlSession.commit();
        sqlSession.close();
        return count != 0;
    }

    public Date getStartTime(String timetable_id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        TimeTable timeTable = mapper.getTimeTableById(timetable_id);
        sqlSession.close();
        return timeTable.getStartTime();
    }

    public List<TimeTable> getTimeTables() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        Date now = new Date();
        List<TimeTable> timeTables = mapper.getTimeTable(now);
        sqlSession.close();
        return timeTables;
    }

    public boolean createBill(String customer_id, String timetable_id, String seat_id){
        TimeTable timeTable = getTimeTable(timetable_id);
        Film film = getFilm(timeTable.getFilmId());
        Screen screen = getScreen(timeTable.getScreenId());
        Seat seat = getSeat(seat_id);
        Date date = new Date();
        Bill bill = new Bill(UUID.randomUUID().toString(), date, timeTable.getStartTime(), film.getName(), screen.getType(), film.getDuration(), screen.getId(), customer_id, seat.getSeatRow(), seat.getSeatColumn());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int count = mapper.addBill(bill);
        sqlSession.commit();
        sqlSession.close();
        return count != 0;
    }
}
