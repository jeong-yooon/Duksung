<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="UTF-8">
<title>jQuery 테스트</title>

<style type="text/css">
  div#displayArea {
    width : 200px;
    height : 300px;
    border : 5px double #6699FF;
    background-color : red;
  }
</style>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
  $(document).ready(function() {
	  $("#mybtn").click(function() {
		  $("#displayArea").html("<h6>음두헌</h6> <img src='some.jpg' border='0'/>");
		  $("#displayArea").fadeToggle(3000);
	  });
  });
</script>
</head>
<body>
<%
	boolean comment = true;
	if(comment) {
		String str = "jQuery를 테스트하는 페이지입니다.";
		out.write("<h5>" + str + "</h5>");
	}
%>
  <div id="displayArea">이곳의 내용이 변경</div>
  <button id="mybtn">표시</button>
</body>
</html>