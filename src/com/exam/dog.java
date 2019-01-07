package com.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dog extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.setCharacterEncoding("utf-8");
	String[] dog = req.getParameterValues("dog");
	
	req.setAttribute("dog", dog);
	
	resp.setContentType("text/html;charset=utf-8");
	RequestDispatcher rd = req.getRequestDispatcher("dog_Result.jsp");
	rd.forward(req, resp);
}
}
