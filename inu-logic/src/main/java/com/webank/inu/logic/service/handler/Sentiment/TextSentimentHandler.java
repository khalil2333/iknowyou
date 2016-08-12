package com.webank.inu.logic.service.handler.Sentiment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;
import com.webank.inu.logic.utils.ConfigInfo;

import java.util.TreeMap;

/**
 * Created by adam on 2016/8/11.
 */
public class TextSentimentHandler implements SynPStreamHandler {

    private ConfigInfo configInfo = ConfigInfo.getInstance();

    private Gson gson = new GsonBuilder().create();

    public static final String SENTIMENT_SCORE = "SentimentScore";

    public Object handle(PStreamContext context, Object fromData) {
        if (!(fromData instanceof java.lang.String)) {
            return null;
        }
        java.lang.String chatMsg = (java.lang.String) fromData;
        TreeMap<java.lang.String, Object> config = new TreeMap<java.lang.String, Object>();
        config.put("SecretId", configInfo.TXSecretId());
        config.put("SecretKey", configInfo.TXSecretKey());
        config.put("RequestMethod", "GET");
        config.put("DefaultRegion", "sz");
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(), config);
        TreeMap<java.lang.String, Object> params = new TreeMap<java.lang.String, Object>();
        params.put("content",chatMsg);

        SentimentResult sentimentResult = null;
        java.lang.String result = null;
        try {
            result = module.call("TextSentiment", params);
            sentimentResult = gson.fromJson(result,SentimentResult.class);
//            System.out.println("s : "+sentimentResult);
            context.addAttribute(SENTIMENT_SCORE,this.getClass().getName(),sentimentResult.getPositive());
        } catch (Exception e) {
            System.out.println("in error");
            e.printStackTrace();
            System.out.println("error..." + e.getMessage());
        }

        return fromData;
    }
}
