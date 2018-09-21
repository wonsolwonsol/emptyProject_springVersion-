<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><h1 align="center">질문하기</h1><br>

<pre></pre>
<br> 
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
<script type="text/javascript">
</script>
<form action="" method="post" enctype="multipart/form-data">
<input type="hidden" name="userid" value="${login.username}" />
<table class="tbl">

<tr>

    <td>제목</td>
    <td colspan="2"><input type="text" name="title" style="width: 80%;" /></td><pre></pre>
</tr>
<tr>
    <td align="center" colspan="2">
        <textarea  name="content" rows="17" cols="100"></textarea><pre></pre>
    </td>
</tr>
<tr>
    <td>첨부 파일</td>
    <td><input type="file" name="image_name" id="image_name" /></td><pre></pre>
</tr>
</table>
<div style="text-align: center; padding-bottom: 15px;">
    <input type="submit" value="등록" />
    <input type="reset" value="다시쓰기" /> 

</div>
</form><br> 
<a href="">목록보기</a>

</body>
</html>