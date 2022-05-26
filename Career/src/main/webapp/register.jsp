<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録</title>
</head>
<body>
<h1>会員登録</h1><br>
<form action="register-servlet" method="POST">
ユーザーID:<input type="text" name="user_id"><br>
パスワード:<input type="text" name="password"><br>
氏名:<input type="text" name="name"><br>
年齢:<select name="age">
<%for(int i =3;i<=100;i++){ %>
<option value="<%=i%>"><%=i%></option>
<%} %>
</select><br>
<input type="submit" value="登録">
</form>
</body>
</html>