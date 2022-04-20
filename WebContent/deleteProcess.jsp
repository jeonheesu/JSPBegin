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
   
    String bNo = request.getParameter("bNo");
     BoardDAO dao = new BoardDAO();
       dao.boardDelete(bNo);

   
   
   %>
	
<script type="text/javascript">
location.href="board.jsp"</script>
</body>
</html>