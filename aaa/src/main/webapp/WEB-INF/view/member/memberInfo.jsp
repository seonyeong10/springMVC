<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
아이디 : ${memberCommand.userId } <br />
이름 : ${memberCommand.userName } <br />
성별 : 
	<c:choose>
		<c:when test="${memberCommand.userGender == 'M' }">
			남자
		</c:when>
		<c:when test="${memberCommand.userGender == 'F' }">
			여자
		</c:when>
	</c:choose>
<br />
생년월일 : 
<fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/>
<br />
연락처1 : ${memberCommand.userPh1 } <br />
연락처2 : ${memberCommand.userPh2 } <br />
주소 : ${memberCommand.userAddr } <br />
이메일 : ${memberCommand.userEmail } <br />
등록일 :
<fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd"/> 
<br />
관심분야 :
	${memberCommand.interest }
<br />


<a href="memberModify">내정보 수정</a> |
비밀번호 변경 |
탈퇴 |
<a href="<c:url value='/main' />">홈으로</a>
</body>
</html>