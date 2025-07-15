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
	<form name="form1" method="post" action="${path }/member/insert.do">
		<table class="table">
			<tr>
				<td class="text-center">아이디</td>
				<td><input name="userid" class="form-control"></td>
			</tr>
			<tr>
				<td class="text-center">비밀번호</td>
				<td><input type="password" name="userpw" class="form-control"></td>
			</tr>
			<tr>
				<td class="text-center">이름</td>
				<td><input name="username" class="form-control"></td>
			</tr>
			<tr>
				<td class="text-center">이메일</td>
				<td><input name="email" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="2"  class="text-center">
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	
	</form>
</div>
</body>
</html>