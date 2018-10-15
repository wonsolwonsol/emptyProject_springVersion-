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
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	
	
	var sum = 0;
	$(".price").each(function(index){		
		sum = (sum + parseInt($(this).val()));		
	})
	$("#sum").text(format(sum));
	
	function format(sum) {
	    return "￦"+sum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	}
	// 
	
	//
	$("#same").on("click",function(){
		if(this.checked){
			$("#name_same").val($("#name").val());
			$("#sample4_postcode").val($("#post").val());
			$("#sample4_roadAddress").val($("#addr1").val());
			$("#sample4_jibunAddress").val($("#addr2").val());
			$("#phone1_same").val($("#phone1").val());
			$("#phone2_same").val($("#phone2").val());
			$("#phone3_same").val($("#phone3").val());
			$("#email1_same").val($("#email1").val());
			$("#email2_same").val($("#email2").val());
		}else{
			$("#name_same").val("");
			$("#sample4_postcode").val("");
			$("#sample4_roadAddress").val("");
			$("#sample4_jibunAddress").val("");
			$("#phone1_same").val("");
			$("#phone2_same").val("");
			$("#phone3_same").val("");
			$("#email1_same").val("");
			$("#email2_same").val("");
			}
			
		});
	});
	
</script>
</head>
<body>
<h1>ORDER</h1>
<form action="loginCheck/orderConfirmAll" method="get">
 	
<%--  	<input type="hidden" name="goods_Code" value="${list.goods_Code}">
 	<input type="hidden" name="goods_Name" value="${list.goods_Name}">
 	<input type="hidden" name="goods_Price" value="${list.goods_Price}">
 	<input type="hidden" name="goods_Brand" value="${list.goods_Brand}">
 	<input type="hidden" name="goods_Color" value="${list.goods_Color}">
 	<input type="hidden" name="goods_Amount" value="${list.goods_Amount}">
 	<input type="hidden" name="goods_Image" value="${list.goods_Image}"> --%>

<h3>주문정보</h3>
<table class="tblList">
			<colgroup>
				<col width="15%" />
				<col width="15%" />
				<col width="*" />				
			</colgroup>
	<tr>
		<th>주문번호</th>
		<th colspan="2">상품정보</th>
		<th>색상</th>	
		<th>수량</th>
		<th>합계</th>
	</tr>
	<c:forEach items="${orderTemp}" var="list">
	<input type="hidden" name="num" value="${list.num}"> 
	<tr>
		<td>${list.num}</td>
		<td class="img"><img src="images/items/thum/${list.goods_Image}.jpg"/></td>
		<td><p class="bold">
			${list.goods_Brand}</p>
			<p>${list.goods_Name}</p>		
		</td>
		<td>${list.goods_Color}</td>
		<td>${list.goods_Amount}</td>
		<td><fmt:formatNumber value="${list.goods_Price * list.goods_Amount}" type="currency" /></td>	
		<input type="hidden" class="price" value="${list.goods_Price * list.goods_Amount}">
		</c:forEach>	
		<tr class="highlight gray"><th colspan="2">합계</th>
			<td colspan="4" id="sum" style="font-weight: bold;"></td></tr>
</table>

<h3>고객정보</h3>

<table class="tbl">			
	<tr><th>이름</th><td><input type="text" value=" ${member.username}" id="name"></td></tr>
	<tr><th>주소</th>
		<td><input type="text" value="${member.post}" id="post" placeholder="우편번호">
		<!-- <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"> -->
		<span class="address">	
		<input type="text" value="${member.addr1}" name="addr1" id="addr1" placeholder="도로명주소">
		<input type="text" value="${member.addr2}" name="addr2" id="addr2" placeholder="지번주소"></span>
		<span id="guide" style="color:#999"></span></td>
	</tr>	
	<tr><th>휴대폰</th><td><select name="phone1" id="phone1">
		<option value="011" 
			<c:if test="${member.phone1 == '011'}">selected</c:if>>011</option> 
		<option value="010"
			<c:if test="${member.phone1 == '010'}">selected</c:if>>010</option> 
		</select>
		<input type="text" name="phone2" id="phone2" value="${member.phone2}">
		<input type="text" name="phone3" id="phone3" value="${member.phone3}"></td>
	</tr>
	<tr><th>이메일</th><td>
		<input type="text" name="email1" value="${member.email1}" id="email1" >@
		<input type="text" value="${member.email2}" name="email2" id="email2" placeholder="직접입력">
		<select name="email3" id="emailAdd" >
			<option value="daum.net"
				<c:if test="${member.email2 == 'daum.net'}">selected</c:if>>daum.net</option> 
			<option value="naver.com"
				<c:if test="${member.email2 == 'naver.com'}">selected</c:if>>naver.com</option> 
		</select></td>
	</tr>
		
	<tr> 
		<td style="" colspan="6">
			 <input type="checkbox" name="same" id="same"> 배송지가 동일할 경우 선택하세요.
		</td>
	</tr>
	
	<tr>		
	<tr><th>이름</th><td><input type="text" id="name_same" name="username"></td></tr>
	<tr><th>주소</th>
		<td><input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
		<span class="address">	
		<input type="text" name="addr1_same" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" name="addr2_same" id="sample4_jibunAddress" placeholder="지번주소"></span>
		<span id="guide" style="color:#999"></span></td>
	</tr>	
	<tr><th>휴대폰</th><td><select id="phone1_same">
		<option value="011" 
			<c:if test="${member.phone1 == '011'}">selected</c:if>>011</option> 
		<option value="010"
			<c:if test="${member.phone1 == '010'}">selected</c:if>>010</option> 
		</select>
		<input type="text" id="phone2_same">
		<input type="text" id="phone3_same"></td></tr>
	<tr><th>이메일</th><td><input type="text" id="email1_same">@
		<input type="text" id="email2_same" id="emailaddress" placeholder="직접입력">
		<select name="email3" id="emailAdd" >
			<option value="daum.net"
				>daum.net</option> 
			<option value="naver.com"
				>naver.com</option> 
		</select></td>
	</tr>
	</table>
	<h3>결제정보</h3>
	<table class="tblList">
	<tr>
		<td colspan="6">
			<input type="radio" name="payMethod" value="신용카드" checked>신용카드					
			<input type="radio" name="payMethod" value="계좌이체">계좌이체					
			<input type="radio" name="payMethod" value="무통장 입금">무통장 입금
		</td>					
	</tr>
</table>
<div class="btnGroup">
	<input type="submit" value="결제" class="btn yellow">
	<input type="reset" value="취소" class="btn gray">
	</div>

</form>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample4_roadAddress').value = fullRoadAddr;
                document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
</body>
</html>