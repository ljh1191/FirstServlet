<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${name} <br>
이름 : <c:out value="${name}"/> <br>
아이디 : ${id} <br>
패스워드 : ${password} <br>
성별 : ${gender} <br>
메일 수신 여부 :
<c:forEach items = "${notice}" var = "i">
	${i}
</c:forEach><br>
직업 : ${job} <br>
</body>
</html>