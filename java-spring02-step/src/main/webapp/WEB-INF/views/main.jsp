<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- views/main.jsp -->
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="include/header.jsp" %>	
	</head>
<body>
<%@ include file="include/menu.jsp" %><br>
<c:if test="${message == 'success' }">
	<h2>${sessionScope.username }(${sessionScope.userid })님 환영합니다.</h2>
</c:if>
 ${message }<br>
</body>
</html>