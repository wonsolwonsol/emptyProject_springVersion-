<%@page import="com.dto.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#sortSelect").on("change",function(event){
			$("#sortSelectForm").attr("action","GoodsSortPriceServlet");
			$("#sortSelectForm").submit();			   
			//event.preventDefault();
		})	
		
		$(".sortBox > button").on("click", function(){
			$(".box").stop().slideToggle("300");
		})
})
</script>
<div class="adsense" style="text-align: center; padding:0px 0px 10px 10px"> 

<div class="select" >
<form method="get" id="sortSelectForm">
<input type="hidden" value="${category}" name="category">
	<select name="sortSelect" id="sortSelect">
		<option selected="selected">선택없음</option>
		<option value="가격순">가격순</option>
		<option value="가격역순">가격역순</option>
	</select>
</form>	
</div>
<form action="GoodsSortColorBrand" method="post">
<input type="hidden" value="${category}" name="category">
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




<table width="100%" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table align="center" width="710" cellspacing="0" cellpadding="0"
				border="0">
				
				<tr>
					<td height="5"></td>
				</tr>
				<tr>
					<td height="1" colspan="8" bgcolor="CECECE"></td>
				</tr>
				<tr>
					<td height="10"></td>
				</tr>
				<tr>
				
    <c:forEach var="dto" items="${goodsList}" varStatus="status">
						<td>
							<table style='padding:15px'>
								<tr>
									<td>

										<a href="GoodsRetrieveServlet?goods_Code=${dto.goods_Code}"> 

											<img src="images/items/thum/${dto.goods_Image1}.jpg" border="0" align="center" width="200">
										</a>
									</td>
								</tr>
								<tr>
								<td class= "td_default" align ="center">
										<a class= "a_black">
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
										<a class= "a_black" href="GoodsRetrieveServlet?goods_Code=${dto.goods_Code}"> 
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
									<td height="10">
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
									<td class="td_red" align ="center"><font color="red"><strong>
									
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
