<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDetail.jsp</title>
</head>
<body>
<!-- EL 는 자동으로 getter를 실행시킨다 -> 게터 없으면 없다고 에러뜸  -->
<!-- getUserName()써도 됨 -->
이름 : ${memberCommand.userName } <br />
아이디 : ${memberCommand.userId } <br />
이메일 : ${memberCommand.userEmail } <br />
생년월일 : <fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/> <br />
<!-- 스프링에서는 스크립틀릿 사용 안하고 jstl 사용 -->
<!-- 컴파일되면 스크립틀릿으로 바뀜 -->
<!-- choose = select case -->
성별 : 
	<c:choose>
		<c:when test="${memberCommand.userGender == 'M'}">
			남자
		</c:when>
		<c:when test="${memberCommand.userGender == 'F'}">
			여자
		</c:when>
	</c:choose>
	<br />
연락처1 : ${memberCommand.userPh1 } <br />
연락처2 : ${memberCommand.userPh2 } <br />
등록일 : <fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd"/> <br />
취미 : ${memberCommand.interest } <br />
<p>
	<a href="memberModify">내정보 수정</a> | 
	비밀번호 변경 | 
	탈퇴 | 
	홈으로
</p>

</body>
</html>