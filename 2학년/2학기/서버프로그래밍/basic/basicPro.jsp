<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>JSP 기본 문법</title>
</head>
<body>
<!-- HTML 주석입니다. -->
<h2>JSP 기본 예제</h2>
<%!
	// 자바 주석입니다. 필드 정의
    String name = "음두헌";
    int a = 5;
    int b = 15;
    // 메소드 정의
    public int sum(){
 		  return a + b;
 	}
%>
<%-- JSP 주석입니다. JSP 표현식 --%>
a + b = <%=sum()%><p>
<%
	String count = request.getParameter("count");
	int cnt = Integer.parseInt(count);
	Random generator = new Random();
  	for(int i=0; i<cnt; i++) {
  	 		out.println(name + "<p>");
  	 		out.write("0과 9 사이의 난수: " + generator.nextInt(10) + "<p>");
  	}
%>
</body>
</html>