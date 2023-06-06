<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>JSP 기본 Form</title>
</head>
<body>
		<form action ="basicProHome.jsp" method="post">
			<%="이름: "%><input type="text" name="nm">
			<%="암호: "%><input type="text" name="pw">
			<input type="submit" value="전송">
		</form>
</body>
</html>