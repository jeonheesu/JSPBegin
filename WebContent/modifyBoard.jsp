<%@page import="model.BoardDTO"%>
<%@page import="service.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="/JSPBegin/css/mine.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<body>





   <%
   
     String bNo = request.getParameter("bNo");
   
       BoardDAO dao = new BoardDAO();
       BoardDTO dto = dao.boardSelectOne(bNo);
       
       
   
   
   %>

	<h1>글 상세보기</h1>
	
	<form id="modifyForm" action="modifyProcess.jsp" method="post">
	
	
	<input type="hidden" name="bNo" id="bNo" value="<%=dto.getbNo()%>">

	<h3>
		글 제목: 
		<span>
		<input type="text" name="bTitle" id="bTitle" value="<%=dto.getbTitle() %>">
		
	</h3>

	<h3>
		글 내용: 
		<span>
		<input type="text" name="bContent" id="bContent" value="<%=dto.getbContent()%>">
		</span>
	</h3>


	<h3>
		작성자: 
		<span><%=dto.getbWriter() %></span>
	</h3>


	<h3>
		 작성일: 
		<span><%=dto.getbRegDate() %></span>
	</h3>
	
	
	<input type="button"   id="modifyBtn" value="수정하기">
	 </form>

		
	
	
	
	
	




<script type="text/javascript" src="js/mine.js"></script>
</body>
</html>