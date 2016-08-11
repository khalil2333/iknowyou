package com.webank.inu.logic.service.handler.Sentiment;

/**
 * Created by adam on 2016/8/11.
 */
public class SentimentResult {
    private int code;

    private String message;

    private String codeDesc;

    private float positive;

    private float negative;

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

    public float getPositive() {
        return positive;
    }

    public void setPositive(float positive) {
        this.positive = positive;
    }

    public float getNegative() {
        return negative;
    }

    public void setNegative(float negative) {
        this.negative = negative;
    }

    @Override
    public String toString() {
        return "SentimentResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", codeDesc='" + codeDesc + '\'' +
                ", positive=" + positive +
                ", negative=" + negative +
                '}';
    }
}
