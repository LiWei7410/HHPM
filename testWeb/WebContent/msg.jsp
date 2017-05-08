<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%! String name = "张三"; %>
<!DOCTYPE html>
<html>
<head>
<title>操作提示</title>
<style type="text/css">
	h1{
		width: 500px;
		margin: 100px auto;
		text-align: center;
		color: red;
	}
</style>
</head>
<body>
	<h1><%=request.getAttribute("msg") %><a href="<%=request.getAttribute("url")%>">返回首页</a></h1>
	<!-- 这是HTML注释 -->
	<%-- 这是JSP的注释 --%>
</body>
</html>