<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>itwill.jsp</h1>
	<!-- jsp 내장객체를 사용 -->
	<h2> 파라메터 데이터 (parameter) </h2>
	<h2> msg (parmater) : <%=request.getParameter("msg") %> </h2>

	<!-- 주소줄에서 가져오는 것 -->
	<h2> msg (el 표현식) : ${param.msg} </h2>
	
	
	<hr>
	<h2> 영역객체 데이터 (attribute) </h2>
	<!-- 영역에서 가져오는 것(attribute) -->
	<h2> msg (el 표현식) : ${msg} </h2>
	<!-- 영역에서 가져오는 것(attribute) -->
	<h2> msg (el 표현식) : ${requestScope.msg} </h2>
	
	@ModelAttribute("msg") String msg
	=> request.getParameter("msg") + request.setAttribute("msg" , 값) 이 두가지 기능을 같이 하더라.
	
	
	
	<h2> id (el 표현식) : ${id} </h2>

	<hr>
	<h1> doB4() 실행시 전달된 VO 객체 정보 출력 </h1>
	<h2>MemberVo : ${memberVO}</h2>
	${vo1}
<%--  	<h2> MemberVo (el 표현식) : ${requestScope} </h2>  --%>



</body>
</html>