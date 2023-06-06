<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="advisor.*" %>
<%@ page import="java.util.ArrayList" %>
	
<%
request.setCharacterEncoding("utf-8");
String advisor_name = request.getParameter("advisor");

DatabaseBean manager = DatabaseBean.getInstance();
ArrayList<StudentBean> studentArray = manager.getStudents(advisor_name);
for(int i=0; i<studentArray.size(); i++) {
	StudentBean student = studentArray.get(i);
	out.println("<h5>" + student.getName() + "</h5>");
//	out.println(student.printStudent() + "<br>");
}
%>