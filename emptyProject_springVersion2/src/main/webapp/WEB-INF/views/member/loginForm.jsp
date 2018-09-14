<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN</h1>
<div class="loginForm">
<form action="LoginServlet" method="post">
<table class="tbl">
	<tr><th>아이디</th><td><input type="text" name="userid"></td></tr>
	<tr><th>비밀번호</th><td><input type="text" name="passwd"></td></tr>
</table>
<div>
<a href="IdFindUIServlet">아이디 찾기</a>
<a href="memberForm.jsp">회원가입</a><br><br>
</div>
<div class="btnGroup">
<input type="submit" value="로그인" class="btn yellow">
</div>
</form>
</div>

</body>
</html>