<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<style>
	.btnGroup{
		background-color: #fff;
		margin-top: 0px;
		margin-bottom: 0px;
	}

</style>       
<script type="text/javascript">
$(document).ready(function(){
	$('button').on('click', function(){
	    $('button').removeClass('yellow');
	    $('button').addClass('gray');
		$(this).removeClass('gray');
	    $(this).addClass('yellow');
	});
	
	$("#adminGoods").on("click", function(){
		location.href="adminCheck/adminGoods?currentPage=1"
	})
	$("#adminMember").on("click", function(){
		location.href="adminCheck/adminMember?currentPage=1"
	})
})
</script>
<div class="btnGroup">

	<button class="btn gray" id="adminGoods">상품관리</button>
	<button class="btn gray" id="adminMember">회원관리</button>	
</div>