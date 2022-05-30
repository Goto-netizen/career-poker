<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>捨て札選択</title>
</head>
<body>
	<% List<Card> deckList = (List<Card>)session.getAttribute("deckList"); %>

	捨て札を選択してください。<br>
<form action="ten-servlet" method="POST">
<%int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=49.5 height =88 ></label>
	<% }i++; } %>
	
	<input type="submit" value="捨てる">
</form>
</body>
</html>