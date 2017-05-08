<%@page import="entity.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
			News news=(News)request.getAttribute("news");
%>
		<form action="/testWeb/new?op=modify" method="post">
			编号：<input type="text" name= "id" value="<%=news.getId() %>" readonly="readonly"><br/>
			时间：<input type="text" name = "times" value="<%=news.getTimes() %>"><br/>
			标题：<input type="text" name= "bt" value="<%=news.getBt() %>"><br/>
			作者：<input type="text" name = "zz" value="<%=news.getZz() %>"><br/>
			内容：<textarea rows="" cols="" name="nr"><%=news.getNr() %></textarea><br/>
			<input type="submit">
		</form>

</body>
</html>