<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<script type="text/javascript">
/* $("#submit").click(function(e){
	
	var question_number = "question_number.NEXTVAL"; 
	var title = $("#title").val(); 
	var author = $("#author").val(); 
	var content = $("#content").val();
	var regdate = $("#regdate").val();  
	console.log("자바스크립트 코드"); 
});  */
$(function(){
	  var now = new Date(); //현재 날짜 가져오기
	  var year = now.getFullYear(); //현재 년도 가져오기
	  var month = now.getMonth(); // 현재 월 가져오기
	  var day = now.getDate(); //현재 일 가져오기
	  var hour = now.getHours(); //현재 시간 가져오기
	  var minute = now.getMinutes(); //현재 분 가져오기
	  var today = new Date(year,month,day); //오늘 날짜 시간제외
	  var yesterday = new Date(year,month,day - 1); //어제 날짜 시간제외
	  var desterday = new Date(year,month,day - 2); //그저께 날짜 시간제외
		var regdate = document.getElementById	("regdate");
	  regdate.innerHTML = year+"/"+month+"/"+day+" "+hour+":"+minute; 
	 });
</script>
 
<h1>questionWrite View</h1>
<form name="myForm" method="post" action="questionWriteSumit"> 
<table class="tbl"> 
<input type="hidden" id="question_number" name="question_number" value="0">
<tr> 
	<td>작성자</td>
	<td>${member.userid }</td>
	<input type="hidden" name="author" value="${member.userid }">

<tr> 
	<td>제목</td>
	<td colspan="2"><input type="text" name="title" id="title" style="width: 80%" /></td><pre></pre>
	
</tr>
<tr align="center">
	<td>내용</td>
    <td align="center" colspan="2">
        <textarea  name="content" id="content" rows="17" cols="120"></textarea><pre></pre>
    </td>
</tr>
<tr>
	<td>작성일</td>
	<td id="regdate"></td>
	<input type="hidden" id="regdate" name="regdate" value="sysdate"> 
</tr>
</table><br> 
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" id="submit" class="btn yellow" value="등록" />
    <input type="reset" id="reset" class="btn grey" value="다시쓰기" /> 
</form>
</div>
<br>
<a href="question">목록보기</a>
</body>
</html>