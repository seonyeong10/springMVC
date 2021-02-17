<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jquery/jquery-3.2.1.js"></script>
<script >
	// 쿼리스트링을 경로처럼 사용
	$(function(){
		$('#modify').click(function(){
			location.href='<c:url value="/edit/memberModify/${memberCommand.userId}"/>';
		});
		$('#memDel').click(function(){
			if(confirm('정말로 탈퇴하시겠습니까?')) {
				location.href='<c:url value="/edit/memberDelete/${memberCommand.userId}"/>';
			}
		});
	});
</script>
</head>
<body>
<form action="#" method="post" name="frm" id="frm">
이름 : ${memberCommand.userName } <br />
아이디 : ${memberCommand.userId } <br />
이메일 : ${memberCommand.userEmail } <br/>
생년월일 : <fmt:formatDate value="${memberCommand.userBirth }" type="date" pattern="yyyy-MM-dd" /> <br />
성별 : <c:if test="${memberCommand.userGender == 'M' }">남자</c:if> 
 <c:if test="${memberCommand.userGender == 'F' }">여자</c:if> <br/>
연락처1 : ${memberCommand.userPh1 } <br/>
연락처2 : ${memberCommand.userPh2 } <br/>
주소 : ${memberCommand.userAddr }	<br />
등록일 : <fmt:formatDate value="${memberCommand.userRegist }" type="date" pattern="yyyy-MM-dd" /> <br/>
<input type="button" value="수          정" id="modify"/>
<input type="button" value="탈         퇴" id="memDel"/>
<input type="button" value="회원리스트" onclick="javascript:history.back();"/>
</form>
</body>
</html>