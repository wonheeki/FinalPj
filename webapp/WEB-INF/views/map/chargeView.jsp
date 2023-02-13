<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#map {
	width: 100%;
	height: 650px;
	margin: auto;
}
#map_wrap{
	width:500px;
	margin:0 auto;
	padding: 20px 15px;
}
.map_cc1{
	text-align:center;
	margin:0 auto;
	font-size: 2rem;
	padding-bottom: 10px;
}
.board_title{
	text-align: center;
}
#map_title{
	text-align: center;
	align-content: center;
	align-items: center;
	justify-content: center;
}
#bookmark{
	float:right;
}
.starImg{
	width: 30px;
	align-content: center;
	align-self: center;
}
table th{
	font-weight:bold;
	color:#333;
	width:125px;
	height:50px;
	text-align:center;
	vertical-align: middle;
	padding-left:20px;
}
table td{
	color:#333;
	height:50px;
	text-align:center;
	vertical-align: middle;
	padding:20px 30px;
}
table{
	width:470px;
}
table tr{
	border-bottom:1px dashed #ddd;
}
.board_title h2{
	font-size:3rem;
	font-weight:bold;
}
</style>
</head>
<body>
	<br/>
	<br/>
	<c:forEach var="c" items="${cha }">
	<div class="board_title">
	<h2>지도 상세보기</h2>
		<c:if test="${result=='성공' }">
			<script type="text/javascript">
				alert("즐겨찾기에 성공하였습니다.");
			</script>
		</c:if>
		<c:if test="${result=='실패' }">
			<script type="text/javascript">
				alert("즐겨찾기에 실패하였습니다.");
			</script>
		</c:if>
		</div>
		<div id="map_wrap">
			<div class="map_cc1">
				<div id="map_title">[ ${c.ch_FCLTYNM } ]
				<c:if test="${sessionScope.loginMember != null }">
					<div id="bookmark">
						<%-- <a href="map.bkCharge.go?ch_no=${c.ch_no }&u_id=${loginMember.u_id}"
							id="BookMark3">즐겨찾기</a> --%>
							<c:choose>
							<c:when test="${result=='성공' }">
								<a href="map.deleteMyBk?ch_no=${c.ch_no }&u_id=${loginMember.u_id}" id="BookMark3"><img src="resources/img/star.png" class="starImg"></a>
							</c:when>
							<c:otherwise>
								<a href="map.bkCharge.go?ch_no=${c.ch_no }&u_id=${loginMember.u_id}" id="BookMark3"><img src="resources/img/star2.png" class="starImg"></a>
							</c:otherwise>
						</c:choose>
					</div>
				</c:if>
				</div>
			</div>
		
		<div id="map" style="width: 100%; height: 400px;"></div>
		<div id="map_content">
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79557eed17078de948a1e274971148ab"></script>
	<script type="text/javascript">
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = { 
		        center: new kakao.maps.LatLng(${c.ch_Latitude}, ${c.ch_Longitude}),
		        level:2,
		        scrollwheel: false
		    };
		

		var map = new kakao.maps.Map(mapContainer, mapOption);
		var marker = new kakao.maps.Marker({
			map:map,
			position: new kakao.maps.LatLng(${c.ch_Latitude}, ${c.ch_Longitude})
		})
		
	</script>
	
			<table id="tbl">
				<tr>
					<th>장소명</th>
					<td>${c.ch_FCLTYNM }</td>
				</tr>
				<tr>
					<th>도로명</th>
					<td>${c.ch_RDNMADR }</td>
				</tr>
				<tr>
					<th>설치장소</th>
					<td>${c.ch_INSTLLCDESC }</td>
				</tr>
				<tr>
					<th>평일운영시간</th>
					<td>${c.ch_WEEKDAYOPEROPENHHMM } - ${c.ch_WEEKDAYOPERCOLSEHHMM }</td>
				</tr>
				<tr>
					<th>휴일운영시간</th>
					<td>${c.ch_SATOPEROPEROPENHHMM } - ${c.ch_SATOPERCLOSEHHMM }</td>
				</tr>
				<tr>
					<th>전화전호</th>
					<td align="center">${c.ch_INSTITUTIONPHONENUMBER }</td>
				</tr>
				
			</table>
			</div>
		</div>
	</c:forEach>
</body>
</html>