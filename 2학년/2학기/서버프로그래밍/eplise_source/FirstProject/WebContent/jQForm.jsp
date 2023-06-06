<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<meta charset="UTF-8">
<title>jQuery 테스트3</title>
<style type="text/css">
  div#result {
    width : 300px;
    height : 300px;
    border : 5px double #6699FF;
  }
</style>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
  $(document).ready(function() {
	  $("#b1").click(function() {
		  $.ajax({
			   type: "post",
			   url: "jQPro.jsp",
			   data: {name:$("#t1").val(), sid:$("#t2").val()},
			   success: function(data) {
				 $("#result").html(data);
				 alert("로드성공");
			   },
			   error: function() {
				 alert("로드실패");
			   }
	  	  });
	  });
  });
</script>
</head>
<body>
  이름: <input type="text" id="t1" size=5>
  학번: <input type="text" id="t2" size=5><p>
 <button id="b1">전송</button>
 <div id="result">로딩 영역</div>
</body>
</html>