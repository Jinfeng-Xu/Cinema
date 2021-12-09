package dao;


import com.group11.dao.CustomerMapper;
import com.group11.pojo.Customer;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class CustomerMapperTest {

    static Logger logger = Logger.getLogger(CustomerMapperTest.class);

    @Test
    public void getCustomer(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.getCustomer();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getCustomerById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerById(1);
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @Test
    public void getCustomerByUserName(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerByUserName("xjf");
        System.out.println(customer.toString());
        sqlSession.close();
    }

    @Test
    public void addCustomer(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        int count = mapper.addCustomer(new Customer(UUID.randomUUID().toString(), "czy", "142857"));
        if(count > 0)
            System.out.println("插入成功");
        else
            System.out.println("插入失败");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateCustomerPassword(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerByUserName("czy");
        customer.setPassword("123456");
        int count = mapper.updateCustomerPassword(customer);
        if(count > 0)
            System.out.println("更新成功");
        else
            System.out.println("更新成功");
        sqlSession.commit();
        sqlSession.close();
    }

}
