<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% List<Card> deckList = (List<Card>)session.getAttribute("deckList"); %>

	爆破するカードの数字を選んでください<br>
<form action="ten-servlet" method="POST">



		<label><input type="checkbox" name="submission" value="7"><img src="./newTrump/9.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="8"><img src="./newTrump/13.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="9"><img src="./newTrump/17.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="10"><img src="./newTrump/21.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="11"><img src="./newTrump/25.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="12"><img src="./newTrump/29.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="13"><img src="./newTrump/33.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="14"><img src="./newTrump/1.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="15"><img src="./newTrump/5.png" width=49.5 height =88 ></label>
        <label><input type="checkbox" name="submission" value="16"><img src="./newTrump/37.png" width=49.5 height =88 ></label>
        
        
	
	<input type="submit" value="爆破">
</form>

</body>
</html>