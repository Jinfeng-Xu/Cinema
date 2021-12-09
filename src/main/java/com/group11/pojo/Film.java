package com.group11.pojo;

import org.apache.ibatis.type.Alias;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Alias("Film")
public class Film {
    private String id;
    private String name;
    // 图片转换的base64字符，取的时候用这个
    private String base64;
    // byte[]形式的base64格式,BLOB,存的时候用这个
    private byte[] base64Byte;
    private String duration;
    private String protagonist;
    private Date releaseTime;
    private String info;

    public Film(String id, String name, byte[] base64Byte, String duration, String protagonist, Date releaseTime, String info) {
        this.id = id;
        this.name = name;
        this.base64Byte = base64Byte;
        this.duration = duration;
        this.protagonist = protagonist;
        this.releaseTime = releaseTime;
        this.info = info;
    }

    public Film() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) throws UnsupportedEncodingException {
        this.base64 = base64;
        this.base64Byte = base64.getBytes("UTF8");
    }

    public byte[] getBase64Byte() {
        return base64Byte;
    }

    public void setBase64Byte(byte[] base64Byte) {
        this.base64Byte = base64Byte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", protagonist='" + protagonist + '\'' +
                ", releaseTime=" + releaseTime +
                ", info='" + info + '\'' +
                '}';
    }
}
