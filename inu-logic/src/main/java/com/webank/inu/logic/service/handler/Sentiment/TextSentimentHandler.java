package com.webank.inu.logic.service.handler.Sentiment;

import com.alibaba.fastjson.JSON;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.sun.org.apache.xpath.internal.operations.String;
import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;
import com.webank.inu.logic.utils.ConfigInfo;

import java.util.TreeMap;

/**
 * Created by adam on 2016/8/11.
 */
public class TextSentimentHandler implements SynPStreamHandler {

    private ConfigInfo configInfo = ConfigInfo.getInstance();

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
            System.out.println(result);
            sentimentResult = (SentimentResult) JSON.parse(result);
            System.out.println(sentimentResult);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }

        return sentimentResult;
    }
}
