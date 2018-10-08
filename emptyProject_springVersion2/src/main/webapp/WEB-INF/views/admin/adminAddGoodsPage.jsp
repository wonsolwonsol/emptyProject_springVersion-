<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="css/common.css" />  
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
<script type="text/javascript">
	var sel_files = [];
	
	$(document).ready(function() {
	    $("#input_imgs").on("change", handleImgsFilesSelect);
	
	function handleImgsFilesSelect(e) {
	    var files = e.target.files;
	    var filesArr = Array.prototype.slice.call(files);
		console.log(files);
		console.log(filesArr);
	    filesArr.forEach(function(f) {
	        if(!f.type.match("image.*")) {
	            alert("확장자는 이미지 확장자만 가능합니다.");
	            return;
	        }	
	        sel_files.push(f);
	        
	        var reader = new FileReader();
	        reader.onload = function(e) {
	            var img_html = "<p><img src=\"" + e.target.result + "\" /></p>";	           
	            $(".imgs_wrap").append(img_html);
	        }	        	
	        	var goods_Image = "<input type='hidden' name='goods_Image' value='"+f.name+"'>";
	          $(".goods_Image").append("<p>"+f.name+"</p>");
	          $("#hidden").append(goods_Image);
	          console.log($("#hidden").html())
	        reader.readAsDataURL(f);
	    })
	}
	
	//
 	$("#submit").click(function(e){
        var goods_Code = $("#goods_Code").val();
        var goods_Category = $("#goods_Category").val();
        var goods_Brand = $("#goods_Brand").val();
        var goods_Name = $("#goods_Name").val();
        var goods_Content = $("#goods_Content").val();
        var goods_Color = $("#goods_Color").val();
        var goods_Price = $("#goods_Price").val();
        console.log(goods_Code);
        // 상품 수정 폼 유효성 검사
        if(goods_Code == "") {
            alert("상품명을 입력해주세요");
            goods_Code.foucs();
            e.preventDefault();
        } else if (goods_Price == "") {
            alert("상품 가격을 입력해주세요");
            goods_Price.focus();
            e.preventDefault();
        } else if (goods_Content == "") {
            alert("상품 설명을 입력해주세요");
            goods_Content.focus();
            e.preventDefault();
        } else if (goods_Category == "") {
            alert("상품 분류를 입력해주세요");
            goods_Category.focus();
            e.preventDefault();
        } else if (goods_Brand == "") {
            alert("상품 브랜드를 입력해주세요");
            goods_Brand.focus();
            e.preventDefault();
        } else if (goods_Name == "") {
            alert("상품 이름을 입력해주세요");
            goods_Name.focus();
            e.preventDefault();
        } else if (goods_Color == "") {
            alert("상품 컬러를 입력해주세요");
            goods_Color.focus();
            e.preventDefault();
        }     
        
    }); 
});
</script>
<form name="myForm" method="post" enctype="multipart/form-data" action="adminCheck/adminGoodsAdd">   
<p id="hidden"></p>
	<h1>상품등록</h1>
	<span>
    	<div>
        	<div class="imgs_wrap">            
        	</div>
   		</div>
		<div>        
        	<input type="file" id="input_imgs" multiple name="goods_file" />
    	</div> 
	</span>
	<span class="table">
	<table class="tbl" border="1px">
			<tr>			
				<th>상품번호</th>
				<td><input type="text" name="goods_Code"></td>
			</tr>
			<tr>			
				<th>이미지 파일</th>
				<td name="goods_Image" class="goods_Image"></td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td><input type="text" name="goods_Category"></td>
			</tr>
			<tr>
				<th>브랜드</th>	
				<td><p><input type="text" name="goods_Brand"></p>
			</tr>
			<tr>
				<th>상품이름</th>
				<td><input type="text" name="goods_Name"></td>
			</tr>
			<tr>
				<th>상품정보</th>
				<td><input type="text" name="goods_Content"></td>
			</tr>
			<tr>
				<th>색상</th>
				<td><input type="text" name="goods_Color"></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="goods_Price"></td>
			</tr>

	</table>	
	</span>
<div class="btnGroup">
	<input type="submit" id="submit" class="btn yellow" value="제품등록"></a>
</div>
</form>



