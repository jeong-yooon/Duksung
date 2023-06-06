<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="advisor.DatamanagerBean" %>

<%
String okid = (String)session.getAttribute("okid");
if (okid != null) {
	out.println(1);
}
else {
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd  = request.getParameter("passwd");

	DatamanagerBean manager = DatamanagerBean.getInstance();
	int check = manager.userCheck(id, passwd);
	if(check == 1)
		session.setAttribute("okid", id);
	out.println(check);
}
%>