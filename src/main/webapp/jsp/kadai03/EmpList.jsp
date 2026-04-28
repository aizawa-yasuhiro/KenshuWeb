<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="searchBean" scope="request" class="kadai03.SearchEmpBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>西本【課題３－１】</title>
</head>
<body>
<input type="button" value="戻る" onclick="javascript:location.href='/KenshuWeb/jsp/kadai03/input.jsp'"><br>
条件：<%= searchBean.getCondNm() %>
<table border="1">
	<tr bgcolor="yellow">
		<th width="100">社員番号</th>
		<th width="150">社員名</th>
	</tr>
<%
	for(int i = 0; i < searchBean.getLstEmpCnt(); i++) {
%>
	<tr>
		<td align="center"><%= searchBean.getEmpNo(i) %></td>
		<td><%= searchBean.getEName(i) %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>