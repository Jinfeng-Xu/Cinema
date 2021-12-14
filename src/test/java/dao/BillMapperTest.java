package dao;

import com.group11.dao.BillMapper;
import com.group11.pojo.Bill;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class BillMapperTest {

    static Logger logger = Logger.getLogger(AdministratorMapperTest.class);

    @Test
    public void getBill(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.getBill();
        for (Bill bill : bills) {
            System.out.println(bill.toString());
        }
        sqlSession.close();
    }

    @Test
    public void getBillById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        Bill bill = mapper.getBillById("12");
        System.out.println(bill.toString());
        sqlSession.close();
    }

    @Test
    public void addBill(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        java.util.Date utilDate = new java.util.Date(); //获取当前时间
//        for(int i = 0; i < 20; i ++){
//            int count = mapper.addBill(new Bill(String.valueOf(i), utilDate, utilDate, "222", "middle", "4", "3", "16", String.valueOf(i), String.valueOf(i), String.valueOf(Math.random()*100)));
//        }
        int count = mapper.addBill(new Bill("12", utilDate, utilDate, "222", "8bq", "4", "3", "16", "3", "4", "2"));
        if(count > 0)
            System.out.println("OKK");
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteBill(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        int i = mapper.deleteBill("12");
        if(i > 0){
            System.out.println("Successful!");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getBillByCustomerId(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bill> bills = mapper.getBillByCustomerId("16");
        for (Bill bill : bills) {
            System.out.println(bill.toString());
        }
        sqlSession.close();
    }
}
