<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  컨텍스트 경로 -->
<c:set var="path" value="${pageContext.request.contextPath }" />
<div style="text-align: center; ">
	<a href="${path }/board/list.do"><button>게시판</button></a>
	<a href="${path }/member/list.do"><button>회원관리</button></a>
	<c:choose>
		<c:when test="${sessionScope.userid == null }">
			<a href="${path }/member/login.do"><button>로그인</button></a>
		</c:when>
		<c:otherwise>
			${sessionScope.username }님 로그인중입니다.
			<a href="${path }/member/logout.do"><button>로그아웃</button></a>
		</c:otherwise>
	</c:choose>
</div>


<!-- views/include/msnu.jsp -->