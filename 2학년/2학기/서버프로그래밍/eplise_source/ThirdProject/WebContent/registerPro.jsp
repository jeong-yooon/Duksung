<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="advisor.StudentBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>가입 처리</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
int snum = Integer.parseInt(request.getParameter("snum"));
String name = request.getParameter("name");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String phone = request.getParameter("phone");
String advisor_name = request.getParameter("advisor_name");

StudentBean student = new StudentBean();
student.setSnum(snum);
student.setName(name);
student.setId(id);
student.setPasswd(passwd);
student.setPhone(phone);
student.setAdvisor_name(advisor_name);

out.println("학생 객체의 주소값 = " + student);
out.println("<h3>학생 정보는 " + student.printStudent() + "입니다</h3>");
%>
</body>
</html>