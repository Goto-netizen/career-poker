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
<!-- jQueryの読み込み -->
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script>
$(function () {
	$('.send').prop("disabled", true); //送信ボタン非動作
	//入力欄の操作時
	$('form input').change(function () {
		//必須項目が空かどうかフラグ
		var $flag = true;
		var $cbx_group = $('input:checkbox[name^="submission"]');
		//チェックボックスグループの必須判定
		$('[type="checkbox"]').each(function () {
            if ($('input[type="checkbox"]:checked').length === 0) {
                $flag = false;
            }
        });


		//全て埋まっていたら
		if ($flag) {
			//送信ボタンを復活
			$('.send').prop("disabled", false);
		} else {
			//送信ボタンを閉じる
			$('.send').prop("disabled", true);
		}
	});
});
</script>
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
		<label for="check<%=i %>"><input type="checkbox" name="submission" id="check<%=i %>" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=72 height =128 ></label>
	<% }i++; } %>
	<label for="check30"><input type="checkbox" name="submission" id="check30" value="-1">パス</label><br>
	
	<input type="submit" name="submit" id="submit" value="出す" class="send">
	</div>
</form>

<div class="allConsole" style="position: fixed; background-color: black;width:200px; height:400px; margin-top:-650px;margin-left:950px;border-radius:8px;">
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
</div>
</body>
</html>