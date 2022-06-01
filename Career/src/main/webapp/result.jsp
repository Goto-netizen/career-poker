<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Deque" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
<link rel="stylesheet" href="result.css">
</head>
<body>
	<% 
		List<Card> deckList = (List<Card>)session.getAttribute("deckList");
	%>
	
	<%int count1 = 0;
		int count2 = 0;
	
		for(int i=0;i<deckList.size();i++) {
			if(deckList.get(i).getCard_flag()==0) {//山札に自分のカードが残っていない
				count1++;
			}
			if(deckList.get(i).getCard_flag()==1) {//山札にCPUのカードが残っていない
				count2++;
			}
		}
		if(count1 == 0){ %>
			<div class="player">あなたの勝ちです。</div><br>
		<% }else{ %>
			<div class="cpu">CPUの勝ちです。</div><br>
		<% } %>

	<%
		session.removeAttribute("neme");
		session.removeAttribute("deckList");
		session.removeAttribute("fieldDeque");
		session.removeAttribute("index");
		session.removeAttribute("winner");
	%>
		<div class="return"><a href="menu.jsp">メニューに戻る</a></div>
</body>
</html>