package com.group11.service;

import com.group11.dao.AdministratorMapper;
import com.group11.dao.CustomerMapper;
import com.group11.pojo.Administrator;
import com.group11.pojo.Customer;
import com.group11.util.MybatisUtils;
import com.group11.util.PasswordUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.UUID;
import java.util.regex.Pattern;

public class LoginServiceImpl implements LoginService{

    public Object login(String username, String password, boolean type){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        if (type){
            CustomerMapper mapper_c = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = mapper_c.getCustomerByUserName(username);
            sqlSession.close();
            if (customer != null && PasswordUtils.validatePassword(customer.getPassword(), password)){
                return customer;
            }else {
                return null;
            }
        }else {
            AdministratorMapper mapper_a = sqlSession.getMapper(AdministratorMapper.class);
            Administrator administrator = mapper_a.getAdministratorByUserName(username);
            sqlSession.close();
            if (administrator != null && PasswordUtils.validatePassword(administrator.getPassword(), password)){
                return administrator;
            }else {
                return null;
            }
        }
    }

    // 用户名字母数字下划线，密码字母数字，长度均小于17
    // type = true代表Customer, type = false代表Administrator
    // Customer注册成功返回0, Administrator注册成功返回1, 注册失败返回2
    public int register(String username, String password, String confirm_password, boolean type){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        if(isUsername(username) && password.equals(confirm_password) && isPassword(password))
            if(type){
                CustomerMapper mapper_c = sqlSession.getMapper(CustomerMapper.class);
                Customer customer = mapper_c.getCustomerByUserName(username);
                if(customer == null){
                    registerCustomer(username, password);
                    return 0;
                }
            }
            else{
                AdministratorMapper mapper_a = sqlSession.getMapper(AdministratorMapper.class);
                Administrator administrator = mapper_a.getAdministratorByUserName(username);
                if(administrator == null){
                    registerAdministrator(username, password);
                    return 1;
                }
            }
        sqlSession.close();
        return 2;
    }

    public void registerCustomer(String username, String password){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        int count = mapper.addCustomer(new Customer(UUID.randomUUID().toString(), username, PasswordUtils.generatePassword(password)));
        if (count != 0)
            System.out.println("Insert Successful");
        else
            System.out.println("Insert Unsuccessful");
        sqlSession.commit();
        sqlSession.close();
    }

    public void registerAdministrator(String username, String password){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        int count = mapper.addAdministrator(new Administrator(UUID.randomUUID().toString(), username, PasswordUtils.generatePassword(password)));
        if (count != 0)
            System.out.println("Insert Successful");
        else
            System.out.println("Insert Unsuccessful");
        sqlSession.commit();
        sqlSession.close();
    }

    public boolean isUsername(String username) {
        final String REGEX_USERNAME = "^[0-9a-zA-Z_]{6,17}+$";
        return Pattern.matches(REGEX_USERNAME, username);
    }

    public boolean isPassword(String password) {
        final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,17}$";
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    public boolean changeCustomer(String username, String origin, String password, String confirm_password) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = mapper.getCustomerByUserName(username);
        if (customer != null && PasswordUtils.validatePassword(customer.getPassword(), origin) && password.equals(confirm_password)) {
            customer.setPassword(PasswordUtils.generatePassword(password));
            int count = mapper.updateCustomerPassword(customer);
            if (count != 0)
                System.out.println("Change Successful");
            else
                System.out.println("Change Unsuccessful");
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        sqlSession.close();
        return false;
    }

    public boolean changeAdministrator(String username, String origin, String password, String confirm_password) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        AdministratorMapper mapper = sqlSession.getMapper(AdministratorMapper.class);
        Administrator administrator = mapper.getAdministratorByUserName(username);
        if (administrator != null && PasswordUtils.validatePassword(administrator.getPassword(), origin) && password.equals(confirm_password)) {
            administrator.setPassword(PasswordUtils.generatePassword(password));
            int count = mapper.updateAdministratorPassword(administrator);
            if (count != 0)
                System.out.println("Change Successful");
            else
                System.out.println("Change Unsuccessful");
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        sqlSession.close();
        return false;
    }


}
