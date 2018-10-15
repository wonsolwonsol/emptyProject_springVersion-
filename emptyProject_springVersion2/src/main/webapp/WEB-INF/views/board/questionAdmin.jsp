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
	$("#allCheck").on("click", function(){
		var result = this.checked;
		$(".check").each(function(idx,data){
			this.checked = result;
		})
	})
	$("#questionAdminDelAll").on("click", function(e){
		var mesg = confirm("삭제하시겠어요?"); 
		if(mesg==true){
			$("form").attr("action", "questionAdminDelAll");
			$("form").submit();
		}else{
			e.preventDefault(); 
		}//end questionAdminDelAll
			})
			
		
	

	//충격과 공포의 페이징
	var record = $("#totalCount").val()
	var total = record/8;
	if(record%8 !=0) total=Math.ceil(total);
	var curpage = $("#curpage").val();
	var paging = "";
	
	for(var i = 1; i <= total; i++){
		if(i==curpage){
			paging = paging+i+"&nbsp;&nbsp;";
			
		}else{
			paging = paging+"<a href='/app/questionAdmin?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;";  
		}			
	}
	console.log(paging); 
	$(".page").html(paging);
	
})
</script>
<h1>관리자 모드 </h1>
<form name="myForm" method="get">
<table class="tbl" border="1" align="center">
<thead>
	<tr>
		<th style="width:5%"><input type="checkbox" id="allCheck" name="check">All</th>
		<th style="width:5%">글번호</th>
		<th style="width:30%">글제목</th>
		<th style="width:10%">글쓴이</th>
		<th style="width:10%">작성일</th>
		<th  style="width:10%">개별삭제</th>
	</tr>
	</thead>
<tbody>
 <c:forEach var="dto" items="${page.list }" varStatus="status">	
	<tr>
	<td> <input type="checkbox"  class="check" name="check" class="check" value="${dto.question_number }"></td>
	<td>${dto.question_number }</td>
	<td class="td_default">
	<a class="a_black" href="questionRetrieve?question_number=${dto.question_number}">${dto.title }</a></td>
	<td align="center">${dto.author }</td>
	<td>${dto.regdate }</td>
	<td>
		<input type="button" class="btn xsmall darkGray delBtn" data-delBtn="${dto.question_number}" value="삭제" />
	</td>
	</tr>
	</c:forEach> 
</tbody> 
</table>
 </form>
<hr>
<input type="hidden" value="${page.totalCount}" id="totalCount">
<input type="hidden" value="${page.currentPage}" id="curpage">
<pre></pre>
<p align="center">page</p>
<pre></pre>
<br> 
<center>
<button class="btn grey" style="width:10%" ><a href="questionWrite">질문하기</a></button>
<button class="btn yellow" style="width:10%" id="questionAdminDelAll">선택삭제</button>
</center>
</body>
</html>

 
