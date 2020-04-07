<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>getData.jsp</title>
</head>
<body>
	<% 
	    request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("myName");
		String major = request.getParameter("myMajor");
		out.print("이름은: " + name + ", " + "전공은: " + major);
	%>
</body>
</html>