package com.group11.dao;

import com.group11.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    // get a customer from cloud db by id
    public Customer getCustomerById(@Param("id") int id);

    // get all customers from cloud db
    public List<Customer> getCustomer();

    // get a customer from cloud db by username
    public Customer getCustomerByUserName(@Param("username") String username);

    // add a customer to cloud db
    public int addCustomer(Customer customer);

    // update a customer's password in cloud db
    public int updateCustomerPassword(Customer customer);
}
