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
	<th>글번호</th>
	<td>${reviewRetrieve[0].review_review_number}</td>

	
</tr>
<tr>
	<th>작성일</th>
	<td>>${reviewRetrieve[0].review_regdate}</td>
	<th>조회수</th>
	<td>${reviewRetrieve[0].review_readcnt}</td>
</tr>
<tr>
	<th>제목 </th>
	<td>${reviewRetrieve[0].review_title}</td>
	<th>작성자</th>
	<td>${reviewRetrieve[0].review_author}</td>

</tr>
<tr>
	<th>내용</th>
	<td>>${reviewRetrieve[0].review_content}</td>
</tr>
</table>
<hr> 
<table class="tbl">

<tr>
	<th width="10%">작성자</th>
	<th>내용</th>
</tr>
<c:forEach items="${reviewRetrieve}" var="data"> 
<tr>
<td width="10%">${data.review_comment_author } </td>
<td>${data.review_comment_content  }</td>
</tr>
</c:forEach>
</table>
<br> 

<hr>  

</body>
</html>

 
