<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1>member/UpdateMember.jsp</h1>
	<fieldset>
		<legend> 회원정보 수정 </legend>
		<form action="" method="post">
			<div class="mb-3">
				<label  class="form-label">
					아이디 : </label> <input type="text" class="form-control" name="userid" value="${memberVO.userid}" readonly="readonly"
					 >
			</div>
			<div class="mb-3">
				<label  class="form-label">비밀번호 : 
				</label> <input type="text" class="form-control" name="userpw" 
					 value="${memberVO.userpw}" >
			</div>
			<div class="mb-3">
				<label  class="form-label">이름 : 
				</label> <input type="text" class="form-control" name="username" 
					 value="${memberVO.username}" >
			</div>
			<div class="mb-3">
				<label  class="form-label">이메일 : 
				</label> <input type="text" class="form-control" name="useremail" 
					 value="${memberVO.useremail}" >
			</div>
			<input type="submit" value="회원수정">
		</form>
	</fieldset>
</body>
</html>