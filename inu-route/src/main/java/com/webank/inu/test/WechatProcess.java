package com.webank.inu.test;

/** 
 * 微信xml消息处理流程逻辑类 
 * @author pamchen-1 
 * 
 */  
public class WechatProcess {  
    /** 
     * 解析处理xml、获取智能回复结果（通过图灵机器人api接口） 
     * @param xml 接收到的微信数据 
     * @return  最终的解析结果（xml格式数据） 
     */  
    public String processWechatMag(String xml){  
        /** 解析xml数据 */  
//    	System.out.println("xml : "+xml);
        ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);  
          
        /** 以文本消息为例，调用图灵机器人api接口，获取回复内容 */  
        String result = "";  
        if("text".endsWith(xmlEntity.getMsgType())){  
            result = new TulingApiProcess().getTulingResult(xmlEntity.getContent());  
        }  
          
        /** 此时，如果用户输入的是“你好”，在经过上面的过程之后，result为“你也好”类似的内容  
         *  因为最终回复给微信的也是xml格式的数据，所有需要将其封装为文本类型返回消息 
         * */  
        String title="test";
        String description="d";
        String picUrl="http://pic.sc.chinaz.com/files/pic/pic9/201508/apic14052.jpg";
        String url="http://docs.spring.io/spring-batch/reference/html/";
        result = new FormatXmlProcess().formatXmlNewsAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result,
        		title,description,picUrl,url);  
          
        return result;  
    }  
}  