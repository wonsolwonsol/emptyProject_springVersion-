<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <style type="text/css">
        .imgs_wrap {
        	float:left;
            width: 20%;
            margin: 10px;
        }
        .imgs_wrap img {
            max-width: 200px;
        }
        
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>   
<script type="text/javascript">
	var sel_files = [];
	
	$(document).ready(function() {
	    $("#input_imgs").on("change", handleImgsFilesSelect);
	
	function handleImgsFilesSelect(e) {
	    var files = e.target.files;
	    var filesArr = Array.prototype.slice.call(files);
	    console.log(filesArr);
	//    filesArr.forEach(function(f) {
	 for(var i=0; i< filesArr.length; i++){
		  
	       var f = filesArr[i];
	    	console.log(">>",f);
	        if(!f.type.match("image.*")) {
	            alert("확장자는 이미지 확장자만 가능합니다.");
	            return;
	        }
	
	        sel_files.push(f);
	        
	        var reader = new FileReader();
	        reader.onload = function(e) {
	            var img_html = "<p><img src=\"" + e.target.result + "\" /></p>";	           
	            $(".imgs_wrap").prepend(img_html);
	        }
	        	
	        	var goods_Image = "<input type='hidden' name='goods_Image"+(i+1)+"' value='"+f.name+"'>";
	        	console.log(f.name);
	          $(".goods_Image").prepend("<p>"+f.name+"</p>");
	          $("#hidden").append(goods_Image);
	          console.log($("#hidden").html())
	        reader.readAsDataURL(f);
	    //})
	  }

	    
	}
	});
</script>
<form name="myForm" method="post" enctype="multipart/form-data" action="adminCheck/adminGoodsUpdate">   
<p id="hidden">
	<input type="hidden" name="goods_Code" value="${goods.goods_Code}">	
</p>
	
	
	<h1>상품수정</h1>
	<span>
    	<div>
        	
   		</div>
		<div>        
        	
    	</div> 
	</span>
	<span class="table">
	<table class="tbl" border="1px">
			<tr>			
				<th>상품번호</th>
				<td>${goods.goods_Code}</td>				
			</tr>
			<tr>			
				<th>이미지 파일</th>
				<td>
				<div class="imgs_wrap goods_Image">
				<input type="file" id="input_imgs" multiple name="theFile" />
				</div>
				</td>				
			</tr>
			<tr>
				<th>카테고리</th>
				<td><input type="text" name="goods_Category" value="${goods.goods_Category}"></td>
			</tr>
			<tr>
				<th>브랜드</th>	
				<td><p><input type="text" name="goods_Brand" value="${goods.goods_Brand}"></p>
			</tr>
			<tr>
				<th>상품이름</th>
				<td><input type="text" name="goods_Name" value="${goods.goods_Name}"></td>
			</tr>
			<tr>
				<th>상품정보</th>
				<td><input type="text" name="goods_Content" value="${goods.goods_Content}"></td>
			</tr>
			<tr>
				<th>색상</th>
				<td><input type="text" name="goods_Color" value="${goods.goods_Color}"></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="goods_Price" value="${goods.goods_Price}"></td>
			</tr>

	</table>	
	</span>
<div class="btnGroup">
	<input type="submit" class="btn yellow" value="제품수정"></a>
	<button type="reset" class="btn darkGray">취소</button>
</div>
</form>



