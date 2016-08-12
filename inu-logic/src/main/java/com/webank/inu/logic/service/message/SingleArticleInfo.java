package com.webank.inu.logic.service.message;

/**
 * Created by adam on 2016/8/12.
 */
public class SingleArticleInfo {

    private String title;

    private String content;

    private String picUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "SingleArticleInfo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", picUrl='" + picUrl + '\'' +
                '}';
    }
}
