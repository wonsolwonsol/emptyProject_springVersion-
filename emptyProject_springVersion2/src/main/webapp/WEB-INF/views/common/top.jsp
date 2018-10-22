<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>        
<script type="text/javascript">
$(document).ready(function(){
 	$(".toggle").click(function(){
        $("#search").stop().animate({
        	width: 'toggle'        
        });
    });//
		
	$("#search").on("keypress",function(e){
		if (e.which == 13) {
			$("form").attr("action","goodsSearch");
			$(this).submit();
		}
	})// 
	
	
		
})

</script>
<div class="topmenu">
	<ul>
		<li>
	<form>
		<input type="text" name="search" id="search" placeholder="search..."  style="margin-bottom: 14px">
		<img src="./images/icon/search.png" class="toggle">
	</form>
		</li>
		<li><a href=loginCheck/cartlist><img src="images/icon/cart.png"></a></li>
<c:if test="${empty member}">
		<li><a href="loginForm"><img src="images/icon/users.png"></a></li>
</c:if>
<c:if test="${!empty member}">
	<c:if test="${member.userid eq 'admin'}">
		<li><a href="adminCheck/adminGoods?currentPage=1"><img src="images/icon/admin.png"></a></li>
	</c:if>
		<li><a href="loginCheck/mypage"><img src="images/icon/user.png"></a></li>
		<li><a href="loginCheck/logout"><img src="images/icon/logout.png"></a></li>
</c:if> 
	</ul>
</div>