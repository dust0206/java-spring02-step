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
		$("#btnSave").click(function() {
			var writer=document.form1.writer.value;
			var title=document.form1.title.value;
			var content=document.form1.content.value;
			// var title = $("#title").val();	// 데이터 꺼낼때
			if(title == "") {
				alert("제목을 입력하세요")
				document.form1.title.focus();
				return;
			}
			
			if(content == "") {
				alert("내용을 입력하세요")
				document.form1.content.focus();
				return;
			}
			
			if(writer == "") {
				alert("이름을 입력하세요")
				document.form1.writer.focus();
				return;
			}
			
			// 폼에 입력한 데이터를 서버로 전송함
			document.form1.submit();
		});
	});
</script>
	</head>
<body>
<%@ include file="./include/menu.jsp" %>
<h2>게시물 작성</h2>
	<form name="form1" action="${path }/board/insert.do" method="post">
		
		<div>
			<label>제목</label>
			<input name="title" size="80" placeholder="제목을 입력하세요">
		</div>
		<div>
			<label>내용</label>
			<textarea name="content" rows="3" cols="80"  placeholder="내용을 입력하세요"></textarea>
		</div>
		<div>
			이름
			<input name="writer" size="80"  placeholder="이름을 입력하세요">
		</div>
		<div style="width: 700px; text-align: center">

			<button type="button" id="btnSave">확인</button>
			
		</div>
	</form>
</body>
</html>