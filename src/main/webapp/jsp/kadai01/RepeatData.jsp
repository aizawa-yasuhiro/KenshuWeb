<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>課題１－２</title>
</head>
<body>
	<%
		// エンコード
		request.setCharacterEncoding("UTF-8");

		// 値取得
		String param = request.getParameter("param");


		// 画面表示
		if("".equals(param)) {
			param = "未入力です。";
		}

		for(int i = 5; i > 0; i--) {
	%>
		<h<%= i %>><%=param %></h<%= i %>>
	<%
		}
	%>
</body>
</html>