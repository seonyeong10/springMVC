<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfoDetail</title>
</head>
<body>
<form action="#" method="post" name="frm" id="frm">
아이디 : ${memberCommand.userId }  <br />
이름 : ${memberCommand.userName }  <br />
성별 :
<c:choose>
	<c:when test="${memberCommand.userGender == 'M'}">남자</c:when>
	<c:when test="${memberCommand.userGender == 'F'}">여자</c:when>
</c:choose><br />
생년월일 : <fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd"/> <br />
연락처1 : ${memberCommand.userPh1 } <br />
연락처2 : ${memberCommand.userPh2 }  <br />
주소 : ${memberCommand.userAddr } <br />
이메일 : ${memberCommand.userEmail }  <br />
등록일 : <fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd"/><br /><br />
<input type="button" value="수         정" id="modify" onclick="modifyMember();"/>
<input type="button" value="삭         제" id="delete" onclick="deleteMember();"/>
<input type="button" value="회원리스트" onclick="<c:url value='/edit/memberList'/>"/>
</form>
<script type="text/javascript">
	function modifyMember(){
		location.href="<c:url value='/edit/modifyMember/${memberCommand.userId }' />";
	}
	function deleteMember(){
		location.href="<c:url value='/edit/deleteMember/${memberCommand.userId }' />";
	}
</script>
</body>
</html>