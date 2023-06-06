<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="advisor.*" %>
<%@ page import="java.util.ArrayList" %>
	
<%
request.setCharacterEncoding("utf-8");
String emplId = request.getParameter("emplid");

DatamanagerBean manager = DatamanagerBean.getInstance();

ArrayList<EmployeeBean> employeeidArray = manager.getNameDept(emplId);
for(int i=0; i<employeeidArray.size(); i++) {
	EmployeeBean employee = employeeidArray.get(i);
	out.println("<h5>" + "이름:" + employee.getName() + "부서:" + employee.getDept() + "</h5>");
	//out.println(student.printStudent() + "<br>");
}

%>