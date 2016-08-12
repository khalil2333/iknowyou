package com.webank.inu.test;

import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.ResponseInfo;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;

/**
 * 微信xml消息处理流程逻辑类 
 * 
 */  
public class WechatProcess {  
    /** 
     * 解析处理xml、拼装结果xml
     * @param xml 接收到的微信数据 
     * @return  最终的解析结果（xml格式数据） 
     */  
    public String processWechatMag(String xml){  
        /** 解析xml数据 */  
//    	System.out.println("xml : "+xml);
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);  
          
        String result = "";  
        if("text".endsWith(xmlEntity.getMsgType())){  
            result = xmlEntity.getContent();  
        }  
          
        IMessageService messageService = new BaseMessageServiceImpl();
        ResponseInfo responseInfo =
                messageService.processMessage(xmlEntity.getFromUserName(), result,
                        IMessageService.ResponseType.news);
        //测试数据
        String title="test";
        String description="d";
        String picUrl="http://pic.sc.chinaz.com/files/pic/pic9/201508/apic14052.jpg";
        String articleId="22";
        String url="http://iknowu.qaq.moe/article.html?articleId="+articleId;
        responseInfo.setTitle(title);
        responseInfo.setDescription(description);
        responseInfo.setPicUrl(picUrl);
        responseInfo.setUrl(url);
        //测试数据

        /** 
         *  封装为文本类型,作为xml结果 
         * */
        result = new FormatXmlProcess().formatXmlNewsAnswer(
                responseInfo.getToUserName(), xmlEntity.getToUserName(), responseInfo.getContent(),
        		responseInfo.getTitle(),responseInfo.getDescription(),
                responseInfo.getPicUrl(),responseInfo.getUrl());
          
        return result;  
    }  
}  