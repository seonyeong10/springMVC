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
<form:form action="memberModifyPro" name="frm" method="post" modelAttribute="memberCommand" onsubmit="frmSubmit();">
<form:hidden path="userId"  />
<form:hidden path="userName"  />
<form:hidden path="userBirth"  />
<form:hidden path="userGender"  />
<form:hidden path="userEmail" />
<!-- 유효성검사를 위한 비밀번호 확인 : dto에 pwCon이 없어 form:태그 사용못함 -->
<input type="hidden" name="userPwCon"/>
	아이디 : ${memberCommand.userId } <br />
	비밀번호 : <input type="password" name="userPw" />
			<form:errors path="userPw"/><br />
	이름 : ${memberCommand.userName } <br />
	생년월일 : 
		<fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/>
	<br />
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
	이메일 : ${memberCommand.userEmail } <br />
	주소 : <form:input path="userAddr" />
		  <form:errors path="userAddr"/><br />
	연락처1 : <form:input path="userPh1" />
			<form:errors path="userPh1"/><br />
	연락처2 : <form:input path="userPh2" /><br />
	관심분야 : 
		<c:set var="interestArr" value="${memberCommand.interest }"/>
		<!-- ` 가 없으면 배열이 아님 -->
		<c:if test="${fn:contains(memberCommand.interest,'`') }">
			<!-- split을 이용해서 데이터를 배열로 가져와 foreach문 사용 -->
			<c:set var="interestArr" value="${fn:split(memberCommand.interest,'`')}" />
		</c:if>
		<!-- 배열값을 하나씩 받아오겠다 -->
		<input type="checkbox" name="interest" value="HTML" 
			<c:forEach items="${ interestArr}" var="interest">
				<c:if test="${interest == 'HTML' }">
					checked='checked'
				</c:if>
			</c:forEach>
		/>HTML
		<input type="checkbox" name="interest" value="CSS" 
			<c:forEach items="${ interestArr}" var="interest">
			<c:if test="${interest == 'CSS' }">
				checked='checked'
			</c:if>
		</c:forEach>
		/>CSS
		<input type="checkbox" name="interest" value="JSP" 
			<c:forEach items="${ interestArr}" var="interest">
			<c:if test="${interest == 'JSP' }">
				checked='checked'
			</c:if>
		</c:forEach>
		/>JSP <br/>
		<input type="submit" value="수정"/>
		<input type="button" value="홈으로" onclick='javascript:location.href="<c:url value='/'/>"' />
</form:form>
<script type="text/javascript">
	function frmSubmit(){
		document.frm.userPwCon.value = document.frm.userPw.value;
		alert("수정이 완료되었습니다.");
		document.frm.submit();
	}
</script>
</body>
</html>