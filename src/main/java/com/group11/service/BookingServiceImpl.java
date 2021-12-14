package com.group11.service;

import com.group11.controller.SeatsUIController;
import com.group11.dao.*;
import com.group11.pojo.*;
import com.group11.util.MybatisUtils;
import com.group11.util.PersistentUtils;
import org.apache.ibatis.session.SqlSession;

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
        List<Bill> bills = mapper.getBill();
        sqlSession.close();
        return bills;
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

    public boolean createBill(String customer_id, TimeTable timeTable, String seat_id){
        Seat seat = getSeat(seat_id);
        SeatsUIController observer = new SeatsUIController();
        timeTable.addObserver(observer);
        seat.setEmpty(false);
        timeTable.setSeat(seat);
        PersistentUtils.saveTimeTableToFile(timeTable, timeTable.getId());
        Film film = getFilm(timeTable.getFilmId());
        Screen screen = getScreen(timeTable.getScreenId());
        Date date = new Date();
        Bill bill = new Bill(UUID.randomUUID().toString(), date, timeTable.getStartTime(), film.getName(), screen.getType(), film.getDuration(), screen.getId(), customer_id, seat.getSeatRow(), seat.getSeatColumn(), timeTable.getPrice());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int count = mapper.addBill(bill);
        sqlSession.commit();
        sqlSession.close();
        return count != 0;
    }

    public TimeTable getInitTimeTable(String timetableId){
        List<Seat> seats = getSeats(timetableId);
        TimeTable persistent = PersistentUtils.getTimeTableById(timetableId);
        if (persistent == null){
            TimeTable timeTable = getTimeTable(timetableId);
            String screenId = timeTable.getScreenId();
            Screen screen = getScreen(screenId);
            Seat[][] table;
            int num = 0;
            if (screen.getType().equals("small")){
                table = new Seat[4][8];
                for (int i = 0; i < 4; i++){
                    for (int j = 0; j < 8; j++){
                        table[i][j] = seats.get(num);
                        num++;
                    }
                }
                timeTable.setSeats(table);
                PersistentUtils.saveTimeTableToFile(timeTable, timetableId);
                return timeTable;
            }else if(screen.getType().equals("middle")){
                table = new Seat[5][10];
                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 10; j++){
                        table[i][j] = seats.get(num);
                        num++;
                    }
                }
                timeTable.setSeats(table);
                PersistentUtils.saveTimeTableToFile(timeTable, timetableId);
                return timeTable;
            }else{
                table = new Seat[6][12];
                for (int i = 0; i < 6; i++){
                    for (int j = 0; j < 12; j++){
                        table[i][j] = seats.get(num);
                        num++;
                    }
                }
                timeTable.setSeats(table);
                PersistentUtils.saveTimeTableToFile(timeTable, timetableId);
                return timeTable;
            }
        }
        return persistent;
    }

    public List<Bill> getBillByCustomerId(String customerId){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.getBillByCustomerId(customerId);
        sqlSession.close();
        return bills;
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
