<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
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

<title>My JSP 'Collection.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
	function del() {
		if (confirm("ÄãÕæµÄÒª„h³ý†á£¿")) {
			var f = document.forms[1];
			f.action = "<%=path%>/servlet/CollectionServlet?action=delete;"
			f.submit();
		} else {
			return;
		}
	}
</script>
</head>

<body>
	<form name="f1" id="f1"
		action="<%=path%>/servlet/CollectionServlet?action=save" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="url" value="http://"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
	<hr>
	<form action="" method="post">
		<c:forEach var="c" items="${CL }">
		${c.id }
		${c.name }
		
		<a href="${c.url }">${c.url }</a>

			<a href="<%=path%>/servlet/CollectionServlet?action=get&id=${c.id}">Edit</a>
			<input type="checkbox" name="ids" value=${c.id }>
			<br>
		</c:forEach>
		<input type="button" value="Delete" onclick="del();">
	</form>
</body>
</html>
