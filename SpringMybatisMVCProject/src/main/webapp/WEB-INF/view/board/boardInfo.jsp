<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInfo</title>
</head>
<body>
<table border="1">
	<tr>
		<th>아이피</th>
		<td>${boardCommand.ipAddr }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${boardCommand.boardSubject }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${boardCommand.boardWriter }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${boardCommand.boardContent }</td>
	</tr>
	<tr>
		<th colspan="2">
			<c:if test="${authInfo.userId == boardCommand.userId }">
				<a href="boardModify/${boardCommand.boardNum }">수정</a>
				<a href="boardDel/${boardCommand.boardNum }">삭제</a>
			</c:if>
			<a href="javascript:location.href='<c:url value="/board/boardList" />'">리스트로</a>
		</th>
	</tr>
</table>
</body>
</html>