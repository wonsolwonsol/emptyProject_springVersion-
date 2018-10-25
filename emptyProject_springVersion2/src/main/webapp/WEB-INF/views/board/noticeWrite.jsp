<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
<script type="text/javascript">
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
        var regdate = document.getElementById   ("regdate");
    regdate.innerHTML = year+"/"+month+"/"+day+" "+hour+":"+minute;
   });
function doOpenCheck(chk){
var obj = document.getElementsByName("term");
for(var i=0; i<obj.length; i++){
   if(obj[i] != chk){
       obj[i].checked = false;
   }
}
}
</script>
<form action="noticeWriteSubmit" method="post">
<table class="tbl">
<tr>
	<th>제목</th>
	<td><input type="text" name="title"></td>
	<th>작성일</th>
	<td id="regdate"></td>
	<input type="hidden" name="reg_dts" value="sysdate"> 
</tr>
<tr>
	<th>내용</th>
	<td colspan="3" width="90%"><input type="text" name="content" id="content" ></td>
	<pre></pre><pre></pre>
	<a class= "a_black aLink" href="notice?currentPage=1">목록보기</a><pre></pre>
</tr>
</table>
<button class="btn gray"><input type="submit" value="등록"></button><pre></pre><pre></pre>


</body>
</html>