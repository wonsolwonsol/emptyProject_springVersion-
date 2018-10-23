 <%@page import="com.dto.Question"%>
<%@page import="com.dao.QuestionDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">
$(function(){
         var now = new Date(); //현재 날짜 가져오기
         var year = now.getFullYear(); //현재 년도 가져오기
         var month = now.getMonth(); // 현재 월 가져오기
         var day = now.getDate(); //현재 일 가져오기
         var hour = now.getHours(); //현재 시간 가져오기
         var minute = now.getMinutes(); //현재 분 가져오기
         var today = new Date(year,month,day); //오늘 날짜 시간제외
         var yesterday = new Date(year,month,day - 1); //어제 날짜 시간제외
         var desterday = new Date(year,month,day - 2); //그저께 날짜 시간제외
             var regdate = document.getElementById   ("regdate");
         regdate.innerHTML = year+"/"+month+"/"+day+" "+hour+":"+minute;
        });
function doOpenCheck(chk){
    var obj = document.getElementsByName("term");
    for(var i=0; i<obj.length; i++){
        if(obj[i] != chk){
            obj[i].checked = false;
        }
    }
}
</script>
<h1>Question Retrieve</h1>
<form  name="myForm" method="post" action="reviewUpdateSubmit" enctype="multipart/form-data">
<table class="tbl">
<tr>
       <th>공개여부</th>
       <td>
       <input type="checkbox" name="term" value="y" checked="checked" onclick="doOpenCheck(this);">공개&nbsp;
       <input type="checkbox" name="term" value="n" onclick="doOpenCheck(this);">비공개 <br>
       선택하지 않는 경우 자동으로 공개처리 됩니다. 
       </td>
</tr>
<tr>
	<th>글번호</th>
	<td>${reviewUpdate.review_number }
	<input type="hidden" name="review_number" value="${reviewUpdate.review_number }" id="review_number">
	</td>
	
</tr>
<tr>
       <th width="20%">작성일</th>
       <td id="regdate"></td>
       <input type="hidden" id="regdate" name="regdate" value="sysdate">
</tr>
<tr>
       <th width="20%">제목</th>
       <td><input type="text" name="title" id="title" value="${reviewUpdate.title}"></td>
       <td width="10%"></td>
</tr>
<tr>
       <th width="20%">작성자</th>
       <td>
       <c:if test="${!empty member }">
       <input type="text" readonly value="${member.userid }" name="author">
       </c:if>
       <c:if test="${empty member }">
       	로그인이 필요한 작업입니다.
       </c:if>
       </td>
       
       <td width="10%"></td>
</tr>
<tr>
       <th width="0%">내용</th>
       <td width="90%"><input type="text" id="content" name="content" value="${reviewUpdate.content}" width="90%"
       cols="30" rows="5"
       ></td>
</tr>
<tr>
       <th>첨부파일</th>
       <td>
       <div class="imgs_wrap goods_Image">
       <input type="file" id="input_imgs" multiple name="theFile">
       </div></td>
</tr>
</table>
<br>
<div align="center">
<button type="sumbit" class="btn yellow">등록하기</button>
<button type="reset" class="btn darkGray">취소하기</button></div>
</form>
<br>
<script type="text/javascript">
       var sel_files = [];
       
       $(document).ready(function() {
           $("#input_imgs").on("change", handleImgsFilesSelect);
       
       function handleImgsFilesSelect(e) {
           var files = e.target.files;
           var filesArr = Array.prototype.slice.call(files);
             console.log(files);
             console.log(filesArr);
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
                          
                          var image_name = "<input type='hidden' name='image_name"+(i+1)+"' value='"+f.name+"'>";
                          console.log(f.name);
                       $(".goods_Image").prepend("<p>"+f.name+"</p>");
                       $("#hidden").append(goods_Image);
                       console.log($("#hidden").html())
                     reader.readAsDataURL(f);
                       console.log(image_name);
                 //})
               } } } )
       
</script>
</body>
</html>