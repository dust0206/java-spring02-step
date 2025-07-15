<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>	
	</head>
<body>
<%@ include file="../include/menu.jsp" %><br>
<div class="container">
<div>
	<h2>회원 등록폼</h2>
</div>
	<div >
		<input type="button" value="회원등록" onclick="location.href='${path}/member/insertForm.do'">
	</div>
	<table class="table text-center" border="1" >
		<tr >
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일자</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.userid }</td>
				<td>
					<a href="${path}/member/view.do?userid=${vo.userid } ">${vo.username }</a>
				</td>
				<td>${vo.email }</td>
				<td>${vo.regdate }</td>
			</tr>
		</c:forEach>
	
	</table>
</div>
</body>
</html>