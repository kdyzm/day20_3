<%@ page language="java" import="java.util.*" pageEncoding="utf-8" 
	contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	这里是在线用户列表！
	<table>
		<tr>
			<td>用户名</td>
			<td>ip地址</td>
			<td>首次访问时间</td>
			<td>最后一次访问时间</td>
			<td>踢人</td>
		</tr>
		<c:forEach items="${requestScope.userlist}" var="map">
			<tr>
				<td>${map.name}</td>
				<td>${map.ip}</td>
				<td>${map.createtime }</td>
				<td>${map.lastaccesstime}</td>
				<td><a href="<c:url value='/userServlet?cmd=remove&name=${map.name}'/>">踢人</a></td>
			</tr>
		</c:forEach>		
	</table>
  </body>
</html>
