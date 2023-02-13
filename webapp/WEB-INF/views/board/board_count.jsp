<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/go.js"></script>
</head>
<body>
	<div class="board_wrap">
		<div class="board_title">
			<h2>자유게시판</h2>
		</div>
		<div class="bt_wrap">
			<a href="board.go" class="count">최신순</a>
			<a href="board.count.go" class="count">조회순</a>
			<a href="board.write.go" class="on">글쓰기</a>
			<!--<a href="#">수정</a>-->
		</div>
		<div class="board_list_wrap">
			<div class="board_list">
				<div class="top">
					<div class="num">번호</div>
					<div class="title">제목</div>
					<div class="writer">작성자</div>
					<div class="date">작성일</div>
					<div class="count">조회</div>
				</div>
				<c:forEach var="b" items="${msgs }">
					<div>
						<div class="num">${b.rn }</div>
						<div class="title">
							<a href="board.view.go?b_no=${b.b_no }">${b.b_title }</a>
						</div>
						<div class="writer">${b.b_writer}</div>
						<div class="date">
							<fmt:formatDate value="${b.b_regDate }" timeStyle="short" />
						</div>
						<div class="count">${b.b_readCounter }</div>
					</div>
				</c:forEach>
			</div>
			<!-- 페이징 -->
			<div class="board_page">
				<c:set var="page" value="${(param.p == null)?1:param.p }" />
         		<c:set var="startNum" value="${page-(page-1)%5}" />
         		<c:set var="lastNum" value="${allPageCount }" />
         		
				<c:if test="${startNum != 1 }">
					<a href="boardCount.page.change?p=${curPage-5 }" class="bt prev">&lt;&lt;</a>
				</c:if>
				<c:if test="${curPage != 1 }">
					<a href="boardCount.page.change?p=${curPage-1 }" class="bt prev">&lt;</a>
				</c:if>
				<c:if test="${curPage <= allPageCount }">
					<c:forEach var="i" begin="0" end="4">         
	               		<c:if test="${startNum+i <= lastNum }">
	               			<a href="boardCount.page.change?p=${startNum+i}" class = num>${startNum+i }</td>
	               		</c:if>
	            	</c:forEach>
            	</c:if>
				<c:if test="${curPage < allPageCount }">
					<a href="boardCount.page.change?p=${curPage+1 }" class="bt next">&gt;</a>
					<a href="boardCount.page.change?p=${curPage+5 }" class="bt next">&gt;&gt;</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>