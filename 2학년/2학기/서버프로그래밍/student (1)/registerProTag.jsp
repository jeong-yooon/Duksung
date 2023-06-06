<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>가입 처리</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="student" class="advisor.StudentBean">
	<jsp:setProperty name="student" property="*"/>
</jsp:useBean>
<%
out.println("학생 객체의 주소값 = " + student);
out.println("<h3>학생 정보는 " + student.printStudent() + "입니다</h3>");
%>

<%-- include 테스트 --%>
<%--
<jsp:include page="included.jsp"/>
--%>

<%-- forward 테스트  --%>
<%--
<jsp:forward page="forwarded.jsp">
  <jsp:param name="prof" value="음두헌"/>
</jsp:forward>
--%>

<%-- redirect 테스트 --%>
<%--
<%  response.sendRedirect("forwarded.jsp");%>
--%>

</body>
</html>