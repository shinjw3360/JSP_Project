<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 보기화면</h1>
	
	<table>
		<tr>
			<th>no.</th>
			<th>title</th>
			<th>writer</th>
			<th>regdate</th>
		</tr>
		
		<tbody>
			<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.bno}</td>
				<td><a href="/brd/details?bno=${b.bno}">${b.title}</a></td>
				<td>${b.writer}</td>
				<td>${b.regdate}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/index.jsp">index로 이동</a>
</body>
</html>