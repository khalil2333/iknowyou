package com.webank.inu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.webank.inu.logic.service.history.ChatInfo;
import com.webank.inu.logic.service.history.IHistoryChat;
import com.webank.inu.logic.service.history.impl.BaseHistoryChatImpl;

/**
 * Servlet implementation class HistoryChatServlet
 */
public class HistoryChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(HistoryChatServlet.class);

	private String dataFormat = "yyyy-MM-dd HH:mm:ss";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private String transferLongToDate(String dateFormat,Long millSec){
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date= new Date(millSec);
		return sdf.format(date);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		JSONArray dataArray=new JSONArray();
		IHistoryChat historyChat = new BaseHistoryChatImpl();
		String openId = request.getParameter("openId");
		logger.warn("HistoryChatServlet : =============== "+openId);
        List<ChatInfo> chatInfos = historyChat.queryHistoryChats(openId);

        for (ChatInfo info : chatInfos) {
        	JSONObject dataJson=new JSONObject();
			try {
				dataJson.put("datetime", transferLongToDate(dataFormat,info.getTimestamp()));
				dataJson.put("content", info.getContent());
			} catch (JSONException e) {
				e.printStackTrace();
			}
        	dataArray.put(dataJson);
//            System.out.println(info);
        }
		String code = "myCode";
		String msg = "myMsg";
		JSONObject msgJson=new JSONObject();
		try {
			msgJson.put("code", "myCode");
			msgJson.put("data", dataArray);
			msgJson.put("msg", msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// out.print(value1 + value2);
		String json = msgJson.toString();
		out.print(json);
//		System.out.println(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
