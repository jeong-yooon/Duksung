<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<h2>계산할 실수와 연산자를 입력하세요.</h2>
	<form action="calculatorProHome.jsp" method="get">
		<input type="text" name="before">
		<select name="operator">
		     <option> + </option>
		     <option> - </option>
		     <option> x </option>
		     <option> ÷ </option>    
		 </select>
		 <input type="text" name="after"><p>
		 
		<input type="submit" value="계산">
	</form>
	
</body>
</html>