<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit/memberList.jsp</title>
</head>
<body>
	<table border=1>
		<tr>
			<td colspan="3">회원리스트</td>
			<td>회원수 : ${memberCount }</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>등록일</th>
		</tr>
		<!-- index = 0부터 시작, count = 1부터 시작 -->
		<c:forEach items="${memberList }" var="dto" varStatus="status">
		<tr>
			<td>${status.count }</td>
			<td>${dto.userName }</td>
			<td>${dto.userId }</td>
			<td>
				<fmt:formatDate value="${dto.userRegist }" type="date" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>