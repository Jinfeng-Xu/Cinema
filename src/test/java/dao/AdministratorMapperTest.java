package dao;


import com.group11.dao.AdministratorMapper;
import com.group11.pojo.Administrator;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class AdministratorMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getAdministrator(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        List<Administrator> administrators = mapper.getAdministrator();
        for (Administrator administrator : administrators) {
            System.out.println(administrator.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getAdministratorById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        Administrator administrator = mapper.getAdministratorById(1);
        System.out.println(administrator.toString());
        sqlSession.close();
    }

    @Test
    public void getAdministratorByUserName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        Administrator administrator = mapper.getAdministratorByUserName("admin");
        System.out.println(administrator.toString());
        sqlSession.close();
    }

    @Test
    public void addAdministrator(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        int count = mapper.addAdministrator(new Administrator(UUID.randomUUID().toString(), "admin", "142857"));
        if(count > 0)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateAdministratorPassword(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        Administrator admin = mapper.getAdministratorByUserName("admin");
        admin.setPassword("111");
        int count = mapper.updateAdministratorPassword(admin);
        if (count > 0)
            System.out.println("更新成功");
        else
            System.out.println("更新失败");
        sqlSession.commit();
        sqlSession.close();
    }
}
