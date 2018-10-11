<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
<h1>questionWrite View</h1>
<table class="tbl"> 
<tr> 
	<td>제목</td>
	<td colspan="2"><input type="text" name="title" style="width: 80%" align="center" /></td><pre></pre>
</tr>
<tr align="center">
    <td align="center" colspan="2">
        <textarea  name="content" rows="17" cols="100"></textarea><pre></pre>
    </td>
</tr>
</table>
<div style="text-align: center;padding-bottom: 15px;">
    <input type="submit" value="등록" />
    <input type="reset" value="다시쓰기" /> 

</div>
</form><br>
<a href="question">목록보기</a>
</body>
</html>