<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	$(function(){	
		//form submit
		$("form").on("submit", function(e){
			var userid = $("#userid");
			var passwd = $("#passwd");
				
			if(userid.val() == ""){
				alert("아이디는 필수입력 사항입니다.");
				userid.focus();
				e.preventDefault();
			}else if(passwd.val() == ""){
				alert("비밀번호는 필수입력 사항입니다.");
				passwd.focus();
				e.preventDefault();
			}
		})
	})
		</script>
			<c:if test="${!empty mesg}">
		<script type="text/javascript">
			alert("${mesg}");
		</script>
	</c:if>	

<h1>LOGIN</h1>
<div class="loginForm">
<form:form action="login" method="post" modelAttribute="login">
<table class="tbl">
	<colgroup>
			<col style="width:30%">
			<col style="width:*">
	</colgroup>
			
	<tr><th>아이디</th><td><input type="text" name="userid" id="userid">
<%-- 	<form:errors path="userid"/> --%>
	</td></tr>	
	<tr><th>비밀번호</th><td><input type="text" name="passwd" id="passwd">
<%-- 	<form:errors path="passwd"/> --%>
	</td></tr>	
</table>
<div>
<a href="idFind">아이디 찾기</a>
<a href="memberForm">회원가입</a><br><br>
</div>
<div class="btnGroup">
<input type="submit" value="로그인" class="btn yellow">
</div>
</form:form>
</div>


