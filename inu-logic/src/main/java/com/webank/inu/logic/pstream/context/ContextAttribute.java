package com.webank.inu.logic.pstream.context;

/**
 * Created by adam on 2016/8/11.
 */
public class ContextAttribute {

    //无则使用handler的class name
    private String producer;

    private Object data;

    public ContextAttribute(){}

    public ContextAttribute(Object data){
        this.data = data;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
