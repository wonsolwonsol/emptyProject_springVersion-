<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
	$(document).ready(function(){ 
		 //all check
		$("#allCheck").on("click", function(){
			var result = this.checked;
			$(".check").each(function(idx,data){
				this.checked = result;
			})
		})//
		
		$(".delBtn").on("click", function() {
			var txt = confirm("삭제하시겠습니까?");
			var num = $(this).attr("data-delBtn");
			var xxx = $(this);
			console.log(xxx);
			if(txt==true){
				$.ajax({
					url : 'adminCheck/adminMemberDelete',
					type : "get",
					dataType : 'text',
					data : {
						userid:num
					},
					success : function(data, status, xhr) {
						if (data == 'success') {
							console.log(data);
							xxx.parents().filter("tr").remove();							
						}
	
					},
					error : function(xhr, status, error) {						
						console.log(error);
					}
				});
			}else{
				e.preventDefault();			
			}

		});
		
		
		//delAll
		$("#delAll").on("click",function(e){
			var txt = confirm("삭제하시겠습니까?");
			if(txt==true){
				$("form").attr("action","adminCheck/adminMemberDeleteAll");
				$("form").submit();				
			}else{
			e.preventDefault();				
			}
		})// 
		
		//충격과 공포의 페이징
		var record = $("#totalCount").val()
		var total = record/8;
		if(record%8 !=0) total=Math.ceil(total);
		var curpage = $("#curpage").val();
		var paging = "";
		
		for(var i = 1; i <= total; i++){
			if(i==curpage){
				paging = paging+i+"&nbsp;&nbsp;";
				
			}else{
				paging = paging+"<a href='/app/adminCheck/adminMember?currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;";  
			}			
		}
		$(".page").html(paging);
		
	})
</script>

<form name="myForm" method="get">   
		<h1>ADMIN MEMBER</h1>	
	<table class="tblList">
		<colgroup>
			<col style="width:12%">
			<col style="width:10%">
			<col style="width:10%">
			<col style="width:*">			
			<col style="width:15%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" name="check" id="allCheck"><label for="allCheck">전체 선택</label></th>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
				<th>전화번호</th>
				<th>이메일</th>						
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${page.getList()}">
			<tr>
				<td><input type="checkbox" name="check" class="check" value="${dto.userid}"></td>
				<td>${dto.userid}</td>				
				<td>
					${dto.username}					
				</td>
				<td>
					<p>${dto.post}<br>
					${dto.addr1}<br>
					${dto.addr2}<br></p>	
				</td>
				<td>
					${dto.phone1}&nbsp;
					${dto.phone2}&nbsp;
					${dto.phone3}
				</td>		
				<td>
				${dto.email1}@${dto.email2}
				</td>						
				<td>					
						<%-- <input type="button" class="btn xsmall yellow updateBtn" data-updateBtn="${dto.userid}" value="수정" /> --%>
						<input type="button" class="btn xsmall yellow delBtn" data-delBtn="${dto.userid}" value="삭제" />
					
				</td>
			</tr>
		</c:forEach>
			<tr>
			
			</tr>
		</tbody>
	</table>	
	<input type="hidden" value="${page.totalCount}" id="totalCount">
	<input type="hidden" value="${page.currentPage}" id="curpage">
	<p class="page"></p>
<hr>
<div class="btnGroup">
	<!-- <a class="btn yellow" href="adminAddGoodsPage">제품등록</a> -->
	<button class="btn darkGray" id="delAll">선택 삭제하기</button>
</div>
</form>



