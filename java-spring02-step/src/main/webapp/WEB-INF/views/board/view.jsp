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
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겟읍니까?")) {
				document.form1.action="${path}/board/delete.do";
				document.form1.submit();
				
			}
		});
		
		
		$("#btnUpdate").click(function() {
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
			
			// 수정 주소
			document.form1.action = "${path}/board/update.do";
			// 폼에 입력한 데이터를 서버로 전송함
			document.form1.submit();
		});
	});
</script>
	</head>
<body>
<%@ include file="./include/menu.jsp" %>
<h2>게시물 보기</h2>
	<form name="form1"  method="post">
		<div>
			작성일자 : <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd a HH:mm:ss"/> 
<!-- 			날짜형식 yyyy 4자리 연도, MM 월, dd 일, a 오전/오후 -->
<!-- 				HH 24시간제, hh 12시간제, mm 분, ss초  -->
		</div>
		<div>
			조회수 : ${vo.viewcnt }
		</div>
		<div>
			<label>제목</label>
			<input name="title" size="80" value="${vo.title }" placeholder="제목을 입력하세요">
		</div>
		<div>
			<label>내용</label>
			<textarea name="content" rows="3" cols="80"  placeholder="내용을 입력하세요">${vo.content }</textarea>
		</div>
		<div>
			이름
			<input name="writer" size="80" value="${vo.writer }" placeholder="이름을 입력하세요">
		</div>
		<div style="width: 700px; text-align: center">
			<!-- 			게시물 번호를 hidden으로 처리 -->
			<input type="hidden" name="bno" value="${vo.bno }">
			<button type="button" id="btnUpdate">수정</button>
			<button type="button" id="btnDelete">삭제</button>
		</div>
	</form>
</body>
</html>