<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="register.css">
<title>会員登録</title>
</head>
<body>
<div class = "top"><h1>会員登録</h1><br><hr><div>
<form action="register-servlet" method="POST">
<div class = "all">
<div class= "registform">
以下の項目を入力して「登録」ボタンをクリックしてください。
<input type="text" class="hoge" name="user_id" placeholder="ユーザーID" maxlength="15"><br>
<input type="password" class="hoge" name="password" placeholder="パスワード" maxlength="15"><br>
<input type="text" class="hoge" name="name" placeholder="氏名" maxlength="10"><br>
<select name="age" class="hoge" placeholder="年齢">
<%for(int i =3;i<=100;i++){ %>
<option value="<%=i%>"><%=i%></option>
<%} %>
</select><br>
<input type="submit" class="sub" value="登録">
</div>
</div>
</form>
</body>
</html>