<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>받은 인증번호를 넣어주세요 </h2>
	<form action="email_send_ok.do" method="post">
		<input type="number" name="authNumber" min="6" max="6">
		<input type="submit" value="전송">
	</form>
</body>
</html>