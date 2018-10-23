 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">


$(document).ready(function() {
    $('#content').on('keyup', function() {
  if($(this).val().length > 50) {
            $(this).val($(this).val().substring(0, 50));
        } }); //end content, 코멘트 글자 수 제한 
        







    
    
    });

</script>
<h1>Review Retrieve</h1>
<table class="tbl"> 
<tr> 
	<th>글번호</th>
	<td>${reviewRetrieve[0].review_review_number}</td>
	<th>삭제</th>
	<td>
<a href="reviewUpdate?review_number=${reviewRetrieve[0].review_review_number}">수정하기</a>&nbsp;
<a href="reviewDelete?review_number=${reviewRetrieve[0].review_review_number}">삭제하기</a>
	</td>
</tr>
<tr>
	<th>작성일</th>
	<td>>${reviewRetrieve[0].review_regdate}</td>
	<th>조회수</th>
	<td>${reviewRetrieve[0].review_readcnt}</td>
</tr>
<tr>
	<th>제목 </th>
	<td>
	${reviewRetrieve[0].review_title}
	</td>
	<th>작성자</th>
	<td>${reviewRetrieve[0].review_author}</td>

</tr>
<tr>
	<th>내용</th>
	<td>>${reviewRetrieve[0].review_content}</td>
</tr>
<c:if test="${ !empty reviewRetrieve[0].review_image_name }">
<tr>
	<th>첨부파일</th>
	<td>${reviewRetrieve[0].review_image_name }</td>
</tr>
</c:if>
</table>
<hr> 
<table class="tbl">

<tr>
	<th width="10%">작성자</th>
	<th>내용</th>
	<c:if test="${!empty member}">
		<th>제어</th>
	</c:if>
	<c:if test="${empty member}"></c:if>
	
</tr>
<c:forEach items="${reviewRetrieve}" var="data"> 
<tr>
<td width="10%">${data.review_comment_author } </td>
<td>${data.review_comment_content  }</td>
<c:if test="${!empty member}">
	<c:if test="${member.userid eq 'admin' }">
		<td> 
		<a href="reviewCommentDelete?r_comment_number=${data.review_comment_number }"><img src="images/icon/trash.png"></a>
		</td>
	</c:if>
	<c:if test="${ data.review_comment_author != member.userid  }">
		<td></td>
	</c:if>
	<c:if test="${ data.review_comment_author == member.userid }">
		<td><a href="reviewCommentDelete?r_comment_number=${data.review_comment_number }"><img src="images/icon/trash.png"></a></td>
	</c:if>
</c:if>

<c:if test="${empty member}"></c:if>
</tr>

</c:forEach>
</table>
<br> 

<hr>  
<c:if test="${ empty member  }">
댓글 작성은 회원만 이용이 가능합니다. 
</c:if>
<c:if test="${ !empty member }"> 
<form id="myForm" action="reviewComment">
${member.userid } 님 
<input type="hidden" value="${ reviewRetrieve[0].review_review_number}" name="review_number">
<input type="hidden" value=${member.userid } name="author">
<input type="textarea" name="content" style="width:85%; height:5%;" >
<input type="submit" value="등록"> 
</form>
</c:if>
</body>
</html>

 
