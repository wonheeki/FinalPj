<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="board_wrap">
      <div class="board_title">
         <h2>글 수정하기</h2>
      </div>
      <c:forEach var="boards" items="${c1 }">
      <div class="board_write_wrap">
         <form action="board.update?b_no=${boards.b_no }" method="post">
            <input name="token" value="${token }" type="hidden">
            <div class="board_write">
               <div class="title">
                  <dl>
                     <dt>제목</dt>
                     <dd>
                        <input type="text" value="${boards.b_title }" name="b_title">
                     </dd>
                  </dl>
               </div>
               <div class="info">
                  <dl>
                     <dt>작성자</dt>
                     <dd>${sessionScope.loginMember.u_id}</dd>
                  </dl>
               </div>
               <div class="cont">
                  <textarea name="b_txt">${boards.b_txt }</textarea>
               </div>
            </div>
            <div class="bt_wrap">
               <button id="update_btn">수정</button>
               <a href="board.go">목록</a>
            </div>
         </form>
      </div>
      </c:forEach>
   </div>

</body>
</html>