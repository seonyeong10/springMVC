<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${list.boardSubject }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${list.boardWriter }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${list.boardContent }</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<c:set var="store" value="${fn:split(list.storeFileName, '`') }"/>
				<c:set var="fileSize" value="${fn:split(list.fileSize, '`') }"/>
				<c:forTokens items="${list.originalFileName }" delims="`" var="org" varStatus="idx">
					<a href="<c:url value='/lib/upload/${store[idx.index] }'/>">${org } / ${fileSize[idx.index] }</a>
				</c:forTokens>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<c:if test="${authInfo.userId == list.userId }">
					<a href="libModify/${list.boardNum }">수정</a>
					<a href="libDelete/${list.boardNum }">삭제</a>
				</c:if>
				<a href="<c:url value='/lib/libList'/>">리스트</a>
			</th>
		</tr>
	</table>
</body>
</html>