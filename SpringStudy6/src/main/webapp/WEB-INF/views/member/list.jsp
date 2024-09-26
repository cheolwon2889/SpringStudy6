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
	<h1>/views/member/list.jsp</h1>
	
	${memberList} <hr>
	<!-- ${sessionScope}  -->
	
	<c:forEach var="list" items="${memberList}">
		${list.userid} <br>
		${list.userpw} <br>
		${list.username} <br>
		${list.useremail} <br>
		${list.regdate} <br>
		<hr>
	</c:forEach>
	
</body>
</html>