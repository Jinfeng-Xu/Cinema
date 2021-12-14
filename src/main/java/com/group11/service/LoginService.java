package com.group11.service;

public interface LoginService{

    /**
     * This method executes login operation
     * @param username presents user name
     * @param password presents user's password
     * @param type presents user's type
     * @return a Object
     */
    public Object login(String username, String password, boolean type);

    /**
     * This method executes register operation
     * @param username presents user name
     * @param password presents user's password
     * @param confirm_password presents user's confirmation password
     * @param type presents user's type
     * @return a integer, different outcome present if register succeeded
     */
    public int register(String username, String password, String confirm_password, boolean type);

    /**
     * This method change customers' password
     * @param username presents user name
     * @param origin presents user's original password
     * @param password presents user's new password
     * @param confirm_password presents user's confirmation password
     * @return true or false to identify if the change operation succeeded
     */
    public boolean changeCustomer(String username, String origin, String password, String confirm_password);

    /**
     * This method change administers' password
     * @param username presents user name
     * @param origin presents user's original password
     * @param password presents user's new password
     * @param confirm_password presents user's confirmation password
     * @return true or false to identify if the change operation succeeded
     */
    public boolean changeAdministrator(String username, String origin, String password, String confirm_password);
}
