<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산결과</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	float before = Float.parseFloat(request.getParameter("before"));
	float after = Float.parseFloat(request.getParameter("after"));
	String operator = request.getParameter("operator");

%>
<h2> 계산 결과 </h2>
<%=before+operator+after+"=" %>
<% 
  	float answer = 0;
	switch(operator){
	case"+":
		answer = before+after;
		break;
	
	case"-":
		answer = before-after;
		break;
	
	case"x":
		answer = before*after;
		break;
	
	case"÷":
		answer = before/after;
		break;
	}
	out.println(answer);
%>
</body>
</html>