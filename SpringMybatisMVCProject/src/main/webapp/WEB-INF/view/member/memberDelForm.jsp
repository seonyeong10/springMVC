<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberDelForm</title>
</head>
<body>
<form action="memberDelPro" method="post" name="frm" id="frm">
	비밀번호 : <input type="password" name="userPw" /> <br />
	<div>${err }</div>
	<input type="submit" value="탈퇴"/>
</form>
</body>
</html>