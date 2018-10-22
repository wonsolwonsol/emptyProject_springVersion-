<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	.img{
		width: 20px;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#passwd2").on("keyup", function(){
			var passwd = $("#passwd1").val();
			var passwd2 = $(this).val(); 
			var mesg = "비밀번호 불일치";
			
			if(passwd == passwd2){
				mesg = "비밀번호 일치"
			}
			
			$("#presult").text(mesg);
			
			if(passwd2.length==0){
				$("#presult").text("");
			}
		});
		
		$("form").on("submit", function(e){
			if($("#passwd2").val().length==0){
				alert("비밀번호를 한번 더 확인하세요.");
				$("#passwd2").focus();
				e.preventDefault();
			}
		})
		
		$("#emailAdd").on("change",function(){
			$("#emailaddress").val($(this).val());
		}) 
	})
</script>
<h1>MY PAGE</h1>
<form action="loginCheck/memberUpdate" method="post">
<input type="hidden" name="userid" value=" ${member.userid}">
<table class="tbl">
<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
	<tr>
		<th>아이디</th>
		<td> ${member.userid}</td></tr>
	<tr><th>비밀번호</th>
		<td><input type="password" name="passwd" id="passwd1" value="${member.passwd}"></td></tr>
	<tr><th>비밀번호 확인</th>
		<td><input type="password" name="passwd2" id="passwd2"> <span id="presult"></span></td></tr>
	<tr><th>이름</th><td> ${member.username}</td></tr>
	<tr><th>주소</th>
		<td><input type="text" value="${member.post}" name="post" id="sample4_postcode" placeholder="우편번호">
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
		<span class="address">	<input type="text" value="${member.addr1}" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" value="${member.addr2}" name="addr2" id="sample4_jibunAddress" placeholder="지번주소"></span>
		<span id="guide" style="color:#999"></span></td></tr>
	
	
	<tr><th>휴대폰</th><td><select name="phone1">
		<option value="011" 
			<c:if test="${member.phone1 == '011'}">selected</c:if>>011</option> 
		<option value="010"
			<c:if test="${member.phone1 == '010'}">selected</c:if>>010</option> 
		</select>
		<input type="text" name="phone2" value="${member.phone2}">
		<input type="text" name="phone3" value="${member.phone3}"></td></tr>
	<tr><th>이메일</th><td><input type="text" name="email1" value="${member.email1}">@
		<input type="text" value="${member.email2}" name="email2" id="emailaddress" placeholder="직접입력">
		<select name="email3" id="emailAdd" >
			<option value="daum.net"
				<c:if test="${member.email2 == 'daum.net'}">selected</c:if>>daum.net</option> 
			<option value="naver.com"
				<c:if test="${member.email2 == 'naver.com'}">selected</c:if>>naver.com</option> 
		</select></td></tr>
</table>
<div class="btnGroup">
	<input type="submit" value="수정" class="btn yellow">
	<input type="reset" value="취소" class="btn gray">
	</div>
</form>


<h3>주문내역</h3>
<table class="tblList">
	<colgroup>
		<col width="15%" />
		<col width="10%" />
		<col width="25%" />
		<col width="10%" />
		<col width="*" />
		<col width="10%" />
	</colgroup>
	<tr>
		<th>주문번호</th>
		<th colspan="2">주문내역</th>
		<th>색상</th>
		<th>주문가격</th>
		<th>수량</th>
		<th>합계</th>
		<th>상태</th>
	</tr>
<c:forEach var="dto" items="${orderlist}" varStatus="status">
	<tr><td>${dto.num}</td>
		<td><span class="img"><img src="images/items/thum/${dto.goods_Image}.jpg" /></a></span></td>
		<td>
			<p class="bold">${dto.goods_Brand}</p>
			<p>${dto.goods_Name}</p>
		</td>
		<td>${dto.goods_Color}</td>
		<td><fmt:formatNumber value="${dto.goods_Price}" type="currency"/></td>
		<td>${dto.goods_Amount}</td>
		<td><fmt:formatNumber value="${dto.goods_Amount * dto.goods_Price}" type="currency"/></td>
		<td>결제완료</td>
	</tr>
</c:forEach>
</table>
<!-- 위시 테이블이 있는 경우에만 출력
<c:if test="">
<h1>WISH LIST</h1>
<table class="tbl">
	<colgroup>
		<col width="20%" />
		<col width="*" />
	</colgroup>
<c:forEach var="dto" items="${goodsList}" varStatus="status">
	<tr><td></td>
		<td>temp</td>
		<td>temp</td>
		<td>temp</td>
	</tr>
</c:forEach>
</c:if>  -->
</table>


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