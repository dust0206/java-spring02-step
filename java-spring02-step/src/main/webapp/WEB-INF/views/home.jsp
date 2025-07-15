<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<title>Insert title here</title>
<%
	String path=request.getContextPath();
%>
<script>
	function doF() {
		$.ajax({
			type: "post",
// 			contentType: "application/json",
			url: "<%=path %>/part1_ch05/doF",
			success: function(result) {
				console.log(result);
				
// 				$("#result").html(result);
				$("#result").text(
						"상품명:" + result.name + 
						", 가격 : " + result.price
				);
			}
		});
	}
</script>
	</head>
<body>
	<a href="<%=path %>/part1_ch05/doA">doA</a><br>
	<a href="<%=path %>/part1_ch05/doB">doB</a><br>
	<a href="<%=path %>/part1_ch05/doC">doC</a><br>
	<a href="<%=path %>/part1_ch05/doD">doD</a><br>
	<a href="javascript:doF() ">doF</a>
	<div id="result"></div>
</body>
</html>