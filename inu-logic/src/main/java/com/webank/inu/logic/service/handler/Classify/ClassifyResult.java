package com.webank.inu.logic.service.handler.Classify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by adam on 2016/8/11.
 */
public class ClassifyResult {

    private int code;

    private String message;

    private String codeDesc;

    private List<Clazz> classes;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public List<Clazz> getClasses() {
        return classes;
    }

    public void setClasses(List<Clazz> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "ClassifyResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", codeDesc='" + codeDesc + '\'' +
                ", classes=" + classes +
                '}';
    }

    public static class Clazz{
        @SerializedName("class")
        private String clazz;

        private int class_num;

        private float conf;

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public int getClass_num() {
            return class_num;
        }

        public void setClass_num(int class_num) {
            this.class_num = class_num;
        }

        public float getConf() {
            return conf;
        }

        public void setConf(float conf) {
            this.conf = conf;
        }

        @Override
        public String toString() {
            return "Clazz{" +
                    "clazz='" + clazz + '\'' +
                    ", class_num=" + class_num +
                    ", conf=" + conf +
                    '}';
        }
    }
}
