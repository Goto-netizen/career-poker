<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録結果</title>
</head>
<body>

	<%
		int count = (Integer) request.getAttribute("count");
		if (count != 0) {
	%>
		以下の情報を登録しました。<br>
			<jsp:useBean id="user" class="model.entity.UserBean" scope="request"/>

	コード：<jsp:getProperty property="user_id" name="user"/><br>
	パスワード：<jsp:getProperty property="password" name="user"/><br>
	氏名：<jsp:getProperty property="name" name="user"/><br>
	年齢：<jsp:getProperty property="age" name="user"/><br>
	<%
		} else {
	%>
		登録できませんでした。<br>
	<%
		}
	%>


	<a href="login.html">ログイン画面へ戻る</a>
</body>
</html>