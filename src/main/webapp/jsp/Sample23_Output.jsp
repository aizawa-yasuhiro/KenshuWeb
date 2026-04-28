<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>サンプル23</title>
</head>
<body>
<%
    // エンコード
    request.setCharacterEncoding("UTF-8");

    String param = request.getParameter("param");       // 入力値取得

    // 画面表示
    if("".equals(param)){
%>
    未入力です。
<%
    } else {
%>
    <h1><%= request.getParameter("param") %></h1> と入力しました。
<%
    }
 %>
</body>
</html>
