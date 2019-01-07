package com.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jstltest extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String id = req.getParameter("id");
	String color = req.getParameter("color");
	
	req.setAttribute("id", id);
	req.setAttribute("color", color);
	
	resp.setContentType("text/html;charset=utf-8");
	RequestDispatcher rd = req.getRequestDispatcher("jstlTest02_Result.jsp");
	rd.forward(req, resp);
}
}
