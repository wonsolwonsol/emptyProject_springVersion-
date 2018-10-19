 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
// var 
</script>
<h1>Review Retrieve</h1>
<table class="tbl"> 
<tr> 
	<th width="20%">글번호</th>
	<td></td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성일</th>
	<td>${reviewRetrieve.regdate }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">제목</th>
	<td>${reviewRetrieve.title }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">작성자</th>
	<td>${reviewRetrieve.author }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="20%">조회수</th>
	<td>${reviewRetrieve.readcnt }</td>
	<td width="10%"></td>
</tr>
<tr>
	<th width="0%"></th>
	<td width="90%">${reviewRetrieve.content }</td>
</tr>
</table>
<br> 

<hr>  

</body>
</html>

 
