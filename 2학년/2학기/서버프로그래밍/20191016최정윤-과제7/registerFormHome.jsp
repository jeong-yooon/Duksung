<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>원 등록</title>
</head>
<body>
<h1>원의 원점과 반지름 입력</h1>
<form action="registerProHome.jsp" method="post">
원--->
x: <input type="text" name="xnum" size=15>
y: <input type="text" name="ynum" size=15><p>
반지름--->
radius: <input type="text" name="rnum" size=15><p>
<input type="submit" value="등록">
</form>
</body>
</html>