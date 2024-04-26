<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	span { width: 150px; color: red;}
	input{border:1px solid red;}
	table{width: 80%; margin: 0 auto;}
	table,th,td {border: 1px solid gray; text-align: center;}
	h2{text-align: center;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#result").empty();
	$.ajax({
		url : "dustdata.do",
		method : "post",
		dataType : "xml",
		success : function(data) {
			let tbody = "";
			$(data).find("item").each(function() {
				tbody += "<tr>";
				tbody += "<td>"+$(this).find("stationName").text()+"</td>";
				tbody += "<td>"+$(this).find("pm25Value").text()+"</td>";
				tbody += "<td>"+$(this).find("pm10Value").text()+"</td>";
				tbody += "<td>"+$(this).find("o3Grade").text()+"</td>";
				tbody += "<td>"+$(this).find("no2Grade").text()+"</td>";
				tbody += "<td>"+$(this).find("coGrade").text()+"</td>";
				tbody += "</tr>";
			});
			$("#tbody").append(tbody);
		},
		error : function() {
			alert("읽기 실패")
		}
	});
});
</script>
</head>
<body>
	<h2>서울 미세먼지 현황</h2>
	<table>
		<thead>
			<tr>
				<td>지역</td><td>초미세먼지</td><td>미세먼지</td><td>오존</td><td>이산화질소</td><td>일산화탄소</td>
			</tr>
		</thead>
		<tbody id="tbody"></tbody>
	</table>
</body>
</html>





