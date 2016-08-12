package com.webank.inu.data.mybatis.model;

import java.sql.Timestamp;

/**
 * Created by potato on 2016/8/11.
 */
public class HistoryMood {

    /**
     *主键id
     */
    public int id;

    /**
     *用户的openId
     */
    String openId;

    /**
     *消息发送时间
     */
    Timestamp recordTime;

    /**
     *消息内容
     */
    String message;

    /**
     *用户情绪值
     */
    double userMood;

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

    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getUserMood() {
        return userMood;
    }

    public void setUserMood(double userMood) {
        this.userMood = userMood;
    }
}
