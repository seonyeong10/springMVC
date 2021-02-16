<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberPwForm.jsp</title>
</head>
<body>
<form action="memberPwModify" method="post" name="frm" id="frm">
	비밀번호 확인 : <input type="password" name="userPw"/><br/>
	<div>${err }</div>
	<input type="submit" value = "전송" />
</form>
</body>
</html>