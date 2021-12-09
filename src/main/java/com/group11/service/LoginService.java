package com.group11.service;

public interface LoginService{

    public int login(String username, String password, boolean type);

    public int register(String username, String password, String confirm_password, boolean type);

    public boolean changeCustomer(String username, String origin, String password, String confirm_password);

    public boolean changeAdministrator(String username, String origin, String password, String confirm_password);
}
