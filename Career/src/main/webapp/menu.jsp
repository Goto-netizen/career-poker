<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
<link rel="stylesheet" href="menu.css">
</head>
<body>
<!--<h2>Let's大富豪!!</h2>-->
    <form action="biginner-servlet" method="POST">
    <input type="submit" value="初級" class="easy"><br></form>
    <form action="advanced-servlet" method="POST"><input type="submit" value="上級" class="hard">
	</form>
		<a href="login1.html" >ログアウト</a>
		<div class="hidden_box">
    <label for="label1">ルール</label>
    <input type="checkbox" id="label1"/>
    <div class="hidden_show">
      <!--非表示ここから--> 
		<p><img src ="rule.png" width="877.5" height="510.7" style="margin-left:100px"></p>
		</div>
	<div id="video-area">
<video id="video" poster="menu_video1.mp4" webkit-playsinline playsinline muted autoplay loop>
<source src="menu_video1.mp4" type="video/mp4">
</body>
</html>