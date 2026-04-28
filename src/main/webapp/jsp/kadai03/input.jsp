<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		// セッションに保存した、検索条件（名前）を取得
		String strCondNm = "";
		if(session.getAttribute("COND_NM") != null) {
			strCondNm = (String)session.getAttribute("COND_NM");
		}
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>西本【課題３－２】</title>
</head>
<body>
	<form method="post" name="frm" action="/KenshuWeb/kadai03">
		名前 <input type="text" name="paramNm" size="10"
			value="<%= strCondNm %>"/>
		<br><br>
		<input type="submit" value="検索"/>
	</form>
</body>
</html>