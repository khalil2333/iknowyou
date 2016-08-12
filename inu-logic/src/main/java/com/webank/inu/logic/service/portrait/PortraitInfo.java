package com.webank.inu.logic.service.portrait;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adam on 2016/8/12.
 */
public class PortraitInfo {

    private List<String> tags;

    private float sentiment;

    public PortraitInfo(){
        tags = new LinkedList<String>();
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public List<String> getTags(){
        return tags;
    }

    public float getSentiment() {
        return sentiment;
    }

    public void setSentiment(float sentiment) {
        this.sentiment = sentiment;
    }
}
