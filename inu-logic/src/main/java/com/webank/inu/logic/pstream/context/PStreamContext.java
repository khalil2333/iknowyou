package com.webank.inu.logic.pstream.context;

import com.webank.inu.logic.pstream.process.PStream;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adam on 2016/8/11.
 */
public class PStreamContext {

    private Map<String,ContextAttribute> attributes;

    private PStream parent;

    public PStreamContext(){
        attributes = new HashMap<String, ContextAttribute>();
    }

    public PStreamContext(PStream parent){
        this();
        this.parent = parent;
    }

    public Map<String, ContextAttribute> getAttributes() {
        return attributes;
    }

    public void addAttribute(String name,Object data){
        addAttribute(name,null,data);
    }

    public void addAttribute(String name,String producer,Object data){
        ContextAttribute attribute = new ContextAttribute();
        attribute.setProducer(producer);
        attribute.setData(data);
        attributes.put(name,attribute);
    }

    public void addAttribute(String name,ContextAttribute attribute){
        attributes.put(name,attribute);
    }

    public Object getAttribute(String name){
        return attributes.get(name);
    }

    public PStream getParent() {
        return parent;
    }

    public void setParent(PStream parent) {
        this.parent = parent;
    }
}
