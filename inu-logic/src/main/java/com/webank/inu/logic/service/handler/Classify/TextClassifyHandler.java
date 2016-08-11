package com.webank.inu.logic.service.handler.Classify;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qcloud.Module.Wenzhi;
import com.qcloud.QcloudApiModuleCenter;
import com.webank.inu.logic.pstream.context.PStreamContext;
import com.webank.inu.logic.pstream.handler.SynPStreamHandler;
import com.webank.inu.logic.utils.ConfigInfo;

import java.util.List;
import java.util.TreeMap;

/**
 * Created by adam on 2016/8/11.
 */
public class TextClassifyHandler implements SynPStreamHandler{

    private ConfigInfo configInfo = ConfigInfo.getInstance();

    private Gson gson = new GsonBuilder().create();

    public static final String CLASSIFY_CLASS = "ClassifyClass";

    public static final String CLASSIFY_NUM = "ClassifyNum";

    public Object handle(PStreamContext context, Object fromData) {
        if (!(fromData instanceof java.lang.String)) {
            return null;
        }
        java.lang.String chatMsg = (java.lang.String) fromData;
        TreeMap<String, Object> config = new TreeMap<java.lang.String, Object>();
        config.put("SecretId", configInfo.TXSecretId());
        config.put("SecretKey", configInfo.TXSecretKey());
        config.put("RequestMethod", "GET");
        config.put("DefaultRegion", "sz");
        QcloudApiModuleCenter module = new QcloudApiModuleCenter(new Wenzhi(), config);
        TreeMap<java.lang.String, Object> params = new TreeMap<java.lang.String, Object>();
        params.put("content",chatMsg);

        ClassifyResult classifyResult= null;
        java.lang.String result = null;
        try {
            result = module.call("TextClassify", params);
            classifyResult = gson.fromJson(result,ClassifyResult.class);
            List<ClassifyResult.Clazz> clazzs = classifyResult.getClasses();
            String clazz = null;
            float conf = 0;
            int clazz_num = -1;
            for (ClassifyResult.Clazz clz : clazzs){
                if (conf < clz.getConf()){
                    clazz = clz.getClazz();
                    conf = clz.getConf();
                    clazz_num = clz.getClass_num();
                }
            }
            context.addAttribute(CLASSIFY_CLASS,this.getClass().getName(),clazz);
            context.addAttribute(CLASSIFY_NUM,this.getClass().getName(),clazz_num);
        } catch (Exception e) {
            System.out.println("error..." + e.getMessage());
        }

        return fromData;
    }

    public static void main(String[] args) {
        new TextClassifyHandler().handle(null,"今天天气不错,好开心啊");
    }
}
