<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
	contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Insert title here!</title>
    <style type="text/css">
    	table {
			border: 1px solid black;
			border-collapse: collapse;
			margin: 0 auto;
		}
		td {
			border: 1px solid black;
			text-align: center;
			padding: 3px;
		}
    </style>
  </head>
  <body>
	<!-- 默认是登陆界面 -->
	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<form action="<c:url value='/userServlet'/>" method="post">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="登陆"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			${sessionScope.user}已登录！<br/>
			<a href="<c:url value='/showAll'/>">查看登陆用户列表</a>
		</c:otherwise>
	</c:choose>
  </body>
</html>
