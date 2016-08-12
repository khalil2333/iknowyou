package com.webank.inu.logic.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by adam on 2016/8/11.
 */
public class ConfigInfo extends Properties {
    private static ConfigInfo instance = new ConfigInfo();

    private String configFileName = "/configMsg.properties";

    private ConfigInfo(){}

    {
        try {
            this.load(ConfigInfo.class.getResourceAsStream(configFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConfigInfo getInstance(){
        return instance;
    }

    public String TXSecretId(){
        return getProperty("TX_SecretId");
    }

    public String TXSecretKey(){
        return getProperty("TX_SecretKey");
    }

    public String getWXDevelopName(){
        return getProperty("WX_DeveloperName");
    }

    public String getArticleURLPrex(){
        return getProperty("article.url.prex");
    }
}
