<%@page import="com.dto.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.hover-container {
    position: relative;    
}

.hover-cart {
  opacity: 1;
  display: block;  
  height: auto;
  transition: .5s ease;
  backface-visibility: hidden;
}

.cover {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

.hover-container:hover .hover-cart {
  opacity: 0.5;
}

.hover-container:hover .cover {
  opacity: 1;
}

.cover-btn  {  
	border: none;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 24px;
    width: 50px;
    height: 50px;
    border-radius: 50%;
    cursor: pointer;
}

</style>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#sortSelect").on("change",function(event){
			$("#sortSelectForm").attr("action","goodsSortPrice");
			$("#sortSelectForm").submit();			   
			//event.preventDefault();
		})	
		
		$(".sortBox > button").on("click", function(){
			$(".box").stop().slideToggle("300");
		})
		
		//directCart
		$(".cover-btn").on("click", function(){	
			var num = $(this).attr("data-code");
			var cate =  $("#cate").val();			
			var curpage = $("#curpage").val();
			console.log(this);
			console.log(num);
			$.ajax({ 
				type:"get",
				url:"loginCheck/goodsDirectCart",
				dataType:"text", 
				data:{
					goods_Category:cate,
					currentPage:curpage,
					goods_Code:num
				},
				success:function(data,status,xhr){		
					//세션에 유저가 없으면 error로 가는 게 아니라 전체 스크립트가 오네
					//한글 깨짐 문제 수정할 것
					 alert(data);
				}, 
				error:function(xhr,status,error){
					console.log(error);
					console.log("에러")
				}
			})
		})
		
		
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
				paging = paging+"<a href='/app/goodslist?goods_Category="+$("#cate").val()+"&currentPage="+i+"'>"+i+"</a>&nbsp;&nbsp;";  
			}			
		}
		$("p").html(paging);
})
</script>
<!-- <div class="adsense" style="text-align: center; padding:0px 0px 10px 10px">  -->

<div class="select" >
<form method="get" id="sortSelectForm">
<input type="hidden" value="${category}" name="category" id="cate">
	<select name="sortSelect" id="sortSelect">
		<option selected="selected">선택없음</option>
		<option value="가격순">가격순</option>
		<option value="가격역순">가격역순</option>
	</select>
</form>	
</div>
<form action="goodsSortColorBrand" method="get">
<input type="hidden" value="${category}" name="category" id="cate">
<div class="sortBox">
	<button type="button">sort</button>
	<div class="box">
		<div>
			색상 : 
<c:forEach var="clr" items="${colorChart}" varStatus="status">
			<span><input type="checkbox" id="check1" name="color" value="${clr}"> <label for="check1">${clr}</label></span>
</c:forEach>		
		</div>
		
		<div>
			브랜드 :
<c:forEach var="bnd" items="${brandChart}" varStatus="status">
			<span><input type="checkbox" id="check4" name="brand" value="${bnd}"> <label for="check4">${bnd}</label></span>
</c:forEach>				
		</div>
		<button type="submit" class="btn gray small">버튼</button>
	</div>
</div>
</form>



<hr>
<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="100%" cellspacing="0" cellpadding="0" border="0" >		
				<tr>				
    <c:forEach var="dto" items="${page.list}" varStatus="status">
    <input type="hidden" value="${dto.goods_Code}" id="code">
						<td width="20%">
							<table style='padding:15px' class="fontSmall">
								<tr>
									<td align="center" class="hover-container">

										<a href="goodsRetrieve?goods_Code=${dto.goods_Code}" >
											<img src="images/items/thum/${dto.goods_Image1}.jpg" border="0" align="center" width="200" class="hover-cart">
										</a>
										<div class="cover">
											<%-- <a href="loginCheck/goodsDirectCart?goods_Code=${dto.goods_Code}"> --%>
											<button class="darkgray cover-btn" data-code="${dto.goods_Code}" >+</button>
										</div>
									</td>
								</tr>
								<tr>
								<td class= "td_default" align ="center">
								<br>
										<a class= "a_black bold aLink">
										${dto.goods_Brand}<br>
										</a>
										<font color="gray">
										 <br>
										</font>
									</td>
									<td height="10">
								</tr>
								<tr>
									<td class= "td_default" align ="center">
										<a class= "a_black aLink" href="goodsRetrieve?goods_Code=${dto.goods_Code}"> 
										${dto.goods_Name}<br>
										</a>
										<font color="gray">
										 <br>
										</font>
									</td>
									
								</tr>
								<br>
								<tr>
								
									
								</tr>

								<tr>
									<td class="td_gray" align ="center">
										${dto.goods_Content}
									</td>
								</tr>
								<tr>
									<td height="10">
								</tr>
								<tr>
									<td class="td_red" align ="center"><font color="gray"><strong>
									
					<fmt:formatNumber value="${dto.goods_Price}" type="currency"> </fmt:formatNumber>				
					<%-- ${dto.goods_Price} --%>
										</strong></font></td>
								</tr>
							</table>
						</td>

  					<c:if test="${(status.index+1)%4==0 }">
						     <tr>
								<td height="10">
							</tr>
                  </c:if>
</c:forEach>
			</table>
		</td>
	</tr>
	<tr>
		<td height="10">
	</tr>
</table>
<hr>
<input type="hidden" value="${page.totalCount}" id="totalCount">
<input type="hidden" value="${page.currentPage}" id="curpage">
<p class="page"></p>

