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
<%!
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int count = 0;
%>
<% 
  	float answer = 0;
	count++;
	switch(operator){
	case"+":
		answer = before+after;
		a++;
		
		break;
	
	case"-":
		answer = before-after;
		b++;
		break;
	
	case"x":
		answer = before*after;
		c++;
		break;
	
	case"÷":
		answer = before/after;
		d++;
		break;
	}
	out.println(answer + "</br>");
	out.println("</br>");
	out.println("덧셈 총횟수 : " + a + "</br>");
	out.println("뺄셈 총횟수 : " + b + "</br>");
	out.println("곱셈 총횟수 : " + c + "</br>");
	out.println("나눗셈 총횟수 : " + d + "</br>");
	out.println("</br>");
	out.println("총 연산 횟수 : " + count + "</br>");
%>
</body>
</html>