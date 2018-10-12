<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.container {
	float:left;	
	overflow: hidden;
	width: 100%;
	height: 100%;
	/* margin: 100px auto; */
}
.content img {
	width: 100%;
}
.content_box {
	height: 100%;
	width: 200%;
}

.content {
	float: left;
	width: 50%;
	height: 100%;
	box-sizing: border-box;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		
		$(function(){    
		    var $move_width = parseInt( $('.content').css('width') );   // 이동할 수치 계산  
		    var $content_box = $('.content_box');                       // 컨텐츠 박스 변수저장
		     
		    // 루프 (순환)
		    function ani_1(){
		        animation()                         
		        setTimeout( ani_2, 5000 );     // 1000 + 10( 여유 ) 초 뒤, function ani_2() 로 이동 
		    };                                      
		    function ani_2(){
		        animation()
		        setTimeout( ani_1, 5000 );     // 1000 + 10( 여유 ) 초 뒤, function ani_1() 로 이동
		    };
		    ani_1();                                // function ani_1() 로 루프 start 
		      
		    // 로직
		    function animation(){
		        $content_box.children().first().stop()
		        .animate({ marginLeft : - $move_width }, 1000, "linear", function (){
		            $(this).appendTo( $(this).parent() ).css({ marginLeft : 0});
		        });     
		    }
		});
		
	})
</script>

<div class="container">
	<div class="content_box">
		<div class="content">
			 <img src="./images/banner_image.jpg" />
			 
			 
		</div>
		<div class="content">
			 <img src="./images/main2.jpg" />
			
		</div>
	</div>
</div>
