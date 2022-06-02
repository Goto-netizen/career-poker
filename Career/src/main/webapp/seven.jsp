<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.item.Card,java.util.Stack" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>渡すカードの選択</title>
<link rel="stylesheet" href="seven.css">
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
            if ($('input[type="checkbox"]:checked').length === 0 || $('input[type="checkbox"]:checked').length > 1) {
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
	List<Integer> indexList = (List<Integer>)session.getAttribute("index");
	int index = indexList.get(0);%>
	
	<div style="color:white;font-weight:bold;">渡すカードを選択してください。<br>
	
<form action="throw-servlet" method="POST">
<div id="player-hand" style="width:790px">
	<% int i = 0; %>
	<% for(Card card : deckList){ %>
		<% if(card.getCard_flag() == 0 && i != index){ %>
		<label><input type="checkbox" name="submission" value="<%= i %>"><img src="./newTrump/<%= card.getCard_id() %>.png" width=72 height =128 ></label>
	<% }i++; } %>	
	<label><input type="checkbox" name="submission" value="0">渡さない</label>
	</div>
	<input type="submit" name="submit" id="submit" value="決定" class="send">
</form>
</body>
</html>