<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.dto.QuestionBoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.QuestionBoard_CommentsDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#QuestionBoardDelete").on("click",function(){
		var Question_num = $("#Question_num").val();
		location.href="QuestionBoardDeleteServlet?Question_num="+Question_num;
	});
</script>
<!DOCTYPE html>
<html>
<head>
<style>th,td {padding:5px}
table{border-spacing:5px}
</style>

<meta charset="UTF-8">
<title>CSS</title>
<style>
table {
	width: 80%;
	border: 1px solid #444444;
	}
.a{
background-color: #fff;
}
</style>
</head>
<body>
   
 <h1 text-align=left>Question View </h1>
       <div id="QuestionView" background-color: #333
    height: 100px
    position: relative>
   <%
   QuestionBoardDTO dto = (QuestionBoardDTO)request.getAttribute("list");
   String Question_num= dto.getQuestion_num();
   String title = dto.getTitle();
   String userid = dto.getUserid();
   String Question_contents = dto.getQuestion_contents();
   String writeday = dto.getWriteday();
   String image_name = ""; 
	if(dto.getImage_name() != null){ image_name = dto.getImage_name(); }
	
%>
</div>

 <form>
 <input type="hidden" name="Question_num" value="<%= Question_num %>" id="Question_num"><br> 
<div class="content">
 	<table class="tbl">
	
<tr> 
	<th width:30%>글번호</th> 
	<td><%= Question_num%></td>
</tr>	              		
<tr>
	<th>작성일</th>
	<td> <%= writeday %></td> 
</tr>
 <tr>
 	<th width:30%>제목</th>
 	<td><%= title %></td>
 </tr>
 <tr>
	 <th width:30%>작성자 </th>
 	<td><%= userid %></td>
 </tr>
 <tr>
 	<td width:30%>내용</td>
 	<td><%= Question_contents %></td>
</tr>
 <tr> 
 	
 	<td ><img src="images/question/<%=image_name%>" border="10" width="200"></td>
 </tr>
 </table>
 </div>
<br> 

  </form>
 </body>
<body>
<!--   <a href="QuestionBoard_WirteUIServlet">글쓰기</a> -->
<a href="QuestionBoardServlet">목록으로</a>
<button id="QuestionBoardDelete">삭제하기</button>
<a href="QuestionBoardUpdateUIServlet">수정하기</a>
<!-- --------------------------------------------------------------------------------------------------- -->
  <div id="QuestionCommentView" background-color: #333
    height: 100px
    position: relative>
<table class="tbl">
<thead>
<tr>
	<th>작성자</th>
	<th>댓글</th>
</tr>
</thead>
 <td colspan="5"><hr></td></tr>
   <%
   	List<QuestionBoard_CommentsDTO> list2 = (List<QuestionBoard_CommentsDTO>)request.getAttribute("list2");
   for(QuestionBoard_CommentsDTO dto2 : list2){

%>
<tr>
<td font-size:10px;><%= dto2.getAuthor() %></td>
<td font-size:10px;><%= dto2.getComment_contents() %></td>
</tr>
<% } %>
</table></div>
<form> 
<p font-size:8px;>{#userid} 님 :</p>
<textarea cols="100" rows="5">댓글 입력은 로그인 후 가능합니다.</textarea>
<input type="submit" name="register" value="Register">
</form> 
<br>
<a href="QuestionBoardWriteUIServlet">질문하기</a>
<!-- <button bgcolor="white">목록으로</button> -->
</body>
</html>



