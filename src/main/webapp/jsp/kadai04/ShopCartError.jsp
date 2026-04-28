<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題４</title>
</head>
<body>
	<form name="frmError" method="post" action="/KenshuWeb/kadai04">
		<%= errorMsg %>
		<br>
		<input type="submit" value="戻る">
	</form>

</body>
</html>