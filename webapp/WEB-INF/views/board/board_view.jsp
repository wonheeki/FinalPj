<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UP_BoardView</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/ValidCheck.js"></script>
<style type="text/css">
.form-control {
	height: 50px;
	width: 300px;
}
.input-group-text {
	width: 50px;
}

input::placeholder {
	font-size: 15px;
	font-style: italic;
	justify-content: center;
}

.cmBtn {
	margin: auto;
	padding: 5px; color : #495057;
	background: #E9ECEF;
	color: #495057;
}
.ctd{
	font-size: 19px;
}
.ctd1{
	width:170px;
	font-size: 15px;
	color:#7e7d7d;
}
.cmBtn{
	margin-right: 4px;
    margin-top: 10px;
    border-radius: 5px;
    margin-bottom: 10px;
    border: 0;
    outline: 0;
}

</style>
</head>
<body>
	<div class="board_wrap">
		<div class="board_title">
			<h2>자유게시판</h2>
		</div>
		<c:forEach var="boards" items="${c1 }">
			<div class="board_view_wrap">
				<div class="board_view">
					<input name="token" value="${token }" type="hidden">
					<div class="title">${boards.b_title }</div>
					<div class="info">
						<dl>
							<dt>글쓴이</dt>
							<dd>${boards.b_writer }</dd>
						</dl>
						<dl>
							<dt>작성일</dt>
							<dd>
								<fmt:formatDate value="${boards.b_regDate }" timeStyle="short" />
							</dd>
						</dl>
						<dl>
							<dt>조회</dt>
							<dd>${boards.b_readCounter }</dd>
						</dl>
					</div>
					<div class="cont">${boards.b_txt }</div>
				</div>

				<div class="board_answer">
					<br>
					<h2>댓글</h2>
					<p>
						<input name="token" value="${token1 }" type="hidden">
						<c:if test="${sessionScope.loginMember != null }">
							<table>
								<tr>
									<td>

										<table>
											<tr>
												<td>
													<form action="board.comment.write" method="get">
														<input name="token" value="${token }" type="hidden">
														<input name="b_no" value="${boards.b_no }" type="hidden">

														<div class="input-group mb-3">
															<input name="c_writer" autocomplete="off"
																value="${sessionScope.loginMember.u_id }"
																class="input-group-text"> 
															<input name="c_txt"
																maxlength="100" placeholder="댓글을 입력하시오."
																autocomplete="off" id="c_txt" class="form-control">
															<button class="btn btn-secondary btn-lg"
																style="height: 50px; color: #333;">댓글쓰기</button>
														</div>
													</form>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</c:if>
						<c:forEach var="tpc" items="${boards.b_comment }">
							<table class="cmTbl">
								<tr>
									<td>
										<table>
											<tr>
												<td class="ctd">${tpc.c_writer }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
												<td class="ctd">${tpc.c_txt }</td>
											</tr>
											<tr>
												<td class="ctd1"><fmt:formatDate value="${tpc.c_regDate }"
														type="both" dateStyle="short" timeStyle="short" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
												<c:if
													test="${tpc.c_writer == sessionScope.loginMember.u_id }">
													<td class="ctd2">
														<button class="cmBtn"
															onclick="commentUpdate(${tpc.c_no},'${tpc.c_txt }',${tpc.b_no })">댓글수정</button>
														<a href="board.comment.delete?c_no=${tpc.c_no }&b_no=${tpc.b_no}" class="cmBtn">댓글삭제</a>
													</td>
													</tr>
											<tr>
												<td colspan="2"><hr style="border: dashed 0.5px #ddd; width: 1000px;"></td>
											</tr>
											</c:if>
											
										</table>
									</td>
								</tr>
							</table>
						</c:forEach>
				</div>
				<div class="bt_wrap">
					<a href="board.go" class="on" id="list_btn">목록</a>
					<c:if test="${boards.b_writer == sessionScope.loginMember.u_id }">
						<a id="edit_btn" href="board.edit.go?b_no=${boards.b_no }">수정</a>
						<a id="delete_btn" href="board.delete?b_no=${boards.b_no }">삭제</a>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>