<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>지도학생 검색</title>
<script src="js/jquery-3.5.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#search").click(function(){
		  //입력된 사용자의 아이디와 비밀번호를 얻어냄
		  var query = {advisor:$("#advisor").val()};
		  $.ajax({
		     type: "post",
		     url: "advisorPro.jsp",
		     data: query,
		     success: function(data){
		    	 $("#students").html(data);
		     },
			 error: function() {
				 alert("검색 실패");
			 }
		  });
	});
});
</script>
</head>
<body>
<b>지도교수명을 입력하면 지도학생들이 표시됩니다~</b><p>
지도교수: <input id="advisor" type="text" size=5><p>
<button id="search">검색</button>
<div id="students" style="overflow:auto; width:400px; height:300px;">
</div>
</body>
</html>