<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>이름 입력</title>
<script>
	function send() {
		document.getElementById("form2").submit();
	}
</script>
</head>
<body>
<h2>입력된 이름을 서버에 전송합니다...</h2>
		<form id="form2" action ="helloPro.jsp" method="post">
			<input type="text" name="nm">
			<input type="button" onclick="send()" value="전송">
		</form>
</body>
</html>