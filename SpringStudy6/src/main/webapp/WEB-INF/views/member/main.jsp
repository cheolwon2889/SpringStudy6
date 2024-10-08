<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member/main.jsp</h1>
	
	<!-- 사용자 ID님 환영합니다. 메세지 출력 -->
	<%-- <c:if test="${sessionScope.id == null}"> --%>
	<c:if test="${ empty sessionScope.id }">
		<!-- 로그인정보가 없을때 로그인페이지 이동 -->
		<c:redirect url="/member/login" />
	</c:if>
	
	<h2>${sessionScope.id} 님 환영합니다.</h2>
	
	<input type="button" value="로그아웃" onclick="location.href='/member/logout';" />
	
	<hr>
	<h2><a href="/member/info">회원정보 조회(info)</a></h2>
	<h2><a href="/member/update">회원정보 수정(update)</a></h2>
	<h2><a href="/member/delete">회원정보 삭제(delete)</a></h2>
	<!-- 관리자 기능 (사용자 admin일때 사용가능) -->
	<c:if test="${!empty id && id.equals('admin')}">
		<h2><a href="/member/list">회원정보 목록(list)</a></h2>
	</c:if>
	
	

</body>
</html>