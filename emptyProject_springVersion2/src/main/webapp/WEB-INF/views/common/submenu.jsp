<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="sidemenu">
	<h1><a href="home.jsp">logo</a></h1>
	<br>
	<ul id="side_category">
		<li><a href="GoodsAllServlet">ALL</a></li>
		<li><a href="GoodsListServlet?goods_Category=Bucket_Bags">BUCKET BAG</a><li>
		<li><a href="GoodsListServlet?goods_Category=Shoulder_Bags">SHOULDER BAG</a></li>
		<li><a href="GoodsListServlet?goods_Category=Clutch_Bags">CLUTCH BAGS</a></li>
		<li><a href="GoodsListServlet?goods_Category=Mini_Bags">MINI BAG</a></li>
	</ul>
	<br>
	<ul id="side_board">
		<li><a href="NoticeServlet">NOTICE</a></li>
		<li><a href="QuestionBoardServlet">Q N A</a></li>
		<li><a href="">REVIEW</a></li>
	</ul>
	<br>
	<ul id="side_sns">
		<li><a href=""><img src="images/icon/twitter.png"></a></li>
		<li><a href=""><img src="images/icon/instagram.png"></a></li>
	</ul>
</div>