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
	<h1>member/joinMember.jsp</h1>
	<fieldset>
		<legend> 회원가입 </legend>
		<form action="" method="post">
			<div class="mb-3">
				<label  class="form-label">
					아이디 : </label> <input type="text" class="form-control" name="userid" 
					 placeholder="Example input placeholder">
			</div>
			<div class="mb-3">
				<label  class="form-label">비밀번호 : 
				</label> <input type="text" class="form-control" name="userpw" 
					 placeholder="Example input placeholder">
			</div>
			<div class="mb-3">
				<label  class="form-label">이름 : 
				</label> <input type="text" class="form-control" name="username" 
					 placeholder="Example input placeholder">
			</div>
			<div class="mb-3">
				<label  class="form-label">이메일 : 
				</label> <input type="text" class="form-control" name="useremail" 
					 placeholder="Example input placeholder">
			</div>
			<input type="submit" value="제출">
		</form>
	</fieldset>
</body>
</html>