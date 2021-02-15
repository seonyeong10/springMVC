<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberModify</title>
</head>
<body>
<form:form action="memberModifyAct" method="post" name="frm" id="frm" modelAttribute="memberCommand">
<form:hidden path="userId"/>
<form:hidden path="userName"/>
<form:hidden path="userBirth"/>
<form:hidden path="userEmail"/>
	아이디 : ${memberCommand.userId } <br />
	비밀번호 : <input type="password" name="userPw" />
			<form:errors path="userPw"/><br />
	이름 : ${memberCommand.userName } <br />
	생년월일 :
			<fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/>
			<br />
	연락처1 : <form:input path="userPh1"/>
			<form:errors path="userPh1"/><br />
	연락처2 : <form:input path="userPh2"/> <br />
	주소 : <form:input path="userAddr"/>
		  <form:errors path="userAddr"/><br />
	이메일 : ${memberCommand.userEmail } <br />
	관심분야 : 
		<c:set var="interestArr" value="${memberCommand.interest }"/>
		<c:if test="${fn:contains(memberCommand.interest, '`') }">
			<c:set var="interestArr" value="${fn:split(memberCommand.interest,'`') }" />
		</c:if>
		<input type="checkbox" name="interest" value="HTML" 
			<c:forEach items="${interestArr }" var="interest">
			<c:if test="${interest == 'HTML' }">checked='checked'</c:if>
			</c:forEach>
		/>HTML
		<input type="checkbox" name="interest" value="CSS" 
			<c:forEach items="${interestArr }" var="interest">
			<c:if test="${interest == 'CSS' }">checked='checked'</c:if>
			</c:forEach>
		/>CSS
		<input type="checkbox" name="interest" value="JSP" 
			<c:forEach items="${interestArr }" var="interest">
			<c:if test="${interest == 'JSP' }">checked='checked'</c:if>
			</c:forEach>
		/>JSP
		<form:errors path="interest"/>
	<br />
	<input type="submit" value="수정"/>
	<input type="button" value="홈으로" onclick="javascript:location.href='<c:url value="/main"/>'"/>
</form:form>
</body>
</html>