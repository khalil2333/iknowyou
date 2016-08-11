package com.webank.inu.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by adam on 2016/8/10.
 */
public class TestServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doWork(req,resp);
    }

    protected void doWork(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String echoStr = req.getParameter("echostr");
        if (echoStr == null || echoStr.trim().equals("")) return;
        System.out.println("echostr : "+echoStr);
        PrintWriter out = resp.getWriter();
        out.println(echoStr);
        out.flush();
    }
}
