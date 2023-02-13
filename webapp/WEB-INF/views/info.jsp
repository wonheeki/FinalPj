<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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

#update-form {
   width: 440px;
   margin-top: 16px;
   margin-left: auto;
   margin-right: auto;
   padding-left: 0px;
}

#update-form li {
   margin-bottom: 17px;
}

#update-form li:last-child {
   margin-bottom: 0;
}

#update-form .input--text {
   width: 100%;
   height: 40px;
}

#update-form .caption {
   font-size: 12px;
   margin-top: 5px;
   color: rgba(255, 255, 255, .6);
   line-height: 1.5;
   text-align: center;
}

#update-form [type="submit"] {
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

.btn_Update {
   width:100%;
   height:62px;
   margin-top : 10px;
   border: 1px solid #65b836;
   color: #fff;
   background: #55a532 linear-gradient(#91dd70, #55ae2e);
   font-size: 20px;
   border-radius: 5px;
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
p{
   margin-top : 20px;
   margin-bottom : 0px;
   text-align: center;
   font-size: 20px;
   color: #A9A9A9;
}
.loginImg{
   width: 100%;
   height:62px;
   margin: 0px;
   text-align : center;
   display: inline-block;
}
.img{
   text-align : center;
   margin-left: auto;
   margin-right: auto;
}
a{
	text-decoration: none;
	color:gray;
}

.list{
	display:inline-block;
	float:left;
	margin : 30px 10px 0px 10px;
	
}
#mylist{
	display: flex;
  	justify-content: center;
	color:gray;
}
#li1{
	border-bottom:solid 3px #81D15F;
	padding-bottom:3px;
	margin-top:29px;
	
}

#u_update{
	font-weight:bold;
	color:black;
	
}
</style>
</head>
<body>
	<h2>마이페이지</h2>
	<br/>
	<div id ="mylist">
		<div class="list" id="li1"><a id ="u_update" href="member.mypage.go">회원정보 수정</a></div>
		<div class="list" id="li2"><a id="u_write_chk" href="member.writeList.go">내가 쓴 글 보기</a></div>
		<div class="list" id="li3"><a id="u_bookmark" href="member.likeList.go?u_id=${sessionScope.loginMember.u_id }">내가 추가한 즐겨찾기</a></div>
	</div>
	<br/>
   <form id="update-form" method="POST" action="member.update" onsubmit="return checkValidMyInFo();" name="updateform">
      <ul>
         <li><input type="text" class="input--text"
            value="${sessionScope.loginMember.u_id }" autocomplete="off" readonly="readonly" id="u_id" maxlength="10" name="u_id"></li>
         <li><input type="password" class="input--text"
            value="${sessionScope.loginMember.u_pw }" placeholder="비밀번호를 입력하세요" id="u_pw" maxlength="15" name="u_pw"></li>
         <li><input type="password" class="input--text"
            value="${sessionScope.loginMember.u_pw }" placeholder="비밀번호를 다시 입력하세요" id="u_repw" maxlength="15" name="u_repw"></li>
         <li><input type="text" class="input--text"
            value="${sessionScope.loginMember.u_name }" placeholder="이름을 입력하세요" id="u_name" maxlength="5" name="u_name"></li>
         <li><input type="text" class="input--text"
            value="${sessionScope.loginMember.u_nickname }" placeholder="닉네임을 입력하세요" id="u_nickname" maxlength="10" name="u_nickname"></li>
         <li><input type="email" class="input--text"
            value="${sessionScope.loginMember.u_email }" placeholder="이메일을 입력하세요" id="u_email" name="u_email"></li>
         <li><input type="text" class="input--text"
            value="${sessionScope.loginMember.u_tel}" placeholder="핸드폰 번호를 입력하세요 (-를 제외하고 입력해주세요)" id="u_tel" name="u_tel"></li>
         <li><input type="text" class="input--text"
            value="${addr[2] }" placeholder="우편번호를 입력하세요" id="u_addr1" readonly="readonly" name="u_addr1"></li>
         <li><input type="text" class="input--text"
            value="${addr[0] }" placeholder="기본주소" id="u_addr2" readonly="readonly" name="u_addr2"></li>
         <li><input type="text" class="input--text"
            value="${addr[1] }" placeholder="상세주소" id="u_addr3" name="u_addr3"></li>
         <li>
            <button class="btn_Update">수정하기</button>
         </li>
          </form>
         <li>
         	<button id="resignBtn" class="btn_Update">회원탈퇴</button>
         </li>
         <br>

      </ul>
  
</body>
</html>