package com.webank.inu.test;

//import com.webank.inu.constant.Event;
import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;
import com.webank.inu.logic.service.history.impl.BaseHistoryChatImpl;
import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.ResponseInfo;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;

import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 微信xml消息处理流程逻辑类
 * 
 */
public class WechatProcess {
	private static Logger logger = Logger.getLogger(WechatProcess.class);

	/**
	 * 解析处理xml、拼装结果xml
	 * 
	 * @param xml
	 *            接收到的微信数据
	 * @return 最终的解析结果（xml格式数据）
	 */
	public String processWechatMag(String xml) {
		/** 解析xml数据 */
		// System.out.println("xml : "+xml);
		logger.warn("log : " + xml);
//		System.out.println("xml : "+xml);

		ReceiveXmlEntity xmlEntity = new ReceiveXmlProcess().getMsgEntity(xml);

		String result = "";
		if ("text".endsWith(xmlEntity.getMsgType())) {
			logger.warn(" =============================  in text");
//			System.out.println("content : "+xmlEntity.getContent());
			IMessageService messageService = new BaseMessageServiceImpl();
			ResponseInfo responseInfo = messageService.processMessage(xmlEntity.getFromUserName(), xmlEntity.getContent(),
					IMessageService.ResponseType.news);
			/**
			 * 封装为文本类型,作为xml结果
			 */
			result = new FormatXmlProcess().formatXmlNewsAnswer(responseInfo.getToUserName(), xmlEntity.getToUserName(),
					responseInfo.getContent(), responseInfo.getTitle(), responseInfo.getDescription(),
					responseInfo.getPicUrl(), responseInfo.getUrl());
			// 测试数据
			// String title="test";
			// String description="d";
			// String
			// picUrl="http://pic.sc.chinaz.com/files/pic/pic9/201508/apic14052.jFpg";
			// String url="http://docs.spring.io/spring-batch/reference/html/";
			// responseInfo.setTitle(title);
			// responseInfo.setDescription(description);
			// responseInfo.setPicUrl(picUrl);
			// responseInfo.setUrl(url);
			// 测试数据
		} else if ("event".endsWith(xmlEntity.getMsgType())) {
			logger.warn(" +++++++++++++++++++++++++++++++ in event");
			if ("CLICK".endsWith(xmlEntity.getEvent())) {
				if ("event_history".endsWith(xmlEntity.getEventKey())) {
					String title="历史心情";
					String Url="http://iknowu.qaq.moe/history.html?openId="+xmlEntity.getFromUserName();
					//String historyChat=getHistoryChat(xmlEntity.getFromUserName());
					result=new FormatXmlProcess().formatXmlEventClickAnswer(xmlEntity.getFromUserName(), 
							xmlEntity.getToUserName(),title , Url);
				}else if("event_article".endsWith(xmlEntity.getEventKey())){
					//这里需要获取随机文章：所以采用随便一个人的id:oAcTMwelIB2AAFr9W4L0qmYPvzJg,
					String openId="oAcTMwelIB2AAFr9W4L0qmYPvzJg";
					String content="我要带你飞";
//					IMessageService messageService = new BaseMessageServiceImpl();
//					ResponseInfo responseInfo = messageService.processMessage(openId,content,
//							IMessageService.ResponseType.news);
					/**
					 * 封装为文本类型,作为xml结果
					 */
//					result = new FormatXmlProcess().formatXmlNewsAnswer(responseInfo.getToUserName(), xmlEntity.getToUserName(),
//							responseInfo.getContent(), responseInfo.getTitle(), responseInfo.getDescription(),
//							responseInfo.getPicUrl(), responseInfo.getUrl());
					result = new FormatXmlProcess().formatXmlTextAnswer(
							xmlEntity.getFromUserName(),
							xmlEntity.getToUserName(),
							"服务未开通"
					);
				}else if("event_music".endsWith(xmlEntity.getEventKey())){
					String content="抱歉，此服务暂未开通";
//					IMessageService messageService = new BaseMessageServiceImpl();
//					ResponseInfo responseInfo = messageService.processMessage(xmlEntity.getFromUserName(),content,
//							IMessageService.ResponseType.news);
//					/**
//					 * 封装为文本类型,作为xml结果
//					 */
//					result = new FormatXmlProcess().formatXmlNewsAnswer(responseInfo.getToUserName(), xmlEntity.getToUserName(),
//							responseInfo.getContent(), responseInfo.getTitle(), responseInfo.getDescription(),
//							responseInfo.getPicUrl(), responseInfo.getUrl());
					result = new FormatXmlProcess().formatXmlTextAnswer(
							xmlEntity.getFromUserName(),
							xmlEntity.getToUserName(),
							"服务未开通"
					);
				}else if("event_video".endsWith(xmlEntity.getEventKey())){
					String content="抱歉，此服务暂未开通";
//					IMessageService messageService = new BaseMessageServiceImpl();
//					ResponseInfo responseInfo = messageService.processMessage(xmlEntity.getFromUserName(),content,
//							IMessageService.ResponseType.news);
//					/**
//					 * 封装为文本类型,作为xml结果
//					 */
//					result = new FormatXmlProcess().formatXmlNewsAnswer(responseInfo.getToUserName(), xmlEntity.getToUserName(),
//							responseInfo.getContent(), responseInfo.getTitle(), responseInfo.getDescription(),
//							responseInfo.getPicUrl(), responseInfo.getUrl());
					result = new FormatXmlProcess().formatXmlTextAnswer(
							xmlEntity.getFromUserName(),
							xmlEntity.getToUserName(),
							"服务未开通"
					);
				}
			}
		}
		return result;
	}

}