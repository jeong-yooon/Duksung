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
	$("#search1").click(function(){
		  //입력된 사용자의 아이디와 비밀번호를 얻어냄
		  var query = {dept:$("#dept").val()};
		  $.ajax({
		     type: "post",
		     url: "advisorProHome.jsp",
		     data: query,
		     success: function(data){
		    	 $("#employees").html(data);
		     },
			 error: function() {
				 alert("검색 실패");
			 }
		  });
	});
});
$(document).ready(function() {
	$("#search2").click(function(){
		  //입력된 사용자의 아이디와 비밀번호를 얻어냄
		  var query = {emplid:$("#emplid").val()};
		  $.ajax({
		     type: "post",
		     url: "advisorProHome2.jsp",
		     data: query,
		     success: function(data){
		    	 $("#employeedept").html(data);
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
<b>부서을 선택하면 소속직원들이 표시됩니다~</b><p>
부서: <select id="dept">
		     <option>임원</option>
		     <option>영업부</option>
		     <option>인사부</option>
		     <option>경리부</option>
			</select><p>
<button id="search1">검색</button>
<div id="employees" style="overflow:auto; width:400px; height:150px;">
</div>

<b>지도교수명을 입력하면 지도학생들이 표시됩니다~</b><p>
사번: <input id="emplid" type="text" size=5><p>
<button id="search2">검색</button>
<div id="employeedept" style="overflow:auto; width:400px; height:150px;">
</div>
</body>
</html>