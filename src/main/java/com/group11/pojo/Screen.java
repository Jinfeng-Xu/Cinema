package com.group11.pojo;

import org.apache.ibatis.type.Alias;

@Alias("Screen")
public class Screen {

    private String id;
    private String type;

    public Screen() {
    }

    public Screen(String id, String type) {
        this.id = id;
        this.type = type;
    }




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
