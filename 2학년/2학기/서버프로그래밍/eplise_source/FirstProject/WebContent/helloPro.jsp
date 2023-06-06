<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>환영 메시지</title>
</head>
<body>
<h3>나는 최정윤입니다~</h3>
<h2>서버가 처리한 결과입니다...</h2>
<%
		request.setCharacterEncoding("UTF-8");	// request: 요청 전담 객체
		String name = request.getParameter("nm"); 
		if(name.equals("최정윤")) {
				out.println("<h3>Hello 주인님~</h3>");
		} else {
			out.println("<h3>Hello " + name + "~</h3>");
		}
%>	<!-- jsp의 스크립트릿 -->
</body>
</html>