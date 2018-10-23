<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function(){		
		//email
		$("#email3").on("change",function(){			
			$("#email2").val($(this).val());
		})		
	})//

</script>
<div>
<form action="idfind" method="post" name="myForm">
<h1>FIND ID</h1>
	<table class="tbl">
				<colgroup>
				<col width="30%" />
				<col width="*" />
			</colgroup>
		<tr>
		<th>이름</th><td><input type="text" name="username"></td></tr>
		<tr>
			<th>휴대폰</th>			
			<td><select name="phone1">
			<option value="010" selected="selected">010</option>
			<option value="011">011</option>
			</select>
			<input type="text" name="phone2">
			<input type="text" name="phone3"></td></tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email1">@<input type="text" name="email2" id="email2">
			<select name="email3" id="email3">
				<option value="naver.com" selected="selected">naver.com</option>
				<option value="daum.net">daum.net</option>
				</select></td></tr>		
	</table>
	<div class="btnGroup">
	<button type="submit" class="btn yellow">메일 보내기</button>
	<input type="reset" value="취소" class="btn gray">
	</div>
</form>
</div>