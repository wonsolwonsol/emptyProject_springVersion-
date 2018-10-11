<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>questionRetrieve</h1>
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
	<td width="10%"><a href=""><img src="images/icon/update_icon.png" width="20px" height="30px" ></a></td>
	<td width="10%"><a href="questionDelete?question_number=${questionRetrieve.question_number }"><img src="images/icon/delete_icon.png" width="20px" height="30px" ></a></td>
</tr>
</table><br>
<h1>코멘트</h1>
<table class="tbl">
<tr>
	<th width="10%">작성자</th>
	<td width="90%">내용</td>
	<td width="10%"><a href=""><img src="images/icon/update_icon.png" width="20px" height="30px" ></td>
	<td width="10%"><a href=""><img src="images/icon/delete_icon.png" width="20px" height="30px" ></a></td>
</tr>
</table>
<pre></pre><br>

<ul>
${questionComment }


<c:if test="${!empty member }">
<li>
${member.userid} 님 : <input type="textarea" width="100%" id="comment"> 
</li>
</c:if></ul>


</body>
</html>