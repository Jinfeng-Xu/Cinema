package service;

import com.group11.pojo.*;
import com.group11.service.BookingService;
import com.group11.service.BookingServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class BookingServiceTest {

    private final BookingService bookingService = new BookingServiceImpl();

    @Test
    public void getTimeTable(){
        TimeTable timeTable = bookingService.getTimeTable("1");
        assert timeTable != null;
        assert timeTable instanceof TimeTable;
    }

    @Test
    public void getFilm(){
        Film film = bookingService.getFilm("123");
        assert film != null;
        assert film instanceof Film;
    }

    @Test
    public void getScreen(){
        Screen screen = bookingService.getScreen("222");
        assert screen != null;
        assert screen instanceof Screen;
    }

    @Test
    public void getSeats(){
        List<Seat> seats = bookingService.getSeats("222");
        for (Seat seat : seats) {
            assert seat != null;
            assert seat instanceof Seat;
        }
    }

    @Test
    public void getSeat(){
        Seat seat = bookingService.getSeat("mzx");
        assert seat != null;
        assert seat instanceof Seat;
    }

    @Test
    public void getCustomers() {
        List<Customer> customers = bookingService.getCustomers();
        for (Customer customer : customers) {
            assert customer != null;
            assert customer instanceof Customer;
        }
    }

    @Test
    public void getBills() {
        List<Bill> bills = bookingService.getBills();
        for (Bill bill : bills) {
            assert bill != null;
            assert bill instanceof Bill;
        }
    }

    @Test
    public void removeBill() {
        boolean flag = bookingService.removeBill("6");
        assert flag == true;
    }

    @Test
    public void getStartTime() {
        Date startTime = bookingService.getStartTime("888");
        assert startTime != null;
    }

    @Test
    public void getTimeTables() {
        List<TimeTable> timeTables = bookingService.getTimeTables();
        for (TimeTable timeTable : timeTables) {
            assert timeTable != null;
            assert timeTable instanceof TimeTable;
        }
    }

    @Test
    public void createBill(){
        boolean flag = bookingService.createBill("16", null, "mzx");
        assert flag = true;
    }

    @Test
    public void getInitTimeTable(){
        TimeTable timeTable = bookingService.getInitTimeTable("d0f54d9e-326f-4bf8-85a9-dcd30fa58030");
        Seat[][] seats = timeTable.getSeats();
        int length_r = seats.length;
        int length_c = seats[0].length;
        for (int i = 0; i < length_r; i++){
            for (int j = 0; j < length_c; j++){
                Seat seat = seats[i][j];
                System.out.println(seat.toString());
            }
        }
        System.out.println(timeTable.toString());
    }


    @Test
    public void getBillByCustomerId(){
        List<Bill> bills = bookingService.getBillByCustomerId("16");
        for (Bill bill: bills){
            assert bill != null;
            assert bill instanceof  Bill;
        }
    }

    @Test
    public void getBillById(){
        Bill bill = bookingService.getBillById("2");
        assert bill != null;
        assert bill instanceof  Bill;
    }
}
