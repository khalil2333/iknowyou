package com.webank.inu.data.mybatis.model;

import java.sql.Timestamp;

/**
 * Created by potato on 2016/8/11.
 */
public class HistoryMood {
    public int id;
    String openId;
    Timestamp time;
    String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
