<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="4">게시글 수 : ${count }</th>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:if test="${count >0 }">
		<c:forEach items="${list }" var="list" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td><a href="boardInfo?boardNum=${list.boardNum }">${list.boardSubject }</a></td>
				<td>${list.boardWriter }</td>
				<td><fmt:formatDate value="${list.boardRegist }" type="date" pattern="yyyy-MM-dd"/> </td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${count <= 0 }">
		<tr>
			<th colspan="4">등록된 게시글이 없습니다.</th>
		</tr>
		</c:if>
		<tr>
			<th colspan="4">
				<%@ include file="../include/includePage.jsp"%>
			</th>
		</tr>
	</table>
	<a href="boardWrite">게시글 등록</a>
</body>
</html>