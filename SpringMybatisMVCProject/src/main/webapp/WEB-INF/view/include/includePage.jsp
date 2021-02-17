<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 현재페이지가 1페이지 일때 기능없는 이전 -->
				<c:if test="${page <= 1 }">
					[이전]
				</c:if>
				<c:if test="${page > 1 }">
					<a href="${pageURL }page=${page - 1}">[이전]</a>
				</c:if>
				
				<c:forEach begin="${startPage }" end="${endPage }" var="i" step="1">
					<a href="${pageURL }page=${i}">[${i }]</a>&nbsp;&nbsp;
				</c:forEach>
				
				<c:if test="${page < maxPage }">
					<a href="${pageURL }page=${page + 1}">[다음]</a>
				</c:if>
				<c:if test="${page >= maxPage }">
					[다음]
				</c:if>