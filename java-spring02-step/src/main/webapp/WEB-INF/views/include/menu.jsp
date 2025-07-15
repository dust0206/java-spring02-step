<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  컨텍스트 경로 -->
<c:set var="path" value="${pageContext.request.contextPath }" />
<div style="text-align: center; ">
	<a href="${path }/member/list.do"><button>회원관리</button></a>
</div>


<!-- views/include/msnu.jsp -->