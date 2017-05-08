<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="/testWeb/login" method="post">
		<div style=" margin-left: 500px;margin-top: 100px;">
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="xm" style="width:90px">用户名：</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="username" class="form-control" id="xm" />
					</div>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<label class="col-sm-2 control-label" for="mm" style="width:90px">密　码：</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="password" name="pwd" class="form-control" id="mm" />
					</div>
				</div>
			</div>
			<div><input type="submit" class="btn btn-primary" style="float:left; margin-left:150px"></div>
		</div>
	</form>
</body>
</html>
</html>