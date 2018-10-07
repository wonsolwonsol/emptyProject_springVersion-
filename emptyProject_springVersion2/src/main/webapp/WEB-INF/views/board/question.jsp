 <%@page import="com.dto.Notice"%>
<%@page import="com.dao.NoticeDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
$(document).ready(function(){	
//충격과 공포의 페이징
var record = $("#totalCount").val()
var total = record/8;
if(record%8 !=0) total=Math.ceil(total);
var curpage = $("#curpage").val();
var paging = "";

for(var i = 1; i <= total; i++){
	console.log(i);
	if(i==curpage){
		paging = paging+i+"&nbsp;&nbsp;";
		
	}else{
		paging = paging+"<a href='/app/notice2?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;";  
	}			
}

console.log(paging);
$("p").html(paging);

})
</script>
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
 <c:forEach var="dto" items="${page.Qlist }" varStatus="status">	
	<tr>
	<td>${dto.question_number }</td>
	<td>${dto.title }</td>
	<td>${dto.author }</td>
	<td>${dto.regdate }</td>
	</tr>
	</c:forEach> 
</tbody> 
</table>
<hr>
<input type="hidden" value="${page.totalCount}" id="totalCount">
<input type="hidden" value="${page.currentPage}" id="curpage">
<pre></pre>
<p align="center">page</p>
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

 
