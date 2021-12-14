package com.group11.pojo;

import org.apache.ibatis.type.Alias;

@Alias("Customer")
public class Customer {
    // Defining private properties
    private String id;
    private String username;
    private String password;

    // A constructor with no arguments
    public Customer() {
    }

    // A constructor with arguments
    public Customer(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
