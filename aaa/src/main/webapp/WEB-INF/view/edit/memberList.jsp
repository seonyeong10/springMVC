<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
<form action="#">
	<table border=1>
		<tr>
			<td colspan="3">회원 리스트</td>
			<td>회원 수 : ${count }</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list }" varStatus="status" var = "list">
		<tr>
			<td>${status.count }</td>
			<td>${list.userName }</td>
			<td><a href="memberInfoDetail?userId=${list.userId }">${list.userId }</a></td>
			<td>
				<fmt:formatDate value="${list.userRegist }" type="date" pattern="yyyy-MM-dd"/>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<!-- 페이지바 -->
			<th colspan="3">
				<%@ include file="../include/includePage.jsp" %>
			</th>
			<td><a href="<c:url value='/main'/>">홈으로</a></td>
		</tr>
	</table>
</form>
</body>
</html>