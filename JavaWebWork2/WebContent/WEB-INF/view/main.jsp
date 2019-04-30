<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"

	pageEncoding="UTF-8"
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666">StudentManagement</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/addStudent.jsp">添加</a></td>
</tr>
</table>
<br/>
<table cellspacing="0" border="1" class="table1">
<thead>
   <tr>
    	<th width="300">学号</th>
    	<th width="300">姓名</th>
    	<th width="300">专业</th>
    	<th width="300">性别</th>
    	<th width="300">生日</th>
   		<th  width="300">编辑</th>
   		<th  width="300">删除</th>
   </tr>
</thead>
<tbody>

<c:forEach var="p" items="${requestScope.list }">
	<tr>
		<td align="center">${p.stuId }</td>
		<td align="center">${p.stuName }</td>
		<td align="center">${p.major }</td>
		<td align="center">${p.gender }</td>
		<td align="center">${p.birthday }</td>
		<td align="center">
			<a href="${pageContext.request.contextPath}/updateStudent.jsp">修改</a>
		</td>
		<td>
			<a href="${pageContext.request.contextPath}/DeleteStudentServlet?id=${p.stuId}" onclick='return confirm("确认要删除吗?")'>删除</a>
		</td>
	</tr>
</c:forEach>
</tbody>
</table>
<br/>


</body>
</html>