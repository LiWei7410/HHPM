<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script type="text/javascript" src="/testWeb/js/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/testWeb/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
$(function(){
	var now = new Date();
	var month = now.getMonth() + 1;
	month = month < 10 ? '0' + month : month;
	var date = now.getDate();
	date = date < 10 ? '0' + date : date;
	$('#createAt').val(now.getFullYear() + '-' + month + '-' + date + ' ' + now.getHours() + ':' + now.getMinutes() + ':' + now.getSeconds());
	CKEDITOR.replace( 'content', { });
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="/testWeb/new" method="post">
			<input type="hidden" value="add" name="op">
			标题<input type="text" name= "bt"><br/>
			作者<input type="text" name = "zz"><br/>
			发布时间<input type="text" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss'})" >
			内容<textarea name="nr" id="content"></textarea><br/>
			<input type="submit">
		</form>
</body>
</html>