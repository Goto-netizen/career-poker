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
<% List<Card> cardList = (List<Card>)session.getAttribute("cardList"); 
   Stack<Card> fieldStack = (Stack<Card>)session.getAttribute("fieldStack"); %>

<div id="cpu-hand">
<%	for(Card card : cardList){
	if(card.getCard_flag() == 1){ %>
		<img src="./trump/card_back.png" width=68 height=100 >
		<% }} %></div>
<br>
<div id="field-list">
<%= fieldStack %><br></div>

<form action="hand-integer-servlet" method="POST">
<%int i = 6; %>
	<% for(Card card : cardList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./trump/<%= card.getCard_id() %>.png" width=50 height =50 ></label>
	<% i++;} } %>
	<input type="checkbox" name="submission" value="-1">パス<br>
	
	<input type="submit" value="出す">
</form>
</body>
</html>