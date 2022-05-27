<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
	<% 
		String winner = null;
		winner = (String)session.getAttribute("winner");
	%>
	
	<% if(winner == null){ 
		winner = (String)session.getAttribute("neme");
		%>
		<%= winner %>の勝ちです。<br>
	<% }else{ %>
		<%= winner %>の勝ちです。<br>
	<% } %>
	
	<%
		session.removeAttribute("neme");
		session.removeAttribute("deckList");
		session.removeAttribute("fieldStack");
		session.removeAttribute("index");
		session.removeAttribute("winner");
	%>
		<a href="menu.jsp">メニューに戻る</a>
</body>
</html>