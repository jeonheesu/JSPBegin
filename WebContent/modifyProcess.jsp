<%@page import="service.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문페이지입니다.</title>


</head>
<body>

	<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	
	String bNo = request.getParameter("bNo");
	String bTitle = request.getParameter("bTitle");
	String bContent = request.getParameter("bContent");

	BoardDAO dao = new BoardDAO();
	dao.modiBoard(bNo, bTitle, bContent);
	
	response.sendRedirect("boardContent.jsp?bNo="+bNo);
	
	%>


</body>
</html>