<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Deque"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="game.css">
<style>
</style>
</head>
<body>
<% List<Card> deckList = (List<Card>)session.getAttribute("deckList"); 
	Deque<Card> fieldDeque = (Deque<Card>)session.getAttribute("fieldDeque");
	int x = (Integer)session.getAttribute("x");%>

<div id="cpu-hand">
<%	int b = 0;
    for(Card card : deckList){
	if(card.getCard_flag() == 1){ %>
		<img src="./trump/card_back.png" width=68 height=100 class="b<%=b%>">
		<% b++;}} %></div>
<br>
<div id="field-list">
<img src="./newTrump/kara.png" width=72 height =128 class="" >
<%int a = 0;%>
	<% for(Card field : fieldDeque){ %>
		<% if(field.getCard_flag() == 3){ %>
		<img src="./newTrump/<%= field.getCard_id() %>.png" width=72 height =128 class="a<%=a %>" >
		<% }a++;} %></div>

<form action="hand-integer-servlet" method="POST">
<div id="player-hand" style="width:790px">
<%int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=72 height =128 ></label>
	<% }i++; } %>
	<label><input type="checkbox" name="submission" value="-1">パス</label><br>
	
	<input type="submit" value="出す">
	</div>

<% for(Card field : fieldDeque){
	if(field.getCard_flag() == 3){ %>
		<span class="console"><%= field.getNum() %>が出ました。</span><br>
		<% if(field.getNum().equals("Jack")){ %>
			<span class="console">イレブンバック発動中<br></span>
		<% }
	}
} %>
<% if(fieldDeque.isEmpty() || fieldDeque.size() ==1){ if(x!=0){%>
	<span class="console">場が流れました。</span><br>
<% } }%>

</form>
</body>
</html>