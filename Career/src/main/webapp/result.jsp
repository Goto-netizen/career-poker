<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
<link rel="stylesheet" href="result.css">
</head>
<body>
	<% 
		String winner = null;
		winner = (String)session.getAttribute("winner");
	%>
	
	<% if(winner == null){ 
		winner = (String)session.getAttribute("neme");
		%>
		<div class="player"><%= winner %>の勝ちです。</div><br>
	<% }else{ %>
		<div class="cpu"><%= winner %>の勝ちです。</div><br>
	<% } %>
	
	<%
		session.removeAttribute("neme");
		session.removeAttribute("deckList");
		session.removeAttribute("fieldDeque");
		session.removeAttribute("index");
		session.removeAttribute("winner");
	%>
		<div class="return"><a href="menu.jsp">メニューに戻る</a></div>
</body>
</html>