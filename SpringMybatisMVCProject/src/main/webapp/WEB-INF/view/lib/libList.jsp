<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LibList</title>
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
	<c:forEach items="${list }" var="list" varStatus="status">
	<tr>
		<td>${status.count }</td>
		<td><a href="libInfo?boardNum=${list.boardNum }">${list.boardSubject }</a></td>
		<td>${list.boardWriter }</td>
		<td>
			<fmt:formatDate value="${list.boardRegist }" type="date" pattern="yyyy-MM-dd"/> 
		</td>
	</tr>
	</c:forEach>
	<tr>
		<th colspan="4">
			<%@ include file="../include/includePage.jsp" %>
		</th>
	</tr>
</table>

<a href="libWrite">등록</a><br />
<a href="<c:url value='/main'/>">홈으로</a><br />

</body>
</html>