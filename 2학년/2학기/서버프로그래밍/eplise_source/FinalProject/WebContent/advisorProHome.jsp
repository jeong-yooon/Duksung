<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="advisor.*" %>
<%@ page import="java.util.ArrayList" %>
	
<%
request.setCharacterEncoding("utf-8");
String deptName = request.getParameter("dept");
String emplId = request.getParameter("emplid");

DatamanagerBean manager = DatamanagerBean.getInstance();

ArrayList<EmployeeBean> employeeArray = manager.getEmployees(deptName);
for(int i=0; i<employeeArray.size(); i++) {
	EmployeeBean employee = employeeArray.get(i);
	out.println("<h5>" + "사번:" + employee.getEmplid() + "이름:" + employee.getName() + "</h5>");
	//out.println(student.printStudent() + "<br>");
}

%>