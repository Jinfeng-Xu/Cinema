package dao;

import com.group11.dao.BillMapper;
import com.group11.pojo.Bill;
import com.group11.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

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
        int count = mapper.addBill(new Bill("12", utilDate, utilDate, "装弹比赛", "8bq", "4", "3", "2a079dbd-2d16-498c-9970-5958036e59e0", "3", "4"));
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
}
