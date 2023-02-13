<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${r=='로그인실패' }">
		<script type="text/javascript">
			alert("로그인에 실패하였습니다.");
		</script>
	</c:if>
	<!-- VISUAL -->
	<section class="section section--visual">
		<div class="inner">

			<div class="summary" style="text-align: center;">
				<h2 class="summary__title">
					UP : <span style="font-size: 30px;">위로, 위쪽으로</span>
				</h2>
				<p class="summary__description">
					장애인들의 삶의 질을 <br>향상 시켜주는 웹 페이지
				</p>
			</div>
			<c:choose>
						<c:when test="${sessionScope.loginMember.u_id == null }">
							<form id="sign-form" method="POST" action="member.login">
								<ul>
									<li><input type="text" class="input--text"
										placeholder="아이디를 입력하세요." name="u_id" id="u_id"></li>
									<li><input type="password" class="input--text" name="u_pw"
										id="u_pw" placeholder="비밀번호를 입력하세요."></li>
									<li><p class="caption" style="text-align: left;">&nbsp&nbsp아이디는
											5글자 이상 10글자 이하입니다.</p></li>
									<li>
										<button type="submit" class="btn btn--primary">로그인 하기</button>
										<p class="caption" style="text-align: left;">
											&nbsp&nbsp위의 개인정보는 웹사이트 내에서만 이용되며, <br>&nbsp&nbsp보다 자세한 사항은
											공지사항을 통해 확인해주십시오.
										</p>
									</li>
								</ul>
							</form>
						</c:when>
						<c:otherwise>
							<div></div>
						</c:otherwise>
					</c:choose>
			

		</div>
	</section>

	<!-- FEATURE-->
	<section class="section section--feature">

		<div class="summary">
			<br>
			<h2 class="summary__title">장애인들을 위한 웹페이지</h2>
			<br> <span class="summary__description"
				style="font-size: 30px; color: #808080;">" UP "</span><span
				class="summary__description"> 은 장애인의 삶의 질 향상을 의미하는 <br>지도
				기반 커뮤니티 웹사이트입니다.
			</span>
		</div>

		<div class="video">
			<div class="video-ratio">
				<iframe width="1905" height="800"
					src="https://www.youtube.com/embed/gBY6QflrcjQ"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
		</div>

		<div class="tiles">
			<div class="inner">

				<ul class="clearfix">
					<li><img src="resources/img/bg_img1.png" alt="build">
						<h3>Only 장애인만을 위한 웹사이트</h3>
						<p>
							UP은 오직 장애인 만을 위한<br>커뮤니티 웹 페이지입니다.<br>(+ 장애인 보호자)
						</p></li>
					<li><img src="resources/img/bg_img2.png" alt="build">
						<h3>다양한 정보들</h3>
						<p>UP에는 병원부터 관공서, 주민센터, 장애인 승강기가 있는 지하철 역까지 다양한 정보가 존재합니다.</p></li>
					<li><img src="resources/img/bg_img3.png" alt="build">
						<h3>1000명이 넘는 사용자</h3>
						<p>
							현재 1000명이 넘는 사용자들이<br> UP 페이지를 이용 중입니다.
						</p></li>
					<li><img src="resources/img/bg_img4.png" alt="build">
						<h3>빠르고 간편하게</h3>
						<p>UP은 타 사이트보다 훨씬 빠르고 간편하게 제작되었습니다.</p></li>
				</ul>

			</div>
		</div>


	</section>

	<!-- Where is -->
	<section class="section section--where-is">
		<div class="inner">

			<div class="summary">
				<br>
				<div class="summary__title">Where is 서울 장애인 복지 센터?</div>
				<div class="summary__description">
					구글 지도 API를 이용하여 지도에서 다양한 장애인 종합시설을 찾아볼 수 있습니다.<br> 또한 즐겨찾기 추가를
					통해 자주가는 장소를 쉽게 저장할 수 있습니다.
				</div>
			</div>

			<div id="map"></div>

		</div>
	</section>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- Pricing card 
	<section class="section section--pricing">
		<div class="inner">

			<div class="card">
				<div class="cell cell2" style="text-align: center;">
					<br><strong>장애인만을 위한 웹페이지 UP<br><br>지금 바로 체험하기</strong>
				</div>
				<div class="cell cell1">
					<a href="member.signUp.go" class="btn btn--primary" style="margin-top: 0px;">회원가입 하러가기</a>
				</div>

			</div>

		</div>
	</section>
	-->

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a266bd566b053cb95981ebbdec81fc81"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(37.55580028822699,
					127.14627095252008),
			level : 3
		};

		var map = new kakao.maps.Map(container, options);

		var markerPosition = new kakao.maps.LatLng(37.55580028822699,
				127.14627095252008);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
	</script>

</body>
</body>
</html>