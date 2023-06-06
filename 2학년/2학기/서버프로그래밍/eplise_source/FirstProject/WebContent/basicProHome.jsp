<%@ page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>JSP 기본 문법</title>
</head>
<body>
<%
int count;
if(session.getAttribute("count") != null) {
	
	count = ((Integer)session.getAttribute("count")).intValue();	
}
else {
	
	count = 0;	
}

count++;
%>

<%
session.setAttribute("count", new Integer(count));
%>
<h2><%=count %> 번째 접속 </h2>
<%!
	int number = 0;
%>
<%
		request.setCharacterEncoding("UTF-8");	// request: 요청 전담 객체
		String name = request.getParameter("nm");
		String password = request.getParameter("pw");
		if(name.equals("최정윤") && password.equals("1234")) {
				out.println("<h2>환영합니다 최정윤님.</h2>");
				number++;
				out.write(number + "번째 방문");
			
		}
		else if(name.equals("최정윤")) {
			out.println("<h2>암호가 틀립니다.</h2>");
		}
		else{
			out.println("<h2>회원이 아닙니다.</h2>");
		}
%>	<!-- jsp의 스크립트릿 -->
</body>
</html>