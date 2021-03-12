<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Stu.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form name="f1" id="f1" action="<%=path%>/servlet/StuServlet"
		method="post">
		<table>
			<tr>
				<td>name:</td>
				<td><input type="text" name="name" id="login"></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age" id="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	<hr>

	<c:forEach var="s" items="${StuList }">
		${s.id }
		${s.name }
		${s.age }
		<br>
	</c:forEach>
</body>
</html>
