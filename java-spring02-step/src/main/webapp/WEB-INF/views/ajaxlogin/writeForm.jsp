<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<title>회원가입 폼</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
<script>
	$(function() {
		// 이벤트 처리
		// id check
		$("#id").keyup(function() {
			let id=$("#id").val();
			// data 확인하기
			console.log("id : " + id);
			// 3자 미안인경우 처리
			if(id.length < 3) {
				// class 지정 - 디자인
				$("#checkIdDIV").removeClass("alert-success alert-danger").addClass("alert-danger");
			} else {
				// 서버에 가서 데이터를 확인하고 온다. - 결과를 JSP로 받는다
				// $("#checkIdDIV") 안에 넣을 문구를 가져와서 넣는다
// 				$("#checkIdDIV").load("checkid.do");
				$("#checkIdDIV").load("ajaxcheckid.do");
				$("#checkIdDIV").removeClass("alert-success alert-danger").addClass("alert-success");
			}
		});
	});
</script>
	</head>
<body>
	
<div class="container">
	<h2>회원 가입폼</h2>
	<form action="write.do" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="id">아이디 : </label>
			<input name="id" id="id" class="form-control" required="required" maxlength="20" title="맨앞 글자는 영문자 뒤에는 영숫자 입력 20글자" 
				pattern="^[a-zA-Z][a-zA-Z0-9].{2,19}" placeholder="아이디 입력">
			
		</div>
		<div id="checkIdDIV" class="alert alert-danger" >
			아이디는 필수 입력입니다. 3글자 이상입니다.
		</div>
	</form>
<!-- https://www.youtube.com/watch?v=vfk0MO3caII&list=PLE5Oosh5zKQeFNgqic1rNGosrrGAYUSUM&index=69 -->
</div>	
</body>
</html>