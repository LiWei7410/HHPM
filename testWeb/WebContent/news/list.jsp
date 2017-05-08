<%@page import="common.ConstantValues"%>
<%@page import="entity.User"%>
<%@page import="entity.News"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
*{
 padding: 0;
 margin: 0px;
}
table{
	width:500px;
	margin: 0 auto;
	border-collapse: collapse;
}
td{
	border: 1px solid #000;
	height: 40px;
	text-align: center;
}
</style>

</head>
<body>
	欢迎：<%=((User)session.getAttribute(ConstantValues.SESSION_USER)).getUsername()%>
		
	<table>
	<tr>
			<td>编号</td>
			<td>标题</td>
			<td>作者</td>
			<td>时间</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="ls">
			<tr>
				<td>${ls.id }</td>
				<td>${ls.bt }</td>
				<td>${ls.zz }</td>
				<td>${ls.times }</td>
				<td>
					<a href="/testWeb/new?op=edit&id=${ls.id }">编辑</a>
					<a href="/testWeb/new?op=del&id=${ls.id }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>