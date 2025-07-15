<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="./include/header.jsp" %>
<script>
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href="${path}/board/write.do";
		});
	});
</script>
	</head>
<body>
<%@ include file="./include/menu.jsp" %>
<h2>게시판</h2>
<form name="form1" method="post">
	
</form>
<button type="button" id="btnWrite">글쓰기</button>
	<table border="1" style="width:800px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.bno }</td>
			<td><a href="${path }/board/view.do?bno=${vo.bno }">${vo.title }</a></td>
			<td>${vo.writer }</td>
<!-- 			value="날짜" pattern="출력형식" -->
			<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH-mm-ss"/>   </td>
			<td>${vo.viewcnt }</td>
		</tr>
		</c:forEach>
	
	</table>
</body>
</html>