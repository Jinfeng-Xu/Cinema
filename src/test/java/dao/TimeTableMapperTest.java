package dao;

import com.group11.dao.TimeTableMapper;
import com.group11.pojo.TimeTable;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TimeTableMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getTimeTable(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        java.util.Date utilDate = new java.util.Date(); //获取当前时间
        List<TimeTable> timeTables = mapper.getTimeTable(utilDate);
        for (TimeTable timeTable : timeTables) {
            System.out.println(timeTable.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getTimeTableById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        TimeTable timeTable = mapper.getTimeTableById("1");
        System.out.println(timeTable.toString());
        sqlSession.close();
    }

    @Test
    public void addTimeTable(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        java.util.Date utilDate = new java.util.Date(); //获取当前时间
        int count = mapper.addTimeTable(new TimeTable("1", utilDate, "123", "222", "3rmb"));
        if(count > 0){
            System.out.println("OK");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTimeTable(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        int count = mapper.deleteTimeTable("122");
        if(count > 0)
            System.out.println("OK");
        sqlSession.commit();
        sqlSession.close();
    }
}
