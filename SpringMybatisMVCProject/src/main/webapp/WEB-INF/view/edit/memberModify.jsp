<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/edit/memberModifyPro' />" method="post">
	<input type="hidden" name="userId" value="${memberCommand.userId }"/>
	이름 : ${memberCommand.userName } <br />
	아이디 : ${memberCommand.userId } <br />
	이메일 : ${memberCommand.userEmail } <br />
	생년월일 : <fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd" /> <br />
	성별 : <c:if test="${memberCommand.userGender == 'M' }">남자</c:if> 
 		  <c:if test="${memberCommand.userGender == 'F' }">여자</c:if> <br/>
	주소 : <input type="text" name="userAddr" value = "${memberCommand.userAddr }"/> <br />
	연락처1 : <input type="text" name="userPh1" value = "${memberCommand.userPh1 }"/> <br />
	연락처2 : <input type="text" name="userPh2" value = "${memberCommand.userPh2 }" /> <br />
	등록일 : <fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd" /> <br />
	<input type="submit" value="수     정"/>
	<input type="button" value="취     소" onclick="javascript:history.back();"/>
</form>
</body>
</html>