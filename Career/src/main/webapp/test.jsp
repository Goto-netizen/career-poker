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

<table>
<%for(Card card : cardList){ %>
<% if(card.getCard_flag() == 0) { %>
	<tr>
	<td><%=card.getCard_id() %></td>
	<td><%=card.getNum() %></td>
	<td><%=card.getMark() %></td>
	<td><%=card.getStrength() %></td>
	<td><%=card.getCard_flag() %></td>
	</tr><% } %>
	<% } %>
</table>
</body>
</html>