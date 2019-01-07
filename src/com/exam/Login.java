package com.exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		req.setAttribute("id", id);
		req.setAttribute("passwd", passwd);
		
		resp.setContentType("text/html;charset=utf-8");
		RequestDispatcher rd = req.getRequestDispatcher("login_Result.jsp");//RequestDispatcher 요청을 보내주는 클래스
		rd.forward(req, resp);
		}
}
