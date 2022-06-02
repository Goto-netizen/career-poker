<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>爆破選択</title>
<link rel="stylesheet" href="queen.css">
</head>
<body>
<% List<Card> deckList = (List<Card>)session.getAttribute("deckList"); %>
	<div style="color:white;font-weight:bold;">爆破するカードの数字を選んでください<br>
<form action="throw-servlet" method="POST" style="width:790px">



		<label><input type="checkbox" name="submission" value="7"><img src="./newTrump/9.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="8"><img src="./newTrump/13.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="9"><img src="./newTrump/17.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="10"><img src="./newTrump/21.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="11"><img src="./newTrump/25.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="12"><img src="./newTrump/29.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="13"><img src="./newTrump/33.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="1"><img src="./newTrump/1.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="2"><img src="./newTrump/5.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="14"><img src="./newTrump/37.png" width=72 height =128 ></label>
        <label><input type="checkbox" name="submission" value="0" >爆破しない</label>
        
	
	<input type="submit" value="決定">
</form>
<div id="player-hand" style="width:790px">
<div style="color:white;font-weight:bold;">↓あなたのカード<br></div>
<%int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0){ %>
		<img src="./newTrump/<%= card.getCard_id() %>.png" width=72 height =128 >
	<% }i++; } %>
	
	</div>

</body>
</html>