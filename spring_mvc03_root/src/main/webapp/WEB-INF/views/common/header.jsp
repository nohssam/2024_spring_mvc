<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="currentLimit" value="${ requestScope.limit }" />
<c:set var="nowpage" value="1" />
<c:if test="${ !empty requestScope.currentPage }">
    <c:set var="nowpage" value="${ requestScope.currentPage }" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/header.css" rel="stylesheet">
<script src="/noramore/resources/js/jquery-3.7.0.min.js"></script>
<title>noramore</title>
</head>
<body>
    <header id="header" style="height: 90px">
        <c:if test="${ empty sessionScope.loginMember }">
            <div class="header-left">
                <a href="index.jsp">noramore</a>
            </div>


            <div class="header-right">
                <nav>
                    <ul>
                    <li><button class="blueBtn" onclick="openSetting()">챗봇실행</button>
                                
                                <section id="chatbot">
                                <div id="setting" style="display: none;">
                                    <div class="chatbot-container">
                                        <div id="chatbot">
                                            <div id="conversation">
                                                <div class="chatbot-message">
                                                    <p class="chatbot-text">노라모아에 오신것을 환영합니다 !<br><br>원하시는 질문을 말씀하세요</p>
                                                </div>
                                            </div>
                                            <form id="input-form">
                                                <message-container> 
                                                <input id="input-field" type="text"
                                                    placeholder="Type your message here">

                                                <button type="submit">제출</button>
                                                </message-container>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                </section>
                            </li>
                        <li><a href="moveLoginPage.do">로그인</a></li>
                        <li><a href="enrollPage.do">회원가입</a></li>
                    </ul>
                </nav>
            </div>
        </c:if>
        <c:if
            test="${ !empty sessionScope.loginMember && loginMember.adminYN eq 'N'}">
            <div class="header-left">
                <a href="index.jsp">noramore</a>
            </div>
            <div class="header-right">
                <nav>
                    <ul>
                     <li><button class="blueBtn" onclick="openSetting()">챗봇실행</button>
                                
                                <section id="chatbot">
                                <div id="setting" style="display: none;">
                                    <div class="chatbot-container">
                                        <div id="chatbot">
                                            <div id="conversation">
                                                <div class="chatbot-message">
                                                    <p class="chatbot-text">노라모아에 오신것을 환영합니다 !<br><br>원하시는 질문을 말씀하세요</p>
                                                </div>
                                            </div>
                                            <form id="input-form">
                                                <message-container> 
                                                <input id="input-field" type="text"
                                                    placeholder="Type your message here">

                                                <button type="submit">제출</button>
                                                </message-container>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                </section>
                            </li>
                            
                        <li><a href="chattingPage.do">채팅</a></li>
                        <c:if test="${ !empty chatOn }">
                        <li><a href="${ pageContext.servletContext.contextPath }/enterChat.do">요청(1)</a> </li>
                        </c:if>
                        <li><a href="receiveHome.jsp">문의내역</a></li>
                        
                         <li>
                     <a href="selectRecrBoadMemberId.do">마이페이지</a>
                     <c:if test="${ !(sessionScope.alarmCount > 0) }">
                        <a href="alarmlist.do" ><img src="resources/images/alarmIcon.png" style="height:29px;width:auto;"></a>
                     </c:if>
                     <c:if test="${ sessionScope.alarmCount > 0 }">
                        <a href="alarmlist.do" style="align-items: center;"><img src="resources/images/alarmExist.png"style="height:29px;width:auto;align-items:center;"> </a>
                     </c:if>
                  </li>
                        <li><a href="logout.do">로그아웃</a></li>



                    </ul>
                </nav>
            </div>
        </c:if>
        
        <c:if

            test="${ !empty sessionScope.loginMember && loginMember.adminYN eq 'Y'}">
            <div class="header-left">
                <a href="index.jsp">noramore</a>
            </div>
            <div class="header-right">
                <nav>
                    <ul>
                        <li><button class="blueBtn" onclick="openSetting()">챗봇실행</button>
                                
                                <section id="chatbot">
                                <div id="setting" style="display: none;">
                                    <div class="chatbot-container">
                                        <div id="chatbot">
                                            <div id="conversation">
                                                <div class="chatbot-message">
                                                    <p class="chatbot-text">노라모아에 오신것을 환영합니다 !<br><br>원하시는 질문을 말씀하세요</p>
                                                </div>
                                            </div>
                                            <form id="input-form">
                                                <message-container> 
                                                <input id="input-field" type="text"
                                                    placeholder="Type your message here">

                                                <button type="submit">제출</button>
                                                </message-container>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                </section>
                            </li>
                    
                        <li><a href="chattingPage.do">채팅</a></li>
                      	<c:if test="${ !empty chatOn }">
                        <li><a href="${ pageContext.servletContext.contextPath }/enterChat.do">요청(1)</a> </li>
                        </c:if>
                        <li><a href="qlist.do">문의내역</a></li>
                       
                        <li><a href="adminPage.do">관리자페이지</a></li>
                        <li><a href="logout.do">로그아웃</a></li>
                                    </ul>
                </nav>
            </div>
        </c:if>
    </header>

    <script type="text/javascript">
        function openSetting() {
            const setting = document.getElementById('setting');
            setting.style.display = (setting.style.display === 'block') ? 'none' : 'block';
        }
    </script>

    <script src="resources/js/chatbot.js"></script>

</body>
</html>
