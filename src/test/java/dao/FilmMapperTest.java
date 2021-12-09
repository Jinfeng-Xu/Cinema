package dao;

import com.group11.dao.FilmMapper;
import com.group11.pojo.Film;
import com.group11.util.FormatUtils;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FilmMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getFilm(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        List<Film> films = mapper.getFilm();
        for (Film film : films) {
            System.out.println(film);
        }
        sqlSession.close();
    }

    @Test
    public void getFilmById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        Film film = mapper.getFilmById("123");
        System.out.println(film);
        sqlSession.close();
    }


    @Test
    public void getFilmByName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        Film film = mapper.getFilmByName("test");
        System.out.println(film);
        sqlSession.close();
    }

    @Test
    public void addFilm(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        File file = new File("/Users/xujinfengxu/Desktop/computer/素材库/精灵球.jpg");
        java.util.Date utilDate = new java.util.Date(); //获取当前时间
        System.out.println(utilDate);
        int test = mapper.addFilm(new Film("1253", "test", FormatUtils.transferFileToByte(file), "1", "2", utilDate, "1"));
        if(test > 0){
            System.out.println("OK");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteFilm(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        int i = mapper.deleteFilm("123");
        if(i > 0)
            System.out.println("OK");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getFilmByTimeTableId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        FilmMapper mapper = sqlSession.getMapper(FilmMapper.class);
        Film film = mapper.getFilmByTimeTableId("122");
        System.out.println(film.toString());
        sqlSession.close();
    }

}
