<%@page import="service.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%
request.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");
 String bTitle = request.getParameter("bTitle");
String bContent = request.getParameter("bContent");
String bWriter = request.getParameter("bWriter");

BoardDAO dao = new BoardDAO();
dao.boardInsert(bTitle, bContent, bWriter);





%>

<script type="text/javascript">
location.href="board.jsp";
</script>

작성된 제목 :<%=bTitle %>  <br>
작성된 제목 :<%=bContent %><br>
작성된 제목 :<%=bWriter %>
</body>
</html>