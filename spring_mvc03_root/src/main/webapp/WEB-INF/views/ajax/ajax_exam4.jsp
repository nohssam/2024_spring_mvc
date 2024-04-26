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
		url : "dustdata2.do",
		method : "post",
		dataType : "json",
		success : function(data) {
			console.log(data.response.body.items);
			let tbody = "";
			const items =  data.response.body.items;
			$.each(items, function(index, obj) {	
	    		let stationName = obj.stationName;
	    		let pm25Value = obj.pm25Value;
	    		let pm10Value = obj.pm10Value;
	    		let o3Grade = obj.o3Grade;
	    		let no2Grade = obj.no2Grade;
	    		let coGrade = obj.coGrade;
	    		
	    		tbody += "<tr>";
	    		tbody += "<td>" + stationName + "</td>";
	    		tbody += "<td>" + pm25Value + "</td>";
	    		tbody += "<td>" + pm10Value + "</td>";
	    		tbody += "<td>" + o3Grade + "</td>";
	    		tbody += "<td>" + no2Grade + "</td>";
	    		tbody += "<td>" + coGrade + "</td>";
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





