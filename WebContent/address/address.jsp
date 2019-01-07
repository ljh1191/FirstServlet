<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function zipfinder(){
	window.open("zip.do","","width = 700 height = 400");
}
</script>
</head>
<body>
	<a href = "list.do">전체보기</a><br> 
	주소록 등록하기
	<form action = "insert.do" method = "post" name = "frm">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name"></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" id="zipcode" name="zipcode"><input type = "button" value = "검색" onclick = "zipfinder()"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" id="addr" name="addr"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" id="tell" name="tell"></td>
			</tr>
			<tr>
				<td colspan = 2><input type = "submit" value = "등록"><input type = "reset" value = "취소"></td>
			</tr>
		</table>
	</form>



</body>
</html>