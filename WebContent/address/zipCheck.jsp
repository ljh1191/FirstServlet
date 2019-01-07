<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#dong").keypress(function(event){
		if(event.which==13){
			$("#send").click();
			return false;
		}
	});
	
	$("#send").click(function(){
		$.post("zip.do",
					{"dong":$("#dong").val()},
					function(data){
// 					alert(data);
					data = $.parseJSON(data);
					var htmlStr = "";
					htmlStr += "<table>";
					for(var i = 0;i<data.length;i++){
						htmlStr += "<tr>"
				 			htmlStr += "<td>" + data[i].zipcode + "</td>"
				 			htmlStr += "<td>" + data[i].sido + "</td>"
				 			htmlStr += "<td>" + data[i].gugun+ "</td>"
				 			htmlStr += "<td>" + data[i].dong + "</td>"
				 			htmlStr += "<td>" + data[i].bunji + "</td>"
				 			htmlStr += "</tr>"
					}
					htmlStr += "</table>";
					$("#result").html(htmlStr);
			}
		);
	});
	$("#result").on("click","tr",function(){
		var address = $("td:eq(1)",this).text()+" "+ 
								$("td:eq(2)",this).text()+" "+ 
								$("td:eq(3)",this).text()+" "+ 
								$("td:eq(4)",this).text()+" ";
		$(opener.document).find("#zipcode").val($("td:eq(0)",this).text()+" ");
		$(opener.document).find("#addr").val(address);
		self.close();						
	});
});
</script>
</head>
<body>
	<table>
		<tr>
			<td>동이름 입력<input type="text" name="dong" id="dong"> <input
				type="button" id="send" value="검색">
			</td>
		</tr>
	</table>
	<div id = "result"></div>
</body>
</html>