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
첫번째 수 : ${param.num1}<br>
첫번째 수 : ${param.num2}<br>
합계 : ${param.num1+param.num2}
<hr>
<c:set value = "${param.num1}" var = "no" scope = "request"></c:set>
<!-- var 은 변수지정 scope 는 유효범위 -->
${no }
</body>
</html>