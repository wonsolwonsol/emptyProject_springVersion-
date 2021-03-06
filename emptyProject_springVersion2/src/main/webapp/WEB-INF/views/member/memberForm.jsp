<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#result{
	color:orange;
}
#result2{
	color:orange;
}
</style>
<script type="text/javascript">
	$(function(){	
		var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힝]/;		
		var userid = $("#userid");
		var passwd1 = $("#passwd1");
		var passwd2 = $("#passwd2");
		var username = $("#username");
		var sample4_postcode = $("#sample4_postcode");
		var sample4_roadAddress = $("#sample4_roadAddresss");
		var sample4_jibunAddress = $("#sample4_jibunAddress");
		var phone1 = $("#phone1");
		var phone2 = $("#phone2");
		var phone3 = $("#phone3");
		var email1 = $("#email1");
		var email2 = $("#email2");
		var email3 = $("#email3");
		
		//id 유효성
		$("#userid").on("keyup", function(){			
				
			if (!(userid.val() >= '0' && userid.val() <= '9') && !(userid.val() >= 'a' && userid.val() <= 'z')&& !(userid.val() >= 'A' && userid.val() <= 'Z')) {
				$("#result").text("아이디는 대소문자, 숫자만 입력가능합니다.")
			}else if (userid.val().indexOf(" ") >= 0) {
				$("#result").text("아이디에 공백을 사용할 수 없습니다.")
			}else if (check.test(userid.val())) {
				$("#result").text("아이디에 한글을 사용하실 수 없습니다")
			}else if (userid.val().length<6 || userid.val().length>12) {
				$("#result").text("아이디를 6~12자까지 입력해주세요.")			
			}else{
				$.ajax({
					type:"GET",
					url:"idCheck",
					dataType:"text", 
					data:{ 
						userid : $("#userid").val()
					},
					success:function(responseData,status,xhr){
						
						if($("#userid").val().length == 0 ){
							$("#result").text("");											
							
						}else{					
							$("#result").text(responseData);
						};
					}, 
					error:function(xhr,status,error){
						console.log(error);
					} 
				});
				}//ajax
		})
		//비밀번호 유효성
		//if문 타는 문제가 있으니 when 으로 바꿔볼 것
				//비밀번호 확인
				$("#passwd2").on("keyup", function() {
					var passwd = $("#passwd1").val();
					var passwd2 = $(this).val();						
				
			        if (passwd == passwd2) {
			        	$("#result2").text("비밀번호 일치")			            
			        }else if (passwd2.length == 0) {
						$("#result2").text("");
					}else{
			        	$("#result2").text("비밀번호 불일치")		
			        }	
			        
			        if (passwd.length<6 || document.f.passwd1.value.length>10) {			        	
			        	$("#result2").text("비밀번호를 6~10자까지 입력해주세요.")
			        }
				});

				//form submit
				$("form").on("submit", function(e) {					
									//공백일 때
									 if (userid.val() == "") {
										alert("아이디는 필수입력 사항입니다.");
										userid.focus();
										e.preventDefault();
									} else if (passwd1.val() == "") {
										alert("비밀번호는 필수입력 사항입니다.");
										passwd1.focus();
										e.preventDefault();
									} else if (passwd2.val() == "") {
										alert("비밀번호를 확인해주세요");
										passwd2.focus();
										e.preventDefault();
									} else if (username.val() == "") {
										alert("이름은 필수입력 사항입니다.");
										username.focus();
										e.preventDefault();
									} else if (sample4_postcode.val() == ""
											|| sample4_roadAddress.val() == ""
											|| sample4_jibunAddress.val() == "") {
										alert("주소는 필수입력 사항입니다.");
										sample4_postcode.focus();
										e.preventDefault();
									} else if (phone2.val() == ""
											|| phone3.val() == "") {
										alert("전화번호는 필수입력 사항입니다.");
										phone2.focus();
										e.preventDefault();
									} else if (email1.val() == ""
											|| email2.val() == ""
											|| email3.val() == "") {
										alert("이메일은 필수입력 사항입니다.");
										email1.focus();
										e.preventDefault();
									} else if($("#result2").text() != "비밀번호 일치" || $("#result").text() != "아이디 사용가능" ){
										alert("아이디나 비밀번호를 확인해 주세요.")
										e.preventDefault();
									} else if (f.passwd1.value == f.userid.value) {
							            alert("아이디와 비밀번호가 같습니다.")
							            document.f.passwd1.focus()
							            e.preventDefault();
							        }else
							        //비밀번호 길이 체크(4~8자 까지 허용)
							        if (document.f.passwd1.value.length<6 || document.f.passwd1.value.length>12) {
							            alert("비밀번호를 6~12자까지 입력해주세요.")
							            document.f.passwd1.focus()
							            document.f.passwd1.select()
							            e.preventDefault();
							        }
									
									//아이디 유효성 검사 (영문소문자, 숫자만 허용)
									
/* 									for (i = 0; i < document.f.userid.value.length; i++) {
										ch = document.f.userid.value.charAt(i)
								console.log(ch);
										if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')
												&& !(ch >= 'A' && ch <= 'Z')) {
											alert("아이디는 대소문자, 숫자만 입력가능합니다.")
											document.f.userid.focus()
											document.f.userid.select()
											e.preventDefault();
										}
									} 
									//아이디에 공백 사용하지 않기
								 	if (document.f.userid.value.indexOf(" ") >= 0) {
										alert("아이디에 공백을 사용할 수 없습니다.")
										document.f.userid.focus()
										document.f.userid.select()
										e.preventDefault();
									}else 
									//아이디 길이 체크 (4~12자)
									if (document.f.userid.value.length<6 || document.f.userid.value.length>12) {
										alert("아이디를 6~12자까지 입력해주세요.")
										document.f.userid.focus()
										document.f.userid.select()
										e.preventDefault();
									}else 
									if (f.passwd1.value == f.userid.value) {
							            alert("아이디와 비밀번호가 같습니다.")
							            document.f.passwd1.focus()
							            e.preventDefault();
							        }else
							        //비밀번호 길이 체크(4~8자 까지 허용)
							        if (document.f.passwd1.value.length<6 || document.f.passwd1.value.length>12) {
							            alert("비밀번호를 6~12자까지 입력해주세요.")
							            document.f.passwd1.focus()
							            document.f.passwd1.select()
							            e.preventDefault();
							        }
									*/
								})

				$("#email3").on("change", function() {
					$("#email2").val($(this).val());
				})
			})
</script>
<body oncopy="return false" oncut="return false" onpaste="return false">
<form action="memberAdd" method="post" name="f">
	<h1>REGISTER</h1>
	<div class="memberForm">
		<!-- <p class="tblInfo"><span>*</span> 필수입력</p> -->
		<table class="tbl">
			<colgroup>
				<col width="20%" />
				<col width="*" />
			</colgroup>
			<tr>
				<th><span class="required" title="필수 입력">아이디</span></th>
				<td><input type="text" name="userid" id="userid"> 
				<span id="result" class="small bold"></span></td>
			</tr>
			<tr>
				<th><span class="required" title="필수 입력">비밀번호</span></th>
				<td><input type="password" name="passwd" id="passwd1">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="passwd2" id="passwd2">
					<span id="result2" class="small bold"></span></td>
			</tr>
			<tr>
				<th><span class="required" title="필수 입력">이름</span></th>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<th><span class="required" title="필수 입력">주소</span></th>
				<td><input type="text" name="post" id="sample4_postcode"
					placeholder="우편번호"> <input type="button"
					onclick="sample4_execDaumPostcode()" class="btn gray small"
					value="우편번호 찾기"> <span class="address"> <input
						type="text" name="addr1" id="sample4_roadAddress"
						placeholder="도로명주소"> <input type="text" name="addr2"
						id="sample4_jibunAddress" placeholder="지번주소">
				</span></td>
			</tr>
			<tr>
				<th><span class="required" title="필수 입력">휴대폰</span></th>
				<td><select name="phone1" id="phone1">
						<option value="011">011</option>
						<option value="010" selected="selected">010</option>
				</select> <input type="text" name="phone2" id="phone2"> <input
					type="text" name="phone3" id="phone3"></td>
			</tr>
			<tr>
				<th><span class="required" title="필수 입력">이메일</span></th>
				<td><input type="text" name="email1" id="email1"> @ <input
					type="text" name="email2" id="email2" placeholder="직접입력"> <select
					name="email3" id="email3">
						<option value="daum.net">daum.net</option>
						<option value="naver.com" selected="selected">naver.com</option>
				</select></td>
			</tr>
		</table>
		<div class="btnGroup">
			<input type="submit" value="회원가입" class="btn yellow"> <input
				type="reset" value="취소" class="btn gray">
		</div>
	</div>
</form>
</body>

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
