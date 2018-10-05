 <%@page import="com.dto.Notice"%>
<%@page import="com.dao.NoticeDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Question Board</h1>
<table class="tbl" border="1" align="center">
<thead>
	<tr>
		<th style="width:5%">글번호</th>
		<th style="width:30%">글제목</th>
		<th style="width:10%">글쓴이</th>
		<th style="width:10%">작성일</th>
	</tr>
	</thead>
<tbody>
	<tr>
	<td></td>
	<td></td>
	<td></td>
	<td></td>
</tbody>
</table>
<pre></pre>
<br> 
<button class="btn yellow" style="width:10%" ><a href="questionWrite">질문하기</a></button>
<c:if test="${!empty member }">
 	<c:if test="${member.userid eq 'admin' }">
 	<button class="btn gray"><a href=""></a>질문관리 </button>
 	</c:if>
 	</c:if>
</body>
</html>

 
