package dao;

import com.group11.dao.ScreenMapper;
import com.group11.pojo.Screen;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class ScreenMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getScreen(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        List<Screen> screens = mapper.getScreen();
        for (Screen screen : screens) {
            System.out.println(screen.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getScreenById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        Screen screen = mapper.getScreenById("222");
        System.out.println(screen.toString());
        sqlSession.close();
    }

    @Test
    public void addScreen(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        int count = mapper.addScreen(new Screen("222", "MZX"));
        if(count > 0){
            System.out.println("OK");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getScreenByTimeTableId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        ScreenMapper mapper = sqlSession.getMapper(ScreenMapper.class);
        Screen screen = mapper.getScreenByTimeTableId("122");
        System.out.println(screen.toString());
        sqlSession.close();
    }
}
