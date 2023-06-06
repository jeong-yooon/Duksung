<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>회원 가입</title>
</head>
<body>
<form action="registerPro.jsp" method="post">
학번: <input type="text" name="snum" size=10><p>
이름: <input type="text" name="name" size=10><p>
id: <input type="text" name="id" size=15><p>
비밀번호: <input type="password" name="passwd" size=15><p>
전화번호: <input type="text" name="phone" size=15><p>
지도교수: <input type="text" name="advisor_name" size=10><p>
<input type="submit" value="가입">
</form>
</body>
</html>