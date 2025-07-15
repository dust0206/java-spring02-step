<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>	
<script>
	$(document).ready(function() {
		//  수정 버튼 클릭
		$("#btnUpdate").click(function() {
			document.form1.action="${path}/member/update.do";
			document.form1.submit();
		});
		
		// 삭제 버튼 클릭
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠읍니까?")) {
				document.form1.action = "${path}/member/delete.do";
				document.form1.submit();
			}
		});
	});
</script>
	</head>
<body>
<%@ include file="../include/menu.jsp" %><br>
<div class="container">
<div>
	<h2>회원 정보보기</h2>
</div>
	<form name="form1" method="post">
	
		<table class="table">
			<tr>
				<td class="text-center">아이디</td>
				<td><input name="userid" class="form-control" value="${dto.userid }" readonly></td>
			</tr>
			<tr>
				<td class="text-center">비밀번호</td>
				<td><input name="userpw" class="form-control" ></td>
			</tr>
			<tr>
				<td class="text-center">이름</td>
				<td><input name="username" class="form-control" value="${dto.username }"></td>
			</tr>
			<tr>
				<td class="text-center">이메일</td>
				<td><input name="email" class="form-control" value="${dto.email }"></td>
			</tr>
			<tr>
				<td class="text-center">회원가입일자</td>
				<td><fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd HH:mm:ss "/> </td>
			</tr>
			<tr>
				<td class="text-center">회원정보수정일자</td>
				<td><fmt:formatDate value="${dto.updatedate }" pattern="yyyy-MM-dd HH:mm:ss"/>  </td>
			</tr>
			<tr>
				<td colspan="2"  class="text-center">
					<input type="button" value="수정" id="btnUpdate" class="btn btn-outline-dark">
					<input type="button" value="삭제" id="btnDelete" class="btn btn-outline-dark">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>