<%@ page contentType = "text/html; charset=utf-8" %>
<%@page import="java.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
	String deptName = request.getParameter("dept");
	
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/empldb";
	String user = "root";
	String password = "duksung";
	Connection conn = DriverManager.getConnection(url, user, password);
	
	String sql = "select employee.name from assignment, employee, job ";
	sql = sql + "where assignment.emplid=employee.emplid and assignment.jobid=job.jobid and job.dept=?";

	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, deptName);
	ResultSet rs = pstmt.executeQuery();
%>
<html>
<head><title>지도학생‹</title></head>
<body>
<%= deptName %> 소속직원
<hr>
<%
	String studentName=null;
	while(rs.next()) {
	  studentName = rs.getString(1);
%>
<h5><%= studentName %></h5>
<%
	}
	rs.close();
	pstmt.close();
	conn.close();
%>
</body>
</html>
