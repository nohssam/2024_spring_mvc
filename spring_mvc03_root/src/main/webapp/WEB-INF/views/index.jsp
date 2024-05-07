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
	function bbs_go() {
		location.href="bbs_list.do";
	}
	function board_go() {
		location.href="board_list.do";
	}
	function shop_go() {
		location.href="shop_list.do";
	}
	function spring_ajax_go() {
		location.href="spring_ajax_go.do";
	}
	function spring_ajax_go2() {
		location.href="spring_ajax_go2.do";
	}
	function spring_sns_go() {
		location.href="spring_sns_go.do";
	}
	function dynamic_query() {
		location.href="dynamic_query.do";
	}
	function emil_send() {
		location.href="email_send.do";
	}
	function data_go() {
		location.href="data_go.do";
	}
	function data_go2() {
		location.href="data_go2.do";
	}
	function data_go3() {
		location.href="data_go3.do";
	}
	function transaction_go() {
		location.href="transaction_go.do";
	}
	function chattingPage_go() {
		location.href="chattingPage.do";
	}
	function chattingPage_go2() {
		location.href="chat2.do";
	}
	function chattingPage_go3() {
		location.href="chat3.do";
	}
</script>
</head>
<body>
	<button onclick="geustbook_go()">guestbook</button>
	<button onclick="geustbook2_go()">guestbook2</button>
	<button onclick="bbs_go()">게시판</button>
	<button onclick="board_go()">게시판2</button>
	<button onclick="shop_go()">shop</button>
	<button onclick="spring_ajax_go()">Spring Ajax</button>
	<button onclick="spring_ajax_go2()">Spring Ajax2</button>
	<button onclick="spring_sns_go()">Spring sns </button>
	<button onclick="dynamic_query()">동적Query</button>
	<button onclick="emil_send()">이메일 보내기</button>
	<button onclick="data_go()">공공데이터 미세먼지(xml)</button>
	<button onclick="data_go2()">공공데이터 미세먼지(json)</button>
	<button onclick="data_go3()">(json(오류발생))</button>
	<button onclick="transaction_go()">트랜잭션</button>
	<button onclick="chattingPage_go()">채팅(js_오류)</button>
	<button onclick="chattingPage_go2()">채팅2(mvc)</button>
	<button onclick="chattingPage_go3()">채팅3(mvc)</button>
</body>
</html>






