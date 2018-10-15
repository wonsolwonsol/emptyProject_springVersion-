 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
$("#submit").click(function(e){
	if(${empty member}){
		alert("로그인이 필요합니다."); 
	}
}); 
</script>
<h1>Question Retrieve</h1>
<table class="tbl"> 
<tr> 
	<th width="20%">글번호</th>
	<td>${questionRetrieve.question_number }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성일</th>
	<td>${questionRetrieve.regdate }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">제목</th>
	<td>${questionRetrieve.title }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성자</th>
	<td>${questionRetrieve.author }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="0%"></th>
	<td width="90%">${questionRetrieve.content }</td>
	<td width="10%"><a href="questionUpdateUI?question_number=${questionRetrieve.question_number } "><img src="images/icon/update_icon.png" width="20px" height="30px" ></a></td>
	<td width="10%"><a href="questionDelete?question_number=${questionRetrieve.question_number }"><img src="images/icon/delete_icon.png" width="20px" height="30px" ></a></td>
</tr>
</table>
<br> 

<table class="tbl">
<tr>
	<th width="10%">작성자</th>
	<th>댓글</th>
	<th></th>
	
<c:forEach var="dto" items="${questionComment }"  varStatus="status">	
<tr>
	<td width="10%" align="center">${dto.author }</td>
	<td>${dto.comment_contents }</td>
	<td align="left" width="3%"
	><a href="questionCommentDelete?comment_number=${dto.comment_number}&question_number=${questionRetrieve.question_number }"><img src="images/icon/delete_icon.png" width="20px" height="30px" ></a></td>
</tr>
</c:forEach> 
</table>
<hr>  
<form name="myForm" method="post" action="questionCommentWrite">
<input type="hidden" value="${member.userid }" name="author"> 
<input type="hidden" value="${questionRetrieve.question_number }" name="question_number"> 
${member.userid } 님 : <br><br> 
<textarea style="resize:none;" id="content" cols="110" rows="2" name="comment_contents"></textarea>
<input type="submit" id="submit" class="btn yellow" value="등록" />
</form>
</body>
</html>

 
