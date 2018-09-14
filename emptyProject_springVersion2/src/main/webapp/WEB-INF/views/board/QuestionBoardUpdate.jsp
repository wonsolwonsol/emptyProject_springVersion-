<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.dto.QuestionBoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.QuestionBoard_CommentsDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   
 <h1>Question Update </h1>
       <div id="QuestionUpdate" background-color: #333
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

 <form action="" method="post">
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
 	<th>제목</th>
 	<td><input type="text" name="title" value="<%= title %>"></td>
 </tr>
 <tr>
	 <th>작성자 </th>
 	<td><%= userid %></td>
 </tr>
 <tr>
 	<td>내용</td>
 	<td><input type="text" name="Question_contents" value="<%= Question_contents %>"></td>
</tr>
 <tr> 
 	
 	<td ><img src="images/question/<%=image_name%>" border="10" width="200"></td>
 </tr>
 </table>
 </div>
 <input type="submit" value="수정"> 
  </form>
 <a href="QuestionBoardServlet">목록보기</a>
 </body>
</html>



