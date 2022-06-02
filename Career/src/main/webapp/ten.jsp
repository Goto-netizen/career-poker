<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>捨てるカードの選択</title>
<link rel="stylesheet" href="ten.css">
</head>
<body>
	<% List<Card> deckList = (List<Card>)session.getAttribute("deckList");
	List<Integer> indexList = (List<Integer>)session.getAttribute("index");
	int index = indexList.get(0);%>

	<div style="color:white;font-weight:bold;">捨てるカードを選択してください。<br>
<form action="throw-servlet" method="POST" style="width:790px">
<%int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0 && i != index){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=72 height =128 ></label>
	<% }i++; } %>
	<label><input type="checkbox" name="submission" value="0">捨てない</label>
	<input type="submit" value="決定">
</form>
</body>
</html>