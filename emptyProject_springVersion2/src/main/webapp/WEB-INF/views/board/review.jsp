 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
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
		paging = paging+"<a href='/app/review?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;";  
	}			
}

console.log(paging);
$("p").html(paging);

}) 
</script>

<h1>Review Board</h1>
<span align="center"><c:if test="${member.userid eq 'admin'}">
<d align="center">운영자로 로그인하셨습니다. 모든 글 보기가 가능합니다. </d>
</c:if></span><pre></pre>
<br> 
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
  <c:forEach var="dto" items="${page.list }" varStatus="status">	 
	<tr>
	<td>${dto. review_number }<%-- &nbsp;${dto.term } --%></td>
	<td class="td_default">
	<%-- 	<c:if test="${dto.term == 'n'}">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
		</c:if>
	<c:if test="${dto.term =='y'}">
			<c:if test="${empty member}">
			 작성자와 운영자만 볼 수 있는 글입니다.
			 <img src="images/icon/key_icon.png" width="12px" height="12px" >
			</c:if>
		<c:if test="${dto.author == member.userid }">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
		</c:if>
		<c:if test="${member.userid eq 'admin'}">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
		</c:if>
	</c:if> --%>
	<c:choose>
	<c:when test="${dto.term == 'n'}">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
	</c:when>
	<c:when test="${dto.term =='y'}">
		<c:choose>
			<c:when test="${empty member}">
			 작성자와 운영자만 볼 수 있는 글입니다.
			 <img src="images/icon/key_icon.png" width="12px" height="12px" >
			</c:when>
		<c:when test="${dto.author == member.userid }">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
		</c:when>
		<c:when test="${member.userid eq 'admin'}">
		<a class="a_black" href="reviewRetrieve?review_number=${dto.review_number}">${dto.title}</a>
		</c:when> 
		<c:otherwise>로그인을 확인하세요.</c:otherwise>
		</c:choose>
	</c:when>
		<c:otherwise>로그인을 확인하세요.</c:otherwise>
	</c:choose>
	</td>
	<td align="center">${dto.author}</td>
	<td>${dto.regdate}</td>
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
<button class="btn yellow" style="width:10%" ><a href="reviewWrite">리뷰작성</a></button>
<%-- <c:if test="${!empty member }">
 	<c:if test="${member.userid eq 'admin' }">
 	<button class="btn gray"><a href=""></a>질문관리 </button>
 	</c:if>
 	</c:if> --%>
</body>
</html>

 
