<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- <c:import url="/WEB-INF/views/common/header.jsp" /> --%>
<c:set var="currentLimit" value="${ requestScope.limit }" />
<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
	<c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>


<!DOCTYPE html >
<html>
<head>

<script type="text/javascript">
	function openSetting() {
		if (document.getElementById('setting').style.display === 'block') {
			document.getElementById('setting').style.display = 'none';
		} else {
			document.getElementById('setting').style.display = 'block';
		}
	}
</script>


<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="resources/css/style.css"> -->
<link rel="stylesheet" href="resources/css/chatbot.css">
<!-- <script type="text/javascript" src="resources/js/jquery-3.7.0.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>

<body>
	<section id="board">
		<h1>게시물 추천</h1>
		<div class="line"></div>


		<div class="top"></div>
			<h3>ASP 모바일 상담 서비스</h3>
			<button onclick="openSetting()">
				<img src="./img/setting.png">
			</button>
			<div id="setting">
				<div class="chatbot-container">
					<div id="chatbot">
						<div id="conversation">
							<div class="chatbot-message">	
								<p class="chatbot-text">노라모아에 오신것을 환영합니다23 !<br><br>원하시는 질문을 말씀하세요</p>
							</div>
						</div>
						<form id="input-form">
							<message-container> <input id="input-field"
								type="text" placeholder="Type your message here">

							<button id="blueBtn" type="submit">제출</button>
							</message-container>
						</form>
					</div>
				</div>
			</div>		


				<script type="text/javascript">
					// Add event listener to input form
					inputForm
							.addEventListener(
									'submit',
									function(event) {
										// Prevent form submission
										event.preventDefault();

										// Get user input
										const input = inputField.value;

										// Get checked checkbox values
										const checkedItems = [];
										const checkboxA = document
												.getElementById('checkboxA');
										const checkboxB = document
												.getElementById('checkboxB');
										if (checkboxA.checked) {
											checkedItems.push(checkboxA.value);
										}
										if (checkboxB.checked) {
											checkedItems.push(checkboxB.value);
										}

										// Clear input field
										inputField.value = '';
										const currentTime = new Date()
												.toLocaleTimeString([], {
													hour : '2-digit',
													minute : "2-digit"
												});

										// Add user input to conversation
										let message = document
												.createElement('div');
										message.classList.add(
												'chatbot-message',
												'user-message');
										message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${input}</p>`;
										conversation.appendChild(message);

										// Generate chatbot response
										const response = generateResponse(
												input, checkedItems);

										// Add chatbot response to conversation
										message = document.createElement('div');
										message.classList.add(
												'chatbot-message', 'chatbot');
										message.innerHTML = `<p class="chatbot-text" sentTime="${currentTime}">${response}</p>`;
										conversation.appendChild(message);
										message.scrollIntoView({
											behavior : "smooth"
										});
									});
				</script>

			</div>
			
	</section>

	<script src="resources/js/chatbot.js"></script>
</body>
</html>