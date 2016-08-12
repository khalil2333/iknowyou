package com.webank.inu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webank.inu.logic.service.message.IMessageService;
import com.webank.inu.logic.service.message.SingleArticleInfo;
import com.webank.inu.logic.service.message.impl.BaseMessageServiceImpl;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IMessageService messageService = new BaseMessageServiceImpl();

	private Logger logger = Logger.getLogger(ArticleServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String articleId=request.getParameter("articleId");
		logger.warn("articleId ; "+articleId);

		SingleArticleInfo articleInfo = messageService.queryArticleById(Integer.parseInt(articleId));
		logger.warn("articleInfo : "+articleInfo);
		String code = "myCode";
		String msg = "myMsg";
		String picUrl="http://pic.sc.chinaz.com/files/pic/pic9/201508/apic14052.jpg";
		PrintWriter out = response.getWriter();
		JSONObject dataJson=new JSONObject();
		JSONObject msgJson=new JSONObject();
		try {
			dataJson.put("title", articleInfo.getTitle());
			dataJson.put("content", articleInfo.getContent());
			dataJson.put("pic", articleInfo.getPicUrl());

			msgJson.put("data", dataJson);
			msgJson.put("code", "myCode");
			msgJson.put("msg", msg);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		// out.print(value1 + value2);
		String json = msgJson.toString();
		out.print(json);
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
