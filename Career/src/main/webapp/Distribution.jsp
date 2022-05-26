<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,model.entity.DistributionBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<DistributionBean> distributionList
			= (List<DistributionBean>) request.getAttribute("distributionList");
	%>
	<h2>山札</h2>
	<table>
		<tr>
			<th>数字</th>
			<th>マーク</th>
			<th>強さ</th>
		</tr>
		<%
			for (DistributionBean myhand : distributionList) {
		%>
		<tr>
			<td><%=myhand.getNum()%></td>
				<td><%=myhand.getMark()%></td>
				<td><%=myhand.getStrength() %></td>
		
		</tr>
		<%
			}
		%>
	</table>
	<%
		List<DistributionBean> MyHandList
			= (List<DistributionBean>) request.getAttribute("MyHandList");
	%>
	<h2>自分の手札</h2>
	<table>
		<tr>
			<th>数字</th>
			<th>マーク</th>
			<th>強さ</th>
		</tr>
		<%
			for (DistributionBean myhand : MyHandList) {
		%>
		<tr>
			<td><%=myhand.getNum()%></td>
				<td><%=myhand.getMark()%></td>
				<td><%=myhand.getStrength() %></td>
		
		</tr>
		<%
			}
		%>
	</table>
	<%
		List<DistributionBean> EnemyHandList
			= (List<DistributionBean>) request.getAttribute("EnemyHandList");
	%>
	<h2>敵の手札</h2>
	<table>
		<tr>
			<th>数字</th>
			<th>マーク</th>
			<th>強さ</th>
		</tr>
		<%
			for (DistributionBean myhand : EnemyHandList) {
		%>
		<tr>
			<td><%=myhand.getNum()%></td>
				<td><%=myhand.getMark()%></td>
				<td><%=myhand.getStrength() %></td>
		
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>