package com.webank.inu.data.mybatis.model;

/**
 * Created by potato on 2016/8/11.
 */
public class Article {
    int id;
    String title;
    String description;
    String url;
    double degreeMin;
    double degreeMax;
    String picUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getDegreeMin() {
        return degreeMin;
    }

    public void setDegreeMin(double degreeMin) {
        this.degreeMin = degreeMin;
    }

    public double getDegreeMax() {
        return degreeMax;
    }

    public void setDegreeMax(double degreeMax) {
        this.degreeMax = degreeMax;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
