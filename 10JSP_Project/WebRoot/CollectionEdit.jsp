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

<title>My JSP 'Collection.jsp' starting page</title>


</head>

<body>
	<form name="f1" id="f1"
		action="<%=path%>/servlet/CollectionServlet?action=update" method="post">
		<input type="hidden" value="${CollectionBean.id }">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"
					value="${CollectionBean.name }"></td>
			</tr>
			<tr>
				<td>URL:</td>
				<td><input type="text" name="url"
					value="${CollectionBean.url }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="update"></td>
			</tr>
		</table>
	</form>

</body>
</html>
