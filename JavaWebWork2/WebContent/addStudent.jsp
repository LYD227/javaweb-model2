<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加学生</title>
</head>
<body>
	<form action="AddStudentServlet" method="post">
		学生姓名：<input type="text" name="stuName"><br>
		专业：<input type="text" name="major"><br>
		性别：<input type="text" name="gender"><br>
		生日：<input type="text" name="birthday"><br>
		<input type="submit" value="添加">
	</form>

</body>
</html>