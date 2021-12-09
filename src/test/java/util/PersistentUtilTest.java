package util;

import com.group11.dao.TimeTableMapper;
import com.group11.pojo.Screen;
import com.group11.pojo.TimeTable;
import com.group11.util.MybatisUtils;
import com.group11.util.PersistentUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.File;

public class PersistentUtilTest {

    @Test
    public void saveObject(){
        Screen screen = new Screen("12", "KKK");
        PersistentUtils.saveObjToFile(screen, "test1.txt");
    }

    @Test
    public void getObject(){
        Object object = PersistentUtils.getObjFromFile("/Users/xujinfengxu/Desktop/cinema_management_and_booking_system/test1.txt");
        Screen screen = (Screen) object;
        System.out.println(screen.toString());
    }

    @Test
    public void testPersistent(){
        String string = System.getProperty("user.dir") + File.separatorChar + "src" + File.separatorChar +
                "main" + File.separatorChar + "persistent" +  File.separatorChar + "test.txt";
        System.out.println((new File(string)).exists());
    }

    @Test
    public void getTimeTableById(){
        TimeTable timeTable = PersistentUtils.getTimeTableById("1");
        System.out.println(timeTable.toString());
    }

    @Test
    public void saveTimeTableToFile(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TimeTableMapper mapper = sqlSession.getMapper(TimeTableMapper.class);
        TimeTable tableById = mapper.getTimeTableById("1");
        PersistentUtils.saveTimeTableToFile(tableById, tableById.getId());
    }



    @Test
    public void changePersistentTimeTable(){
        TimeTable timeTable = PersistentUtils.getTimeTableById("1");
        System.out.println(timeTable.toString());
        timeTable.setPrice("4");
        PersistentUtils.saveTimeTableToFile(timeTable, "1");
        TimeTable timeTable2 = PersistentUtils.getTimeTableById("1");
        System.out.println(timeTable2.toString());
    }
}
