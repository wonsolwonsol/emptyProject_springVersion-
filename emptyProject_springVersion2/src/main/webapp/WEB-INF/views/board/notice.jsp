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
<!-- <div class="adsense" style="text-align: center; padding:0px 0px 10px 10px">  -->
<!-- <div class="notice"> -->
<h1>공지</h1>
<table class="tbl" border="1">
<thead>
	<tr>
	<th>글번호</th>
	<th>제목</th>
	</tr></thead>
<tbody>
<c:forEach var="dto" items="${page.list2 }" varStatus="status">	
<tr>
	<td>${dto.seq}</td>
	<td>
	<a class="a_black" href="noticeRetrieve?seq=${dto.seq}">
	${dto.title}</a>
	</td>
	</tr>

</c:forEach>
</tbody>
</table>
<hr>
<input type="hidden" value="${page.totalCount}" id="totalCount">
<input type="hidden" value="${page.currentPage}" id="curpage">
<pre></pre>
<p align="center">page</p>

<%-- <table class="tbl" border="1">
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
</table> --%>
<br> 
<pre></pre>
<c:if test="${member.userid == 'admin' }">
 <button class="btn gray small" align="center"><a href="noticeWrite">공지등록</a></button>
 </c:if>

</body>
</html>

 
