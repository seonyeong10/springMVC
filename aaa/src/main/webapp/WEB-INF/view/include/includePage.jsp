<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"
%>
<c:if test="${page <= 1 }">[이전]</c:if>
<c:if test="${page > 1 }">
	<a href="${pageURL }page=${page - 1 }">[이전]</a>
</c:if>

<c:forEach begin="${startBarNum }" end="${endBarNum }" var="i" step="1">
	<a href="${pageURL }page=${i }">${i }</a>&nbsp;&nbsp;
</c:forEach>
				
<c:if test="${page >= maxPageBar }">[다음]</c:if>
<c:if test="${page < maxPageBar }">
	<a href="${pageURL }page=${page + 1 }">[다음]</a>
</c:if>