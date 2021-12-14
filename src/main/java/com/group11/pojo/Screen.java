package com.group11.pojo;

import org.apache.ibatis.type.Alias;

@Alias("Screen")
public class Screen {
    // Defining private properties
    private String id;
    private String type;

    // A constructor with no arguments
    public Screen() {
    }

    // A constructor with arguments
    public Screen(String id, String type) {
        this.id = id;
        this.type = type;
    }

    // Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
