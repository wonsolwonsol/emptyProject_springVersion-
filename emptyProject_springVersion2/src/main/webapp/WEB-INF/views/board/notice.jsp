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

<div class="adsense" style="text-align: center; padding:0px 0px 10px 10px"> 
<div class="notice"><h1>공지</h1>
<table class="tbl" border="1">
<thead>
	<tr>
	<th>글번호</th>
	<th>제목</th>	
</thead> 
<tbody>
<c:forEach items="${Notice }" var="Notice"> 
<tr>
	<td>${Notice.seq}</td>
	<td>${Notice.title}</td>
</tr>
</c:forEach>
</tbody>
</table>
<br> 
 <button class="btn gray small"><a href="noticeWrite">공지등록</a></button>
 </div></div>
</body>
</html>

 
