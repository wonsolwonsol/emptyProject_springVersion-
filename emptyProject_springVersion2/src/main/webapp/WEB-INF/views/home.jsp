<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
 <script type="text/javascript" src="js/jquery-3.1.0.js"></script>
</head>
<body>
	<c:if test="${!empty success}">
		<script type="text/javascript">
			alert("${success}");
			<%
			session.removeAttribute("success");
			%>
		</script>
	</c:if>
	
	<c:if test="${!empty mesg}">
		<script type="text/javascript">
			alert("${mesg}");
			<%
			session.removeAttribute("mesg");
			%>
		</script>
	</c:if>	
<h1>hellpo</h1>
<div class="wrap">
<div class="side"><jsp:include page="common/submenu.jsp" flush="true"/></div>

<div class="body">
	<div class="top"><jsp:include page="common/top.jsp" flush="true"/></div>
	<div class="contents"><jsp:include page="main.jsp" flush="true"/></div>
	
</div>
</div>
