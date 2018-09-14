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
		
		//삭제
		$(".delBtn").on("click", function(){
			var txt = confirm("삭제하시겠습니까?");
			var num = $(this).attr("data-delBtn");
			if(txt==true){
				location.href="AdminGoodsDelServlet?goods_Code="+num;
			}
		});
		
		//수정
		$(".updateBtn").on("click", function(){
			var num = $(this).attr("data-updateBtn");
			location.href="AdminGoodsUpdateUIServlet?goods_Code="+num;
			
		});
		
		//delAll
		$("#delAll").on("click",function(e){
			var txt = confirm("삭제하시겠습니까?");
			if(txt==true){
				$("form").attr("action","AdminGoodsDelAllServlet");
				$("form").submit();				
			}else{
			e.preventDefault();				
			}
		})//
		
	})
</script>
<style type="text/css">
	.aLink {color:#333;text-decoration:none;}
	.aLink:hover {text-decoration:underline;}
</style>
<form name="myForm" method="post">   
	<h1>ADMIN</h1>
	<table class="tblList">
		<colgroup>
			<col style="width:12%">
			<col style="width:10%">
			<col style="width:*">
			<col style="width:30%">
			<col style="width:10%">
			<col style="width:10%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" name="check" id="allCheck"><label for="allCheck">전체 선택</label></th>
				<th>제품번호</th>
				<th colspan="3">상품정보</th>
				<th>판매가</th>				
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${pageDto.getList()}">
			<tr>
				<td><input type="checkbox" name="check" class="check" value="${dto.goods_Code}"></td>
				<td>${dto.goods_Code}</td>
				<td>
					<span class="img"><a href="" class="aLink"><img src="images/items/thum/${dto.goods_Image1}.jpg" /></a></span>
				</td>
				<td>
					<p class="bold"><a href="" class="aLink">${dto.goods_Brand}</a></p>
					<p class="alignL"><a href="" class="aLink">${dto.goods_Name}</a></p>
				</td>
				<td>
					${dto.goods_Color}	
				</td>
				<td>
					<fmt:formatNumber value="${dto.goods_Price}" type="currency" />
				</td>				
				<td>
					<span class="btns">
						<input type="button" class="btn xsmall yellow updateBtn" data-updateBtn="${dto.goods_Code}" value="수정" />
						<input type="button" class="btn xsmall darkGray delBtn" data-delBtn="${dto.goods_Code}" value="삭제" />
					</span>
				</td>
			</tr>
		</c:forEach>
			<tr>
			<input type="text" name="currentPage" value="${pageDto.getCurrentPage()}">
			</tr>
		</tbody>
	</table>	

<div class="btnGroup">
	<a class="btn yellow" href="adminAddGoodsPage.jsp">제품등록</a>
	<button class="btn darkGray" id="delAll">선택 삭제하기</button>
</div>
</form>



