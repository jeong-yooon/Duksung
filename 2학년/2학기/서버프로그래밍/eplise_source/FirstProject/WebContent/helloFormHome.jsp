<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름과 암호 입력</title>
</head>
<body>
<h2>이름과 암호 입력</h2>
		<form action ="helloProHome.jsp" method="post">
			<%="이름: "%><input type="text" name="nm">
			<%="암호: "%><input type="text" name="pw">
			<input type="submit" value="전송">
		</form>
</body>
</html>