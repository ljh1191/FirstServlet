<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] movieList = { "영화1", "영화2", "영화3", "영화4", "영화5" };
		pageContext.setAttribute("movieList", movieList);
	%>
	<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>title</td>
		</tr>
		<c:forEach items="${movieList }" var="movie" varStatus="status">
			<tr>
				<td>${status.index }</td>
				<td>${status.count }</td>
				<td>${movie }</td>
				<td><c:if test="${status.first ==true }">
			첫번째
			</c:if> <c:if test="${status.last ==true }">
			마지막
			</c:if></td>
				<td><c:if test="${status.index ==0 }">
			첫번째
			</c:if> <c:if test="${status.index ==4 }">
			마지막
			</c:if></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>