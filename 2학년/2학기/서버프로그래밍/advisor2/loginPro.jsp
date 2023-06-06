<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="advisor.DatabaseBean" %>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");

	DatabaseBean manager = DatabaseBean.getInstance();
	int check = manager.userCheck(id, passwd);
	out.println(check);
%>