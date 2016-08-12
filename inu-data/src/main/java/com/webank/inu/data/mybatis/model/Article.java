package com.webank.inu.data.mybatis.model;

/**
 * Created by potato on 2016/8/11.
 */
public class Article {
    
    /**
     * 主键id
     */
    int id;

    /**
     * 资源标题
     */
    String title;

    /**
     * 资源描述
     */
    String description;

    /**
     * 资源url
     */
    String url;

    /**
     * 度数最小值
     */
    double degreeMin;

    /**
     *度数最大值
     */
    double degreeMax;

    /**
     *图片URL
     */
    String picUrl;

    /**
     *资源内容
     */
    String content;

    /**
     *资源类型，0是文章，1是音乐
     */
    int resourceType;

    /**
     *链接类型，0是内链，1是外链
     */
    int linkType;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }
}
