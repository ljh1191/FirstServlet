<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<script>
function deletebtn(){
	if(confirm("정말삭제하시겠어요?")){
		location.href = "delete.do?num=${dto.num}";
	}
	return ;
}
</script>
</head>
<body>
<h2>상세보기</h2>
<form action="update.do" method = "post" name = "frm">
	<table border = "2">
		<tr>
			<th>번호</th>
			<td><input type = "text" name = "num" value = "${dto.num}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type = "text" name = "name" value = "${dto.name}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type = "text" name = "addr" value = "${dto.addr}"></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<td><input type = "text" name = "zipcode" value = "${dto.zipcode}"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type = "text" name = "tell" value = "${dto.tell}"></td>
		</tr>
		<tr>
			<th colspan = 2><input type = "submit" value = "수정"><input type = "button" value = "삭제" onclick = "deletebtn()"></th>
		</tr>
	</table>
	</form>
</body>
</html>