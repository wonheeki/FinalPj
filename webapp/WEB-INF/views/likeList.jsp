<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
   src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/ValidCheck.js"></script>
<script type="text/javascript" src="resources/js/LeeValidChecker.js"></script>
<style type="text/css">
@import
   url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Roboto&display=swap')
   ;

* {
   font-family: 'Noto Sans KR', sans-serif;
   font-family: 'Roboto', sans-serif;
   display: center;
   margin: auto;
}

#sign-form {
   width: 440px;
   margin-top: 16px;
   margin-left: auto;
   margin-right: auto;
   padding-left: 0px;
}

#sign-form li {
   margin-bottom: 17px;
}

#sign-form li:last-child {
   margin-bottom: 0;
}

#sign-form .input--text {
   width: 100%;
   height: 40px;
}

#sign-form .caption {
   font-size: 12px;
   margin-top: 5px;
   color: rgba(255, 255, 255, .6);
   line-height: 1.5;
   text-align: center;
}

#sign-form [type="submit"] {
   width: 100%;
   height: 62px;
   padding: 0 25px;
   font-size: 20px;
   justify-content: center;
}

ul {
   list-style: none;
   padding-left: 0px;
}

.input--text {
   height: 34px;
   padding: 0 10px;
   border: 1px solid #ddd;
   border-radius: 5px;
   box-sizing: border-box;
   outline: none;
   box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.075);
   font-size: 16px;
}

.input--text:focus {
   border-color: #51a7e8;
   box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.075), 0 0 5px
      rgba(81, 167, 232, 0.5);
}

/* Vendor Prefix(브라우저 업체별 접두사) */
.input--text::-webkit-input-placeholder {
   color: #A9A9A9;
}

.input--text::-ms-input-placeholder {
   color: #A9A9A9;
}

.input--text::-moz-input-placeholder {
   color: #A9A9A9;
}

.btn.btn--primary {
   width: 100%;
   height: 62px;
   margin-top: 10px;
   border: 1px solid #65b836;
   color: #fff;
   background: #55a532 linear-gradient(#91dd70, #55ae2e);
   font-size: 20px;
}

h2 {
   margin-top: 50px;
   text-align: center;
   font-size: 3rem;
   font-weight:bold;
}


hr {
   background-color: #A9A9A9;
   margin-top: 30px;
}

p {
   margin-top: 20px;
   margin-bottom: 0px;
   text-align: center;
   font-size: 20px;
   color: #A9A9A9;
}

.loginImg {
   width: 100%;
   height: 62px;
   margin: 0px;
   text-align: center;
   display: inline-block;
}

.img {
   text-align: center;
   margin-left: auto;
   margin-right: auto;
}

a {
   text-decoration: none;
   color: gray;
}

.list {
   display: inline-block;
   float: left;
   margin: 30px 20px 0px 0px;
}

#mylist {
   display: flex;
   justify-content: center;
   text-align: center;
   color: gray;
}

#li3 {
   border-bottom: solid 3px #81D15F;
   padding-bottom: 3px;
   margin-top: 29px;
}

#u_bookmark {
   font-weight: bold;
   color: black;
}
.top{
   text-align: center;
}
.like_type{
	width:300px;
	text-align:center;
}
.like_title{
	width:400px;
	text-align:center;
}
.like_rmv{
	width:300px;
	text-align:center;
}
</style>
</head>
<body>
   <h2>마이페이지</h2>
   <br />
   <div id="mylist">
      <div class="list" id="li1">
         <a id="u_update" href="member.mypage.go">회원정보 수정</a>
      </div>
      <div class="list" id="li2">
         <a id="u_write_chk" href="member.writeList.go">내가 쓴 글 보기</a>
      </div>
      <div class="list" id="li3">
         <a id="u_bookmark" href="member.likeList.go?u_id=${sessionScope.loginMember.u_id }">내가 추가한 즐겨찾기</a>
      </div>
   </div>
   <div class="board_wrap">
      <div class="board_title"></div>
      <div class="board_list_wrap">
         <div class="board_list">
            <div class="top">
               <div class="num">종류</div>
               <div class="title">즐겨찾기 제목</div>
               <div class="count">삭제</div>
            </div>
            
            <c:forEach var="bb" items="${book }">
               <div>
                  <div class="like_type">지하철</div>
                  <div class="like_title">
                     <a href="map.view.go?sub_no=${bb.sub_no }"> ${bb.sub_station }${bb.sub_line_name }</a>
                  </div>
                  <div class="like_rmv"><a href="map.deleteMyBk?u_id=${loginMember.u_id  }&sub_no=${bb.sub_no }">즐겨찾기 삭제</a></div>
               </div>
            </c:forEach>
            <c:forEach var="ff" items="${book2 }">
               <div>
                  <div class="like_type">공공시설</div>
                  <div class="like_title">
                     <a href="facMap.View.go?f_no=${ff.f_no }"> ${ff.f_fclt_nm }</a>
                  </div>
                  <div class="like_rmv"><a href="map.deleteMyBk?u_id=${loginMember.u_id  }&f_no=${ff.f_no }">즐겨찾기 삭제</a></div>
               </div>
            </c:forEach>
            <c:forEach var="cc" items="${book3 }">
               <div>
                  <div class="like_type">휠체어충전소</div>
                  <div class="like_title">
                     <a href="chargeMap.View.go?ch_no=${cc.ch_no }"> ${cc.ch_FCLTYNM }</a>
                  </div>
                  <div class="like_rmv"><a href="map.deleteMyBk?u_id=${loginMember.u_id  }&ch_no=${cc.ch_no }">즐겨찾기 삭제</a></div>
               </div>
            </c:forEach>
         </div>
         <div>
         </div>
      </div>
   </div>

</body>
</html>