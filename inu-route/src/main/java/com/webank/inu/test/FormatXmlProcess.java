package com.webank.inu.test;

import java.util.Date;

/** 
 * 封装最终的xml格式结果 
 * @author pamchen-1 
 * 
 */  
public class FormatXmlProcess {  
    /** 
     * 封装文字类的返回消息 
     * @param to 
     * @param from 
     * @param content 
     * @return 
     */  
    public String formatXmlNewsAnswer(String to, String from, String content,
    		String title,String description,String picUrl,String url) {  
        StringBuffer sb = new StringBuffer();  
        Date date = new Date();  
        sb.append("<xml><ToUserName><![CDATA[");  
        sb.append(to);  
        sb.append("]]></ToUserName><FromUserName><![CDATA[");  
        sb.append(from);  
        sb.append("]]></FromUserName><CreateTime>");  
        sb.append(date.getTime()).append("</CreateTime>"); 
        sb.append("<ArticleCount>1</ArticleCount>");
        sb.append("<Articles><item><Title><![CDATA[");
        sb.append(title);
        sb.append("]]></Title> <Description><![CDATA[");
        sb.append(description);
        sb.append("]]></Description><PicUrl><![CDATA[").append(picUrl);
        sb.append("]]></PicUrl><Url><![CDATA[").append(url);
        sb.append("]]></Url></item></Articles>");
        sb.append("<MsgType><![CDATA[news]]></MsgType><Content><![CDATA[");  
        sb.append(content);  
        sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");  
        return sb.toString();  
    }  
    
    public String formatXmlTextAnswer(String to, String from, String content) {  
        StringBuffer sb = new StringBuffer();  
        Date date = new Date();  
        sb.append("<xml><ToUserName><![CDATA[");  
        sb.append(to);  
        sb.append("]]></ToUserName><FromUserName><![CDATA[");  
        sb.append(from);  
        sb.append("]]></FromUserName><CreateTime>");  
        sb.append(date.getTime());  
        sb.append("</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[");  
        sb.append(content);  
        sb.append("]]></Content><FuncFlag>0</FuncFlag></xml>");  
        return sb.toString();  
    }
}  
