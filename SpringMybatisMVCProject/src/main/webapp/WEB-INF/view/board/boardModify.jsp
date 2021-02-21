<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
%>
<%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardModify</title>
</head>
<body>
	<form:form action="../boardModifyPro" method="post" name="frm"
		modelAttribute="boardCommand"
	>
		<input type="hidden" name="boardNum" value="${boardCommand.boardNum }"/>
		<table border="1">
			<tr>
				<th>아이피</th>
				<td>${boardCommand.ipAddr }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<form:input path="boardSubject" value="${boardCommand.boardSubject }" />
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${boardCommand.boardWriter }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<form:input path="boardContent" value="${boardCommand.boardContent }" />
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="boardPw" />
					<form:errors path="boardPw" />
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="submit" value="수정"/>
					<input type="button" value="취소" onclick="javascript:location.href='<c:url value="/board/boardList"/>'"/>
				</th>
			</tr>
		</table>
	</form:form>
</body>
</html>