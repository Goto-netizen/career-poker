<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.CardBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>大富豪</title>
</head>
<body>
	<%
		List<CardBean> MyHandList = (List<CardBean>)session.getAttribute("MyHandList");
		List<CardBean> EnemyHandList = (List<CardBean>)session.getAttribute("EnemyHandList");
		List<CardBean> FieldList = (List<CardBean>)session.getAttribute("FieldList");
	%>
	
	相手の手札：
	<%= EnemyHandList.size() %>枚<br>
	<br>
	
	場：
	<% if(FieldList != null){ %>
	<%= FieldList.get(FieldList.size()-1) %><br>
	<% }else{%>
	<br>
	<% } %>
	
	自分の手札<br>
	<form action="hand-integer-servlet" method="POST">
	<%int i = 0; %>
	<% for(CardBean MyHand : MyHandList){ 
	%>
	<label><input type="checkbox" name="submission" value="<%= i %>"><%= MyHand.getMark() %><%= MyHand.getNum() %></label><br>
	<% i++;} %>
	<input type="checkbox" name="submission" value="-1">パス</label><br>
	
	<input type="submit" value="出す">
	</form>
</body>
</html>
