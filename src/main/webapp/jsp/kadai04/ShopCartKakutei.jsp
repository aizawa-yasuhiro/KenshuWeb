<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String kngk = (String) request.getAttribute("sumKngk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題４－４</title>
</head>
<body>
	<form name="frm" method="get" action="/KenshuWeb/kadai04">
		合計金額は <%= kngk %> 円です。<br>
		お買い上げありがとうございました。
		<br>
		<input type="submit" value="戻る">
	</form>

</body>
</html>