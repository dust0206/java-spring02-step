<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>

<!--  구글 차트 호출을 위한 js -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	// 구글 차트 라이브러리 로딩
// 	google.load('visualization', '1', {
// 		'packages' : ['corechart']
// 	} );
	google.charts.load('current',{'packages' : ['line', 'corechart']});
	
// 	특정버전 51 아래로 
// 	google.charts.load(51,{'packages' : ['corechart']});
	
	// 로딩이 완료되면 drawChart 함수 호출
	google.setOnLoadCallback(drawChart);
// 	google.charts.setOnLoadCallback(drawChart);
	
	// drawChart 관련 
	function drawChart() {
		var jsonData = $.ajax({
// 			url : "${path}/json/sampleData.json",
			url : "/java-spring02-step/json/sampleData.json",
			dataType : "json",
			async : false,
		}); 
// 		}).responseText; 
		console.log(jsonData);
		// 구글의 데이터 테이블 형식으로 변경
// 		var data = new google.visualization.DataTable(jsonData);
		var data = new google.visualization.DataTable(jsonData);
		// 차트를 출력할 div
		// LineChart, ColumnChart, PieChart
// 		var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
		var chart = new google.visualization.ColumnChart(document.getElementById("chart_div"));
		
		chart.draw(data, {
				title:"차트예제",
				curveType:"functon",
				width:600,
				height:400
		});
		
		
	}
</script>
	</head>
<body>
	<h2>google1 chart</h2>
	<%@ include file="../include/admin_menu.jsp" %>
	<!--  차트 출력 영역 -->
	<div id="chart_div"></div>
	<!--  차트 새로고침 버튼 -->
	<button id="btn" type="button" onclick="drawChart()">새로고침</button>
	
</body>
</html>