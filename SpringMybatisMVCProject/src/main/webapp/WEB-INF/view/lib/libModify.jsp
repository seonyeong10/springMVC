<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../include/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>libModify</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.form.js'/>"></script>
</head>
<body>
<form action="../libmodifyPro" method="post" >
	<input type="hidden" name="boardNum" value="${list.boardNum }"/>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="boardSubject" value="${list.boardSubject }"/>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>
				${list.boardWriter }
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<input type="text" name="boardContent" value="${list.boardContent }"/>
<%-- 				<textarea rows="2" cols="10" name="boardContent" >${list.boardContent }</textarea> --%>
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<c:set var="store" value="${fn:split(list.storeFileName, '`') }"/>
				<c:set var="fileSize" value="${fn:split(list.fileSize, '`') }"/>
				<c:forTokens items="${list.originalFileName }" delims="`" var="org" varStatus="idx">
					<a href="<c:url value='/lib/upload/${store[idx.index] }'/>">${org } / ${fileSize[idx.index] }</a>
					<input type="button" value="삭제" onclick="fileDel('${store[idx.index]}','${org }','${fileSize[idx.index] }',this);"/>
				</c:forTokens>
			</td>
		</tr>
		<tr>
			<th>파일추가</th>
			<td>
				<input type="file" name="report" multiple="multiple"/>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="boardPw"/><br />
				<div>${err }</div>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="수정"/>
				<input type="button" value="홈으로" onclick="javascript:location.href='<c:url value="/main"/>'"/>
			</th>
		</tr>
	</table>
</form>
<script type="text/javascript">
	function fileDel(strFile, orgFile, fileSize, btn) {
		$.ajax({
			type:"post",
			url:"../fileDel",
			dataType:"text",
			data:{"originalFileName":orgFile, "storeFileName":strFile, "fileSize":fileSize},
			success: function(result){
				alert(result);
				if(result.trim() == "1"){
					$(btn).val('취소');
				} else {
					$(btn).val('삭제');
				}
			},
			errors: function() {
				alert('에러');
				return;
			}
		});
	}
</script>
</body>
</html>