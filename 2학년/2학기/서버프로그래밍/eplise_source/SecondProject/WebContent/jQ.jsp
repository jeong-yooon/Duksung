<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="UTF-8">
<title>jQuery 테스트2</title>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
  $(document).ready(function() {
	  $("#b1").click(function() {
		  alert($("#b2").text());
		  $("#b2").text($("p").text());
	  });
	  $("#b2").click(function() {
		  $("#displayArea").html("<img src='some.jpg' border='0'/>");
	  });
  });
</script>
</head>
<body>
  <p>이미지 표시</p>
  <button id="b1">버튼 레이블 변경</button>
  <div id="displayArea">이미지</div>
  <button id="b2">음버튼</button>
</body>
</html>