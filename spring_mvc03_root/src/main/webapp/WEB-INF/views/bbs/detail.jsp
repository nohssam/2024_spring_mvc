<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
</style>
<script type="text/javascript">
	function bbs_list(f) {
		f.action="bbs_list.do";
		f.submit();
	}
	function bbs_delete(f) {
		f.action="bbs_delete.do";
		f.submit();
	}
	function bbs_update(f) {
		f.action="bbs_update.do";
		f.submit();
	}
	function comment_insert(f){
		f.action="comment_insert.do";
		f.submit();
	}
	function comment_delete(f) {
		f.action="comment_delete.do";
		f.submit();
	}
</script>
</head>
<body>
	<div id="bbs">
	<form method="post" >
		<table>
			<caption>게시판 상세보기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td>${bvo.subject }</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td>${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><pre>${bvo.content }</pre></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<c:choose>
						<c:when test="${empty bvo.f_name}">
							<td><b>첨부파일없음</b></td>
						</c:when>
						<c:otherwise>
							<td><a href="bbs_down.do?f_name=${bvo.f_name}"><img src="resources/upload/${bvo.f_name}" style="width: 80px"> </a></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td colspan="2">
					    <input type="hidden" name="b_idx" value="${bvo.b_idx }">
					    <input type="hidden" name="cPage" value="${cPage}">
						<input type="button" value="수정" onclick="bbs_update(this.form)"/>
						<input type="button" value="삭제" onclick="bbs_delete(this.form)"/>
						<input type="button" value="목록" onclick="bbs_list(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<%-- 댓글 입력 --%>
	<div style="padding: 10px; width: 580px; margin: 0 auto">
		<form method="post">
			<fieldset>
				<p>이름 : <input style="padding: 5px" type="text" name="writer"></p>
				<p>내용 : <textarea rows="3" cols="40" name="content"></textarea>
				<input style="float: right;" type="button" value="댓글저장" onclick="comment_insert(this.form)">
				</p>
				<!-- 댓글 저장시 어떤 원글의 댓글인지 저장해야 한다. -->
				<input type="hidden" name = "b_idx" value="${bvo.b_idx}" >
			</fieldset>
		</form>
	</div>
	
	<%-- 댓글 출력 --%>
	<div style="display: table; margin: 0 auto;">
		<c:forEach var="k" items="${comm_list }">
			<div style="border: 1px solid #cc00cc; width: 580px; margin: 5px; padding: 5px;" >
				<form method="post">
					<p>이름 : ${k.writer}</p>
					<p>내용 : <pre>${k.content}</pre></p>
					<p>날짜 : ${k.write_date.substring(0,10)}
					<!-- 실제은 로그인 성공 && 글쓴 사람만 삭제할 수 있어야 한다. -->
					<input style="float: right;" type="button" value="댓글삭제" onclick="comment_delete(this.form)">
					<input type="hidden" name = "c_idx" value="${k.c_idx}" >
					<input type="hidden" name = "b_idx" value="${k.b_idx}" >
					</p>
				</form>
			</div>
		</c:forEach>
	</div>	
	
</body>
</html>












