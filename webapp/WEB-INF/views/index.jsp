<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Up_HomePage</title>
<link rel="icon" href="resources/img/up_logo.png">
<link rel="apple-touch-icon" href="resources/img/up_logo.png">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" media="(max-width : 1024px)"href="resources/css/main_medium.css">
<link rel="stylesheet" media="(max-width : 768px)" href="resources/css/main_small.css">
<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/signUp.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script defer src="resources/js/main.js"></script>
<link rel="stylesheet" href="resources/css/board.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
<script type="text/javascript" src="resources/js/BookMark.js"></script>
<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
}

#body_section {
	height: auto;
	min-height: 100%;
	padding-bottom: 100px;
}

#footer_section {
	height: 100px;
	position: relative;
	transform: translateY(-100%);
}
.btn.btn--primary {
	margin-top : 10px;
	border: 1px solid #65b836;
	color: #fff;
	background: #55a532 linear-gradient(#91dd70, #55ae2e);
}
.btn_sign_in{
	height: 34px;
    background: #eee linear-gradient(to bottom, #fcfcfc, #eee);
    border: 1px solid #d5d5d5;
    border-radius: 4px;
    display: flex;
    align-items: center;
    padding: 0 12px;
    font-size: 14px;
    font-weight: 500;
    line-height: 1.5;
    cursor: pointer;
    box-sizing: border-box;
    position: relative;
    color: #333;
}
.btn_sign_up{
	height: 34px;
    border-radius: 4px;
    display: flex;
    align-items: center;
    padding: 0 12px;
    font-size: 14px;
    font-weight: 500;
    line-height: 1.5;
    cursor: pointer;
    box-sizing: border-box;
    position: relative;
	border: 1px solid #65b836;
    color: #fff;
    background: #55a532 linear-gradient(#91dd70, #55ae2e);
    margin-left: 5px;
} 
</style>
</head>
<body>
	<div class="body__container" id="body_section">

		<!-- HEADER -->
		<header class="section">
			<div class="inner clearfix" id="header_section">

				<div class="menu-group float--left">
					<div class="up_logo">
						<a href="home.go"><img src="resources/img/up_logo.png" id="logoImg"
							style="width: 30px;"></img></a>
					</div>
					<ul class="main-menu toggle">
						&nbsp&nbsp&nbsp
						<li><a href="map.go">Map</a></li>
						<li><a href="board.go">Board</a></li>
						<li><a href="member.notice.go">Notice</a></li>
						<c:choose>
							<c:when test="${sessionScope.loginMember.u_id == null }">
								<li id="mypage_go"><a href="home.go">MyPage</a></li>
								<script type="text/javascript">
									$(function() {
										$('#mypage_go').click(function() {
											alert("로그인 후 사용가능한 기능입니다.");
										});
									});
								</script>
							</c:when>
							<c:otherwise>
								<li><a href="member.mypage.go">MyPage</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>

				<div class="sign-group float--right toggle">
					<c:choose>
						<c:when test="${sessionScope.loginMember.u_id == null }">
							<div class="btn-group">
								<a href="member.login.go" class="btn_sign_in">Sign in</a> 
								<a href="member.signUp.go" class="btn_sign_up">Sign up</a>
							</div>
						</c:when>
						<c:otherwise>
							<span style="margin-top: 10px;">${sessionScope.loginMember.u_name }님
								환영합니다.</span>&nbsp&nbsp&nbsp&nbsp
							<a href="member.logout" class="btn_sign_up" id ="logout_real">Logout</a>
							<script type="text/javascript">
									$(function() {
										$('#logout_real').click(function() {
											alert("로그아웃 되었습니다.");
										});
									});
							</script>
						</c:otherwise>
					</c:choose>
				</div>

				<div id="toggle-btn">Header Menu Toggle Button</div>

			</div>
		</header>

		<jsp:include page="${cp }" />
		
		</div>

		<!-- FOOTER -->
		<footer class=" section">
			<div class="inner clearfix" id="footer_section">

				<ul class="site-links float--right">
					<li><a href="http://seoul.dfsc.or.kr/main/index.php">서울장애인가족지원센터</a></li>
					<li><a href="http://together-seoul.org/">서울장애인복지관협회</a></li>
					<li><a href="http://www.ssad.or.kr/main/main.php">서울장애인체육회</a></li>
				</ul>

				<ul class="site-links float--left">
					<li><a href="https://wis.seoul.go.kr/handicap/happySeoul.do">서울복지포털</a></li>
					<li><a
						href="https://jobable.seoul.go.kr/jobable/Main.do?method=getMain">장애인일자리
							통합지원센터</a></li>
					<li><a href="http://seoulcbid.or.kr/#1">서울장애인종합복지관</a></li>
				</ul>

				<a href="#" class="logo"> <img src="resources/img/up_logo2.jpg"
					style="width: 30px;"> <path fill-rule="evenodd"
						d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.013 8.013 0 0 0 16 8c0-4.42-3.58-8-8-8z">
					</path> </svg>
				</a>

			</div>
		</footer>

	

</body>
</html>