package com.group11.dao;

import com.group11.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillMapper {

    public List<Bill> getBill();

    public Bill getBillById(@Param("id") String id);

    public int addBill(Bill bill);

    public int deleteBill(@Param("id") String id);


}
