<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="board_wrap">
        <div class="board_title">
            <h2>글 쓰기</h2>
        </div>
        <div class="board_write_wrap">
        <form action="board.write" method="post">
        	<input name="token" value="${token }" type="hidden">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" placeholder="제목 입력" name="b_title"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>작성자</dt>
                        <dd>${sessionScope.loginMember.u_id}</dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea placeholder="내용 입력" name="b_txt"></textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button id="update_btn">등록</button>
                <a href="board.go" >취소</a>
            </div>
            </form>
        </div>
    </div>
</body>
</html>