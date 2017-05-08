<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ "这是使用el表达式输出的内容" }
	${ 123 }<br />
	${ 3+7 }
	${ 7 % 3 }<br />
	<%--${ 'ab' + 'cd' } --%>
	${ true && false }
	${ true || false }
	${ ! true }
	${ 3 > 5 }
	${ 3 > 5 ? '3大于5':'3小于5' }
	${ 7 mod 3 }
	${ true and true }
	${ true or false }
	${ not true }
	<hr />
	<%
		String name = "张三";
		pageContext.setAttribute("name", name);
		request.setAttribute("name", "李四");
		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		pageContext.setAttribute("map", map);
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "aaa");
		pageContext.setAttribute("map1", map1);
	%>
	${ name }
	${ requestScope.name }<br />
	${ map.key1 }
	${ map['key1'] }
	${ map1[1] }
	${ pageContext.request }
	${ cookie.VIEW_LIST.value }<br />
	${ header['Accept-Language'] }
	${ headerValues['accept-language'] }<br />
	${ param.user }
	${ paramValues.ahs[0] }
	${ paramValues.ahs[1] }
	${ initParam['global-param'] }<br />
	${ name.length() }
	${ empty "abc" }
</body>
</html>