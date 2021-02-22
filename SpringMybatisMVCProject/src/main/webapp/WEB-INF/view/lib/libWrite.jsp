<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libWrite</title>
</head>
<body>
<form:form action="libWritePro" method="post" modelAttribute="libCommand" enctype="multipart/form-data">
<table border=1>
	<tr>
		<th>제목</th>
		<td>
			<form:input path="boardSubject"/>
			<form:errors path="boardSubject"/>
		</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>
			<form:input path="boardWriter"/>
			<form:errors path="boardWriter"/>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<form:textarea rows="2" cols="10" path="boardContent"></form:textarea>
			<form:errors path="boardContent"/>
		</td>
	</tr>
	<tr>
		<th>파일</th>
		<td>
			<input type="file" multiple="multiple" name="report"/>
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="boardPw"/>
			<form:errors path="boardPw"/>
		</td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="등록"/>
			<input type="button" value="취소" onclick="javascript:location.href='<c:url value="/Lib/libList"/>'"/>
		</th>
	</tr>
</table>
</form:form>
</body>
</html>