<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>member.jsp</title>
</head>
<body>
	<% 
	    request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("myName");
		String id = request.getParameter("ID");
		String major = request.getParameter("major");
		String sex = request.getParameter("SEX");
		out.print("�̸���: " + name + ", " +" ID��: "+ id +" ������: " + major + " ������: " + sex);
	%>
</body>
</html>