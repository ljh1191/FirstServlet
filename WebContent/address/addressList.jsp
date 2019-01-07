<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function (){
// 	$("#btnSearch").click(function(){
// 		if($("#word").val()==""){
// 			alert("검색어를 입력해주세요.");
// 			return false;
// 		}
// 		search.action = "search.do?field="+$("#field").val()+"&word="+$("#word").val();
// 		search.method = "get";
// 		search.submit();
// 	});
	$("#btnSearch").click(function(){
		if($("#word").val()==""){
			alert("검색어를 입력해주세요.");
			return false;
		}
		$.ajax({
			type : "get",
			url : "search.do",
			data : {"field":$("#field").val(),"word":$("#word").val()},
			success : function(data){
				$("#area").html(data);
		},
		error : function(e){
			alert("error :"+e);
			}
		});
	});
});
</script>
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
	<div>
		<form name = "search" id = "search">
			<select name = "field" id = "field">
				<option value="name">이름</option>
				<option value="tell">전화번호</option>
			</select>
			<input type = "text" name = "word" id = "word">
			<input type = "button" value = "찾기" id = "btnSearch">
		</form>
	</div>
</body>
</html>