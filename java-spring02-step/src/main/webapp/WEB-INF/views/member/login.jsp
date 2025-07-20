<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>		
<script>
	$().ready(function() {
		$("#btnLogin").click(function() {
			// 태그.val() : 태그에 입력된 값
			// 태그.val("값") : 태그의 값을 변경
			var userid = $("#userid").val();
			var userpw = $("#userpw").val();
			if(userid == "") {
				alert("아이디를 입력하세요");
				$("#userid").focus();
				return;
			}
			if(userpw == "") {
				alert("패스워드를 입력하세요");
				$("#userpw").focus();
				return;
			}
			
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action="${path}/member/login_check.do"
			document.form1.submit();
		});
	});

</script>
	</head>
<body>
<%@ include file="../include/menu.jsp" %><br>
<div class="container">
<h2>로그인</h2>
	<form name="form1" method="post" >
		<table border="1" style="width:400px;">
			<tr>
				<th>아이디</th>
				<td><input id="userid" name="userid"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="userpw" name="userpw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button>
					<c:if test="${message eq 'error' }">  <!-- == 또는 eq도 됨 -->
						<div style="color:red;">
							아이디 또는 비밀번호가 일치 하지 않습니다.
						</div>
					</c:if>
					<c:if test="${message eq 'logout' }">  <!-- == 또는 eq도 됨 -->
						<div style="color:red;">
							로그아웃 되었읍니다.
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>

</div>
</body>
	
</html>
