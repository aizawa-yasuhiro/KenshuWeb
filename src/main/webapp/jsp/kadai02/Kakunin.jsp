<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="inputBean" scope="request" class="kadai02.InputDataBean" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題２－１</title>
<style type="text/css">
<!--
table tr th{
	font-weight: normal;
	width: 100px;
	text-align: left;
	vertical-align: top;
	}
-->
</style>
</head>
<body>
	<table>
		<tr>
			<th>名前</th>
			<td><%= inputBean.getName() %></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><pre><%= inputBean.getAddress() %></pre></td>
		</tr>
		<tr>
			<th>性別</th>
			<td><%= inputBean.getSex() %></td>
		</tr>
		<tr>
			<th>職業</th>
			<td><%= inputBean.getJob() %></td>
		</tr>
	</table>
</body>
</html>