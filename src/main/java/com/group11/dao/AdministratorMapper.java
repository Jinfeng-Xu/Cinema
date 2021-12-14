package com.group11.dao;

import com.group11.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {

    // get an administrator from cloud db by id
    public Administrator getAdministratorById(@Param("id") int id);

    // get all administrators from cloud db
    public List<Administrator> getAdministrator();

    // get an administrator from cloud db by username
    public Administrator getAdministratorByUserName(@Param("username") String username);

    // add an administrator to cloud db
    public int addAdministrator(Administrator administrator);

    // update an administrator's password in cloud db
    public int updateAdministratorPassword(Administrator administrator);
}
