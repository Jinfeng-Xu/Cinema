package dao;

import com.group11.dao.SeatMapper;
import com.group11.pojo.Seat;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class SeatMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getSeatByTimeTableId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        List<Seat> seats = mapper.getSeatByTimeTableId("9070efaf-238d-43e7-b521-d143d0410fb3");
        for (Seat seat : seats) {
            System.out.println(seat);
        }
        sqlSession.close();
    }

    @Test
    public void getSeatById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        Seat seat = mapper.getSeatById("1");
        System.out.println(seat);
        sqlSession.close();
    }

    @Test
    public void changeSeatStatus(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        Seat seat = mapper.getSeatById("1");
        seat.setEmpty(false);
        int i = mapper.changeSeatStatus(seat);
        if(i > 0)
            System.out.println("OK");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addSeat(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SeatMapper mapper = sqlSession.getMapper(SeatMapper.class);
        int count = mapper.addSeat(new Seat("mzx11", "1", "2",  true, "1"));
        if(count > 0) System.out.println("ok");
        sqlSession.commit();
        sqlSession.close();
    }

}
