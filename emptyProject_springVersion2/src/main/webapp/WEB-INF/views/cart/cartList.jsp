<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){ 
		//all check
		$("#allCheck").on("click", function(){
			var result = this.checked;
			$(".check").each(function(idx,data){
				this.checked = result;
			})
		})
		
		//삭제버튼
		$(".delBtn").on("click", function(){
			var txt = confirm("삭제하시겠습니까?");
			var num = $(this).attr("data-delBtn");
			if(txt=true)
			location.href="goodsCartDel?num="+num;
		});
		
		//수정버튼
		$(".updateBtn").on("click", function(){
			var num = $(this).attr("data-num");
			var gAmount = $("#cartAmount"+num).val();
			var gPrice = $(this).attr("data-price");
			var total;
			$.ajax({ 
				type:"get",
				url:"GoodsCartUpdateServlet",
				dataType:"text", 
				data:{ 
					num:num,
					gAmount:gAmount
				},
				success:function(data,status,xhr){
					if(data=='success'){
						total = Number.parseInt(gAmount) * Number.parseInt(gPrice);
						var txt = "￦"+numeral( total ).format('0,0');
						$("#sum"+num).text(txt);
					}else{
						alert("로그인 하세요.");
						location.href="LoginUIServlet";
					}
				}, 
				error:function(xhr,status,error){
					console.log(error); 
				}
			}); 
		})
		
		//전체 삭제
		$("#delAllCart").on("click", function(e){
			var txt = confirm("삭제하시겠습니까?");
			if(txt==true){
			$("form").attr("action", "GoodsCartAllDelServlet");
			$("form").submit();
			}else{
			e.preventDefault();				
			}
		})
		
		//orderAll
		$("#orderAll").on("click", function(e){
			$("form").attr("action", "GoodsCartToOrderAll");
			$("form").submit();			
		})
		
		//order
		$(".orderBtn").on("click",function(){
			var num = $(this).attr("data-orderBtn");
			location.href="GoodsCartToOrder?num="+num;
		})
	})
</script>

<form name="myForm" method="post">   
	<input type="hidden" name="num" value="">
	<input type="hidden" name="image" value="">
	<input type="hidden" name="name" value="">
	<input type="hidden" name="size" value="">
	<input type="hidden" name="color" value=""> 
	<input type="hidden" name="price" value="">
	
	<h1>장바구니</h1>
	<table class="tblList">
		<colgroup>
			<col style="width:12%">
			<col style="width:10%">
			<col style="width:10">
			<col style="width:*">
			<col style="width:10%">
			<col style="width:12%">
			<col style="width:10%">
			<col style="width:15%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" name="allCheck" id="allCheck"><label for="allCheck">전체 선택</label></th>
				<th>주문번호</th>
				<th colspan="2">상품정보</th>
				<th>판매가</th>
				<th>수량</th>
				<th>합계</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="cart" items="${cartList}">
		<input type="hidden" name="num" value="${cart.num}">
			<tr>
				<td><input type="checkbox" name="check" class="check" value="${cart.num}"></td>
				<td>${cart.num}</td>
				<td>					
					<p class="img"><a href="GoodsRetrieveServlet?goods_Code=${cart.goods_Code}" class="aLink"><img src="images/items/thum/${cart.goods_Image}.jpg" /></a></p>
				</td>
				<td>
					<p class="bold"><a href="GoodsRetrieveServlet?goods_Code=${cart.goods_Code}" class="aLink">${cart.goods_Brand}</a></p>
					<p class="alignL"><a href="GoodsRetrieveServlet?goods_Code=${cart.goods_Code}" class="aLink">${cart.goods_Name}</a></p>
				</td>
				<td>
					<fmt:formatNumber value="${cart.goods_Price}" type="currency" />
				</td>
				<td>
					<input class="alignR" type="text" name="cart_gAmount" value="${cart.goods_Amount}" id="cartAmount${cart.num}" maxlength="3" style="width:50px;">
					<input type="button" class="btn xsmall updateBtn" value="수정" data-num="${cart.num}" data-price="${cart.goods_Price}" /> 
				</td>
				<td>
					<span id="sum${cart.num}"><fmt:formatNumber value="${cart.goods_Amount * cart.goods_Price}" type="currency" /></span>
				</td>
				<td>
					<span class="btns">
						<input type="button" class="btn xsmall yellow orderBtn" id="order" data-orderBtn="${cart.num}" value="주문" />
						<input type="button" class="btn xsmall darkGray delBtn" data-delBtn="${cart.num}" value="삭제" />
					</span>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
</form>

<div class="btnGroup">
	<a class="btn yellow" id="orderAll">전체 주문하기</a>
	<a class="btn darkGray" href="#" id="delAllCart">전체 삭제하기</a>
	<a class="btn gray" href="home.jsp">계속 쇼핑하기</a>
</div>

