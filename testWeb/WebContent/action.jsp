<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="user" class="entity.User"/>
	<jsp:setProperty property="id" name="user" value="1"/>
	<jsp:setProperty property="name" name="user" value="张三"/>
	<jsp:getProperty property="name" name="user"/>
	<%--
	<jsp:forward page="success.jsp">
		<jsp:param value="123" name="a"/>
	</jsp:forward> --%>
	<jsp:include page="success.jsp"/>
</body>
</html>