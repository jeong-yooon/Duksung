<%@ page language= "java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>신입 사원</title>
</head>
<body>
<form action="registerProHome.jsp" method="post">
사번: <input type="text" name="emplid" size=10><p>
이름: <input type="text" name="name" size=10><p>
주소: <input type="text" name="address" size=15><p>
주민번호 앞 자리: <input type="text" name="ssn" size=15><p>
담당업무 번호: <select name="dept">
		     <option>사장</option>
		     <option>영업부 매장주임</option>
		     <option>영업부 부장</option>
		     <option>인사부 부장</option>
		     <option>인사부 과장</option>
		     <option>경리부 사원</option>
		     <option>인사부 비서</option>
		     <option>경리부 비서</option>
		     <option>영업부 과장</option>
		     <option>영업부 차장</option>
			</select><p>
업무시작일(yyyy-mm-dd): <input type="text" name="startdate" size=10><p>
<input type="submit" value="입력">
</form>
</body>
</html>