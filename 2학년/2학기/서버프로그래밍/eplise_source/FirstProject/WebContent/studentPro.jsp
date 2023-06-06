<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="UTF-8">
<title>학생 정보</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String number = request.getParameter("num");
	String[] majors = request.getParameterValues("majors");
	String[] hobbies = request.getParameterValues("hobbies");
%>
<h2> 학생 정보 입력 결과 </h2>
    학번 :  <%= name%><p>
    핸드폰: <%= number%><p>
    전공 :
<%
  if(majors == null)
    out.println("전공 없음");
  else {
    for(int i=0; i<majors.length; i++) {
      out.println(majors[i] + " ");
    }
  }
%>
  <p>취미 :
<%
  if(hobbies == null)
  	out.println("취미 없음");
  else {
  	for(int i=0; i<hobbies.length; i++) {
    	out.println(hobbies[i] + " ");
    }
  }
%>
</body>
</html>