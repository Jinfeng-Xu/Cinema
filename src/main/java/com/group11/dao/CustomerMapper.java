package com.group11.dao;

import com.group11.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    public Customer getCustomerById(@Param("id") int id);

    public List<Customer> getCustomer();

    public Customer getCustomerByUserName(@Param("username") String username);

    public int addCustomer(Customer customer);

    public int updateCustomerPassword(Customer customer);
}
