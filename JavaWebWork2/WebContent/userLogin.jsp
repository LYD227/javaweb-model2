<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
	<form action="UserServlet" method="get">


		用户名：<input type="text" id="userName" name="userName"> 密码：<input
			type="password" id="userPassword" name="userPassword"> <input
			type="submit" value="登录">
	</form>
</body>
</html>