<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Card> cardList = (List<Card>)session.getAttribute("cardList"); 
   Stack<Card> fieldStack = (Stack<Card>)session.getAttribute("fieldStack"); %>

<%	for(Card card : cardList){
	if(card.getCard_flag() == 1){ %>
		a
		<% }} %>
<br>

<%= fieldStack %><br>

<form action="hand-integer-servlet" method="POST">
<%int i = 6; %>
	<% for(Card card : cardList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./trump/<%= card.getCard_id() %>.png" ></label>

	<% i++;} } %>
	<input type="checkbox" name="submission" value="-1">パス<br>
	
	<input type="submit" value="出す">
</form>
</body>
</html>