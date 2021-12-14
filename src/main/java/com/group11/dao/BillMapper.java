package com.group11.dao;

import com.group11.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    // get all bills from cloud db
    public List<Bill> getBill();

    // get a bill from cloud db by id
    public Bill getBillById(@Param("id") String id);

    // add a bill to cloud db
    public int addBill(Bill bill);

    // delete a bill from cloud db by id
    public int deleteBill(@Param("id") String id);

    // get bills from cloud by customer id
    public List<Bill> getBillByCustomerId(@Param("customerId") String customerId);


}
