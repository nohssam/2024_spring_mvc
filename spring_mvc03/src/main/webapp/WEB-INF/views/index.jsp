<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function geustbook_go() {
		location.href="gb_list.do";
	}
	function geustbook2_go() {
		location.href="gb2_list.do";
	}
</script>
</head>
<body>
	<button onclick="geustbook_go()">guestbook</button>
	<button onclick="geustbook2_go()">guestbook2</button>
</body>
</html>