package com.group11.dao;

import com.group11.pojo.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {

    public Administrator getAdministratorById(@Param("id") int id);

    public List<Administrator> getAdministrator();

    public Administrator getAdministratorByUserName(@Param("username") String username);

    public int addAdministrator(Administrator administrator);

    public int updateAdministratorPassword(Administrator administrator);
}
