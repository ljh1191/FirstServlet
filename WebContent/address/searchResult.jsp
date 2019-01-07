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
<div id = "area">
	<h2>전체보기</h2> <br>
	<div id = "count">총게시물 수 : ${count}</div>
	<table border="2">
		<tr>
			<th>이름</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
		<tbody id = "result">
		<c:forEach items="${arr }" var="address">
			<tr>
				<td><a href="view.do?num=${address.num }">${address.name }</a></td>
				<td>${address.zipcode }</td>
				<td>${address.addr }</td>
				<td>${address.tell }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>