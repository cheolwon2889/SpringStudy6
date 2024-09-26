<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<fieldset>
		<legend> 회원정보 삭제 </legend>
		<form method="post">
			아이디 : <input type="text" value="${memberVO.userid}" name="userid" > <br>
			비밀번호 : <input type="password" name="userpw">
			
			<br>
			<input type="submit"  value="삭제" >		
		
		</form>
	</fieldset>
	
</body>
</html>