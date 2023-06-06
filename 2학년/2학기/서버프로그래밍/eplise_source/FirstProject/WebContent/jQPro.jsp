<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
로딩영역 내에 표시됩니다.
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String sid = request.getParameter("sid");
%>
<h4> 학생 정보 입력 결과 </h4>
    이름 :  <%=name%><p>
    학번: <%=sid%><p>
</body>
</html>