 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">

</script>
<h1>Notice Retrieve</h1>
<table class="tbl"> 
<tr>
	<th>글번호</th>
	<td>${noticeRetrieve.seq }</td>
</tr>
<tr>
	<th>글제목</th>
	<td>${noticeRetrieve.title }</td>
</tr>
<tr>
	<th>작성일</th>
	<td>${noticeRetrieve.reg_dts }</td>
</tr>
<tr>
	<th height="70%">내용</th>
	<td height="70%">${noticeRetrieve.content }</td>
</tr>

</table>
<button class="btn yellow"><a href="notice2?currentPage=1">목록으로</a></button>
</body>
</html>

 
