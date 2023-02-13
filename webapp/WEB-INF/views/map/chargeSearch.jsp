<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>지도 생성하기</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
 <style>
 .mapbtn{
	background: #eee linear-gradient(to bottom, #fcfcfc, #eee);
    border: 1px solid #d5d5d5;
    border-radius: 4px;
    padding: 10px;
    font-size: 14px;
    font-weight: 500;
    line-height: 1.5;
    cursor: pointer;
    color: #333;
    margin-right: 4px;
    border-radius: 5px;
    margin-top: 10px;
}
.wrap {
   position: absolute;
   left: 0;
   bottom: 40px;
   width: 288px;
   height: 132px;
   margin-left: -144px;
   text-align: left;
   overflow: hidden;
   font-size: 12px;
   font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
   line-height: 1.5;
}

.wrap * {
   padding: 0;
   margin: 0;
}

.wrap .info {
   width: 286px;
   height: 120px;
   border-radius: 5px;
   border-bottom: 2px solid #ccc;
   border-right: 1px solid #ccc;
   overflow: hidden;
   background: #fff;
}

.wrap .info:nth-child(1) {
   border: 0;
   box-shadow: 0px 1px 2px #888;
}

.info .title {
   padding: 5px 0 0 10px;
   height: 30px;
   background: #eee;
   border-bottom: 1px solid #ddd;
   font-size: 18px;
   font-weight: bold;
}

.info .close {
   position: absolute;
   top: 10px;
   right: 10px;
   color: #888;
   width: 17px;
   height: 17px;
   background:
      url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
   cursor: pointer;
}

.info .body {
   position: relative;
   overflow: hidden;
}

.info .desc {
   position: relative;
   margin: auto;
   padding: 20px;
   height: 75px;
}

.desc .ellipsis {
   overflow: hidden;
   text-overflow: ellipsis;
   white-space: nowrap;
}

.desc .jibun {
   font-size: 11px;
   color: #888;
   margin-top: -2px;
}

.info .img {
   position: absolute;
   top: 6px;
   left: 5px;
   width: 73px;
   height: 71px;
   border: 1px solid #ddd;
   color: #888;
   overflow: hidden;
}

.info:after {
   content: '';
   position: absolute;
   margin-left: -12px;
   left: 50%;
   bottom: 0;
   width: 22px;
   height: 12px;
   background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
   color: #5085BB;
}

#map {
   width: 100%;
   height: 650px;
   margin: auto;
}

#map_wrap {
   width: 1500px;
   margin: 50px auto;
}
#mapSearch{
	width:50px;;
	height:32px;
	border: 1px solid #65b836;
	color: #fff;
	background: #55a532 linear-gradient(#91dd70, #55ae2e);
	font-size: 20px;
	border-radius: 5px;
	margin-bottom: 10px;
}
#chargebtn{
	background: #55a532 linear-gradient(#91dd70, #55ae2e);
    border: 1px solid #d5d5d5;
    border-radius: 4px;
    padding: 10px;
    font-size: 14px;
    font-weight: 500;
    line-height: 1.5;
    cursor: pointer;
    color: white;
    margin-right: 4px;
    border-radius: 5px;
    margin-top: 10px;
}
</style>
</head>
<body>
<!-- 지도를 표시할 div 입니다 -->
   <!-- <div id="map_wrap">
      <div id="map"></div>
      <div id="menu_wrap" class="bg_white">
    </div>
   </div>
   키워드 : <input id="keyword" size="15"> 
    <button id="mapSearch" type="button">검색하기</button>
     -->
   <div id="map_wrap">
		<a href="map.go" class="mapbtn">공공시설</a> 
		<a href="map.sub.go"class="mapbtn">지하철</a> 
		<a href="map.charge.go" id="chargebtn">휠체어충전소</a>
		<div style="float: right;">
			<input type="text" class="input--text" placeholder="검색할 내용을 입력하세요"
				id="keyword" maxlength="10" name="keyword">	
				 <button id="mapSearch" type="button">검색하기</button>
		</div>
		<div id="map"></div>
	</div>
    
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79557eed17078de948a1e274971148ab&libraries=services"></script>
<script type="text/javascript">

$(function(){
   
   
   var mapContainer = document.getElementById('map'),
   
   mapOption = { 
       center: new kakao.maps.LatLng(37.5407036,126.9673479),
       level: 8
   }; 

   var map = new kakao.maps.Map(mapContainer, mapOption);
   
   
   
   $.getJSON('charge.get', function(cg){
      $.each(cg.charge, function(i, c){
         var markers = new kakao.maps.Marker({
            map: map,
            position: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude)
         });
         
         
         var content = '<div class="wrap">' + 
           '    <div class="info">' + 
           '        <div class="title">' + 
                    c.ch_FCLTYNM + 
           '           <a href="#"><img src="resources/img/star.png" style="width:20px;"></a>' + 
           '            <button class="close" title="닫기"></button>' + 
           '        </div>' + 
           '        <div class="body">' + 
           '            <div class="desc">' + 
           '                <div class="ellipsis">'+c.ch_INSTITUTIONNM+'</div>' + 
           '                <div class="jibun ellipsis">'+c.ch_RDNMADR+'</div>' +
           '            </div>' + 
           '        </div>' + 
           '    </div>' +    
           '</div>';
           var overlay = new kakao.maps.CustomOverlay({
                 content: content,
                 position: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude)   
                 });
           
         
         kakao.maps.event.addListener(markers, 'mouseover', function() {
              overlay.setMap(map);
            });
         kakao.maps.event.addListener(markers, 'mouseout', function() {
               overlay.setMap(null);
            });
         kakao.maps.event.addListener(markers, 'click', function() {
            location.href="chargeMap.View.go?ch_no=" + c.ch_no;
            });
         
         $("#mapSearch").click(function(){
            markers.setMap(null);
            let search = $("#keyword").val();
            //marker.setMap(null);
            mapOption = { 
           		       center: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude),
           		       level: 6
           		   }; 
            $.getJSON("charge.search?ch_FCLTYNM=" + search, function(cs){
               $.each(cs.charge, function(i, c){
                  //marker.setMap(null);
                  
                  
                  /*
                  var mapContainer = document.getElementById('map'),
                  
                  mapOption = { 
                      center: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude),
                      level: 5
                  }; 

                  var searchMap = new kakao.maps.Map(mapContainer, mapOption);
                  */
                  var marker = new kakao.maps.Marker({
                     map: map,
                     position: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude)
                  })
                  
                  marker.setMap(map);
                  
                  var content = '<div class="wrap">' + 
                    '    <div class="info">' + 
                    '        <div class="title">' + 
                             c.ch_FCLTYNM + 
                    '           <a href="#"><img src="resources/img/star.png" style="width:20px;"></a>' + 
                    '            <button class="close" title="닫기"></button>' + 
                    '        </div>' + 
                    '        <div class="body">' + 
                    '            <div class="desc">' + 
                    '                <div class="ellipsis">'+c.ch_INSTITUTIONNM+'</div>' + 
                    '                <div class="jibun ellipsis">'+c.ch_RDNMADR+'</div>' +
                    '            </div>' + 
                    '        </div>' + 
                    '    </div>' +    
                    '</div>';
                    
                    var overlay = new kakao.maps.CustomOverlay({
                          content: content,
                          position: new kakao.maps.LatLng(c.ch_Latitude, c.ch_Longitude)   
                          });
                    
                  
                  kakao.maps.event.addListener(marker, 'mouseover', function() {
                       overlay.setMap(map);
                     });
                  kakao.maps.event.addListener(marker, 'mouseout', function() {
                        overlay.setMap(null);
                     });
                  kakao.maps.event.addListener(marker, 'click', function() {
                     location.href="map.view.go?ch_no=" + c.ch_no;
                     });
                  
                  $('#mapSearch').click(function(){
                     marker.setMap(null);
                  })
                  
               })
            })
            
         })
         
         
      })
      
      
      
   })
   
   
   
})




</script>
</body>
</html>