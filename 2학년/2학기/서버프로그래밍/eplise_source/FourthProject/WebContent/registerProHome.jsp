<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="advisor.EmployeeBean"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>가입 처리</title>
</head>
<body>
사원 추가!
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="employee" class="advisor.EmployeeBean">
	<jsp:setProperty name="employee" property="*"/>
</jsp:useBean>
<%
int jobid=1;
int emplid=1;

Connection con = null;
ResultSet rs = null;
PreparedStatement pstmt = null;
String jdbcUrl ="jdbc:mysql://localhost:3306/empldb?serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
String dbUser = "root";
String dbPass = "duksung";

try {
	Class.forName("com.mysql.jdbc.Driver");
} catch(ClassNotFoundException e) {
	out.println("mysql driver loading error!");
	out.println(e.toString());
	System.out.println("mysql driver loading error!");
	return;
}

try {
	con = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
} catch(SQLException e) {
	out.println("mysql connection error!");
	out.println(e.toString());
	return;
}

try {
	
	String query = "select jobid from job where dept=?";
	pstmt = con.prepareStatement(query);
	pstmt.setString(1,employee.getDept());
	rs = pstmt.executeQuery();
	if(rs.next()){ //해당 부서가 있으면
		jobid = rs.getInt(1);
	}
	
	query = "select emplid from assignment where jobid=?";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1,jobid);
	rs = pstmt.executeQuery();
	if(rs.next()){ //해당 고용번호 있으면
		emplid = rs.getInt(1);
	}
	
	query = "insert into assignment values(?,?,?,?)";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1,employee.getEmplid());
	pstmt.setInt(2,jobid);
	pstmt.setString(3,employee.getStartdate());
	pstmt.setString(4,employee.getTermdate());
	pstmt.executeUpdate();
	
	query = "insert into employee values(?,?,?,?)";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1,employee.getEmplid());
	pstmt.setString(2,employee.getName());
	pstmt.setString(3,employee.getAddress());
	pstmt.setInt(4,employee.getSsn());
	pstmt.executeUpdate();
	//out.println("회원 추가");
} catch(SQLException e) {
	out.println(e.toString());
}

try {
	if(pstmt != null) pstmt.close();
	if(con != null) con.close();
} catch(SQLException e) {
	out.println(e.toString());
}
//response.sendRedirect("indexHome.jsp");
%>
</body>
</html>