package service;

import com.group11.pojo.Bill;
import com.group11.pojo.Film;
import com.group11.pojo.Screen;
import com.group11.pojo.TimeTable;
import com.group11.service.TheaterService;
import com.group11.service.TheaterServiceImpl;
import com.group11.util.FormatUtils;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

public class TheaterServiceTest {
    private final TheaterService theaterService = new TheaterServiceImpl();

    @Test
    public void addFilm(){
        File file = new File("/Users/86139/Desktop/bg.png");
        Date utilDate = new Date();
        Film film = theaterService.addFilm("hello world", FormatUtils.transferFileToByte(file), "60", "Paul", utilDate, "hello");
        assert film != null;
        assert film instanceof Film;
    }

    @Test
    public void getFilmById(){
        Film film = theaterService.getFilmById("123");
        assert film != null;
        assert film instanceof Film;
    }

    @Test
    public void deleteFilm(){
        boolean flag = theaterService.deleteFilm("123");
    }

    @Test
    public void addTimeTable(){
        Date utilDate = new Date(); //获取当前时间
        TimeTable timeTable = theaterService.addTimeTable(utilDate,"3", "123", "188");
        assert timeTable != null;
        assert timeTable instanceof TimeTable;

    }

    @Test
    public void getTimeTables(){
        Date now = new Date();
        List<TimeTable> timeTables = theaterService.getTimeTables();
        for (TimeTable timeTable : timeTables) {
            assert timeTable != null;
            assert timeTable instanceof TimeTable;
        }
    }

    @Test
    public void getBillList(){
        List<Bill> bills = theaterService.getBillList();
        for (Bill bill : bills) {
            assert bill != null;
            assert bill instanceof Bill;
        }
    }

    @Test
    public void getScreen(){
        List<Screen> screens = theaterService.getScreen();
        for (Screen screen : screens) {
            assert screen != null;
            assert screen instanceof Screen;
        }
    }

    @Test
    public void cancelBill(){
        boolean flag = theaterService.cancelBill("85686ac7-60fa-4105-8158-f8b7e9befc8c");
        assert flag == true;
    }

    @Test
    public void getFilm(){
        List<Film> films = theaterService.getFilm();
        for (Film film : films) {
            assert film != null;
            assert film instanceof Film;
        }
    }
}
