<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.yedam.board.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table {
background-color: aqua;}
</style>
</head>
<body>
	<% //자바문법 쓸수있다.
	String bNo = request.getParameter("boardNo");
	BoardDAO dao = new BoardDAO();
	Board b = dao.getBoardInfo(Integer.parseInt(bNo));
	%>
		
	<h1><a href="getBoardList.html">Board List</a></h1>
	<table border=1 style="border-collapse: collapse">
	<tr><td>BoardNo</td><td><%= bNo %></td></tr>
	<tr><td>Content</td><td><%= b.getContent() %></td></tr>
	<tr><td>Writer</td><td><%= b.getWriter() %></td></tr>
	<tr><td>Date</td><td><%= b.getDate() %></td></tr>
	</table>
	
	
	
	
	
</body>
</html>