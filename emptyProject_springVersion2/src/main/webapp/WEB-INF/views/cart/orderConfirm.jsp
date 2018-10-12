<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.1.0.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	//
	var pr = $("#price").text();
	console.log(pr)
	var sum = 0;
	$(".price").each(function(index){		
		sum = (sum + parseInt($(this).val()));		
	})
	$("#sum").text(format(sum));
	$("#price").text(format(pr))
	
	function format(sum) {
	    return "￦"+sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	

});
	
</script>
</head>
<body>
<h1>주문성공</h1>
<p id="orderSuccess">
감사합니다. 주문이 완료 되었습니다<br>
주문번호: ${order.num}
</p>

<h3>주문정보</h3>
<table class="tblList">
	<tr>
		<th>주문번호</th>
		<th colspan="2">상품정보</th>
		<th>색상</th>
		<th>판매가</th>		
		<th>수량</th>
		<th>합계</th>
	</tr>
	<tr>
		<td>${order.num}</td>
		<td class="img"><img src="images/items/thum/${order.goods_Image}.jpg"/></td>
		<td><p class="bold">
			${order.goods_Brand}</p>
			<p>${order.goods_Name}</p>		
		</td>
		<td>${order.goods_Color}</td>
		<td id="price">${order.goods_Price}</td>
		<td>${order.goods_Amount}</td>
		<td><fmt:formatNumber value="${order.goods_Price * order.goods_Amount}" type="currency" /></td>	
		<input type="hidden" class="price" value="${order.goods_Price * order.goods_Amount}">
		<tr class="highlight gray"><th colspan="2">합계</th>
			<td colspan="4" id="sum" style="font-weight: bold;"></td></tr>	
</table>

<h3>결제정보</h3>
	<table class="tblList">
	<tr>
		<th>결제수단</th>
		<th>상태</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
	</tr>
</table>

<h3>고객정보</h3>

<table class="tbl">			
	<tr><th>이름</th><td>${order.username}"</td></tr>
	<tr><th>주소</th>
		<td>${order.post}
		<span class="address">	
		${order.addr1}
		${order.addr2}</span>
		</td>
	</tr>	
	<tr>
		<th>휴대폰</th><td>${order.phone1}-${order.phone2}-${order.phone3}
	</tr>
	<tr><th>이메일</th>
		<td>
		${order.email1}@${order.email2}
		</td>
	</tr>
</table>
	

<div class="btnGroup">
	<input type="submit" value="결제" class="btn yellow">
	<input type="reset" value="취소" class="btn gray">
	</div>
</body>
</html>