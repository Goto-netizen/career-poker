<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="game.css">
</head>
<body>
<% List<Card> deckList = (List<Card>)session.getAttribute("deckList"); 
   Stack<Card> fieldStack = (Stack<Card>)session.getAttribute("fieldStack"); %>

<div id="cpu-hand">
<%	for(Card card : deckList){
	if(card.getCard_flag() == 1){ %>
		<img src="./trump/card_back.png" width=68 height=100 >
		<% }} %></div>
<br>
<div id="field-list">
<%int a = 0; %>
	<% for(Card field : fieldStack){ %>
		<% if(field.getCard_flag() == 3){ %>
		<img src="./newTrump/<%= field.getCard_id() %>.png" width=49.5 height =88 >
		<% }a++; } %></div>

<form action="hand-integer-servlet" method="POST">
<%int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=49.5 height =88 ></label>
	<% }i++; } %>
	<input type="checkbox" name="submission" value="-1">パス<br>
	
	<input type="submit" value="出す">
</form>
</body>
</html>