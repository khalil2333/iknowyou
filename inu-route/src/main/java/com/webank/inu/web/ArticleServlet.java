package com.webank.inu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class ArticleServlet
 */
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		System.out.println(articleId);
		
		String code = "myCode";
		String msg = "myMsg";
		String picUrl="http://pic.sc.chinaz.com/files/pic/pic9/201508/apic14052.jpg";
		PrintWriter out = response.getWriter();
		JSONObject dataJson=new JSONObject();
		dataJson.put("title", "myTitle");
		dataJson.put("content", "myContent");
		dataJson.put("pic", picUrl);
		JSONObject msgJson=new JSONObject();
		msgJson.put("data", dataJson);
		msgJson.put("code", "myCode");
		msgJson.put("msg", msg);
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
