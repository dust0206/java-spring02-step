<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
	<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	</head>

<body>
<script>
	$(function() {
		alert(1);
	});
</script>
	<div class="container">
		<div class="row">
			<div class="test">
				Test1
			</div>
		</div>
		<div class="row">
			<div class="test">
				Test2
			</div>
		</div>
		
		<dl>
			<dt>test</dt>
			<dd>
				<ul>
					<li>시흥시의회</li>
					<li>통합예약</li>
					<li>문화관광</li>
					<li>평생학습</li>
					<li>
						<div>
							<dl>
								<dt>더보기</dt>
								<dd>
									<ul>
										<li>일자리경제</li>
										<li>시흥아트센터</li>
										<li>아동친화도시</li>
										<li>시흥청년정책</li>
										<li>세계속의시화호</li>
									</ul>
								</dd>
							</dl>
						</div>
						
					</li>
				</ul>
			</dd>
		</dl>
	</div>
</body>
</html>