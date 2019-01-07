package com.exam;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exam/ServletCycle")
public class ServletCycle extends HttpServlet{
	public ServletCycle() {
		System.out.println("������");
	}
	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("init");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		String param=req.getParameter("test")==null?"guest":req.getParameter("test");
		System.out.println(param);
		System.out.println("--------------");
		resp.sendRedirect("test.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
		//
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
		super.service(req, resp);
	}
	
}
