<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환영메시지</title>
</head>
<body>
<%
		request.setCharacterEncoding("UTF-8");	// request: 요청 전담 객체
		String name = request.getParameter("nm");
		String password = request.getParameter("pw");
		//int password = Integer.parseInt(request.getParameter("pw"));
		if(name.equals("최정윤") && password.equals("1234")) {
				out.println("<h3>환영합니다 최정윤님.</h3>");
		}
		else if(name.equals("최정윤")) {
			out.println("<h3>암호가 틀립니다.</h3>");
		}
		else{
			out.println("<h3>회원이 아닙니다.</h3>");
		}
%>	<!-- jsp의 스크립트릿 -->
</body>
</html>