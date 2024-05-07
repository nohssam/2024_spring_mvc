<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	let websock;
	$(function(){
		$('#message').keypress(function(event){
			let keycode = event.Code ? event.keyCode : event.which;
			if(keycode == 13){
				send_go();
			}
			event.stopPropagation();
		});
		$("#enterBtn").click(function(){
			connect();	
		});
		$("#exitBtn").click(function(){
			disconnect();	
		});
		$("#sendBtn").click(function(){
			send_go();	
		});
	});
	function send_go(){
		let nickName = $("#nickName").val();
		let msg = $("#message").val();
		websock.send("msg:"+nickName + ":" + msg);
		$("#message").val("");
	}	
	function connect() {
		websock = new WebSocket("ws://localhost:8090/chat-ws.do");
		websock.onopen = onOpen;
		websock.onmessage = onMessage;
	}
	function disconnect() {
		websock.close();
	}
	function onOpen(event) {
		appendMessage("연결되었습니다.")
	}
	function onClose(event) {
		appendMessage("연결이 종료되었습니다.")
	}
	function onMessage(event){
		let data = event.data;
		appendMessage(data);
	}
	function appendMessage(msg){
		$("#chatMessageArea").append(msg  + "<br>");
		let chatAreaheight =$("#chatArea").height();
		let maxscroll = $("chatMessageArea").height()- chatAreaheight;
		$("#chatArea").scrollTop(maxscroll);
	}
</script>
</head>
<body>
	<div>
		 별명 : <input type="text" id="nickName">
		 <input type="button" value="입장" id="enterBtn">
		 <input type="button" value="퇴장" id="exitBtn">
		 <hr>
		 <h2> 대화영역 </h2>
		 <input type="text" id="message" required="required">
		 <input type ="button" value="전송" id="sendBtn">
		 <div id="chatArea">
		 	<div id="chatMessageArea"></div>
		 </div>
	</div>
</body>
</html>