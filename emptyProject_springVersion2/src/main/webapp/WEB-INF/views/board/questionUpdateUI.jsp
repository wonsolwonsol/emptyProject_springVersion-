 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script type="text/javascript">
 $("#submit").click(function(e){
 	if(${empty member}){
		alert("로그인이 필요합니다."); 
	} -----
});  
</script> -->
<h1>Question Retrieve</h1>
<form  name="myForm" method="post" action="questionUpdate">
<table class="tbl"> 
<tr> 
	<th width="20%">글번호</th>
	<td><input type="text" value="${questionUpdateUI.question_number }" readonly name="question_number"></td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성일</th>
	<td><input type="text" value="${questionUpdateUI.regdate }" readonly name="regdate"></td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">제목</th>
	<td><input type="text" value="${questionUpdateUI.title }" name="title"></td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성자</th>
	<td><input type="text" readonly value="${questionUpdateUI.author }" name="author"></td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="0%"></th>
	<td width="90%"><input type="text" value="${questionUpdateUI.content }" name="content" width="90%"></td>

</tr>
</table>
<br> 
<input type="submit" class="btn yellow" value="수정">
<button type="reset" class="btn darkGray">취소</button>
</form>
<br> 


</body>
</html>

 
