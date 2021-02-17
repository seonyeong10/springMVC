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
<form action="<c:url value='/edit/modifyMemberPro'/>" method="post" name="frm" id="frm">
<input type="hidden" name="userId" value="${memberCommand.userId }"/>
아이디 : ${memberCommand.userId }  <br />
이름 : ${memberCommand.userName }  <br />
성별 :
<c:choose>
	<c:when test="${memberCommand.userGender == 'M'}">남자</c:when>
	<c:when test="${memberCommand.userGender == 'F'}">여자</c:when>
</c:choose><br />
생년월일 : <fmt:formatDate value="${list.userBirth }" type="date" pattern="yyyy-MM-dd"/> <br />
연락처1 : <input type="text" name="userPh1" value="${memberCommand.userPh1 }" /> <br />
연락처2 : <input type="text" name="userPh2" value="${memberCommand.userPh2 }" />  <br />
주소 : <input type="text" name="userAddr" value="${memberCommand.userAddr }" /> <br />
이메일 : ${memberCommand.userEmail }  <br />
등록일 : <fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd"/><br />
<br />
<input type="submit" value="수   정" id="modify" />
<input type="button" value="홈으로" onclick="javascript:location.href='../../'"/>
</form>
</body>
</html>