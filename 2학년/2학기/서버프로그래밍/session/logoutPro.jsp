<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>로그아웃</title>
</head>
<body>
<%
String id = (String)session.getAttribute("okid");
session.removeAttribute("okid");
%>
<%= id %>님 로그아웃!
</body>
</html>