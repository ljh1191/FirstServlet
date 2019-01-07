<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int num1 =Integer.parseInt(request.getParameter("num1"));
int num2 =Integer.parseInt(request.getParameter("num2"));
int hap = num1+num2;
out.println("합 : "+hap);
%>