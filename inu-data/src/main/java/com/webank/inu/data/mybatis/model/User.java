package com.webank.inu.data.mybatis.model;

/**
 * Created by potato on 2016/8/10.
 */
public class User {

    /**
     *主键id
     */
    int id;

    /**
     *用户的唯一标识
     */
    String openId;

    /**
     *昵称
     */
    String nickName;

    /**
     *情绪值
     */
    double mood;

    /**
     *头像
     */
    String avatar;


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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getMood() {
        return mood;
    }

    public void setMood(double mood) {
        this.mood = mood;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
