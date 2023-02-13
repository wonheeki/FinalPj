var map;

//function initMap() {
//	var seoul = {
//		lat : 37.5642135,
//		lng : 127.0016985
//	};
//
//	const map = new google.maps.Map(document.getElementById('map'), {
//		zoom : 11,
//		center : seoul
//	});
//	const contentString = '<div id="content">'
//			+ '<div id="siteNotice">'
//			+ "</div>"
//			+ '<h1 id="firstHeading" class="firstHeading">Uluru</h1>'
//			+ '<div id="bodyContent">'
//			+ "<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large "
//			+ "sandstone rock formation in the southern part of the "
//			+ "Northern Territory, central Australia. It lies 335&#160;km (208&#160;mi) "
//			+ "south west of the nearest large town, Alice Springs; 450&#160;km "
//			+ "(280&#160;mi) by road. Kata Tjuta and Uluru are the two major "
//			+ "features of the Uluru - Kata Tjuta National Park. Uluru is "
//			+ "sacred to the Pitjantjatjara and Yankunytjatjara, the "
//			+ "Aboriginal people of the area. It has many springs, waterholes, "
//			+ "rock caves and ancient paintings. Uluru is listed as a World "
//			+ "Heritage Site.</p>"
//			+ '<p>Attribution: Uluru, <a href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'
//			+ "https://en.wikipedia.org/w/index.php?title=Uluru</a> "
//			+ "(last visited June 22, 2009).</p>" + "</div>" + "</div>";
//	
//	const infowindow = new google.maps.InfoWindow({
//		content : contentString,
//	});
//	
//	new google.maps.Marker({
//		position : seoul,
//		map : map,
//		label : {
//			text : "서울 장애인",
//			color : "#C70E20"
//		},
//		icon : {
//			url : "resources/img/heart.png",
//			labelOrigin : new google.maps.Point(50, 30)
//		},
//		title:"서울장애인",
//	});
//	 icon.addListener("click", () => {
//		    infowindow.open({
//		      anchor: marker,
//		      map:map,
//		      shouldFocus: false,
//		    });
//		  });
//
//}

function initMap() {

    // 지도 스타일
    const map = new google.maps.Map(document.getElementById("map"), {
        zoom: 14,
        center: { lat: 33.3004495276489, lng: 126.17976805874376 },
    });

    // 마커 정보
    var locations = [
        { place: "❤이곳은 원희씨네 집입니다~❤", lat: 33.3004495276489, lng: 126.17976805874376 },
    ];

    //인포윈도우
    var infowindow = new google.maps.InfoWindow();

    //마커 생성
    for (var i = 0; i < locations.length; i++) {
        var marker = new google.maps.Marker({
            map: map,
            label: {text : "원희씨네 Home~😀",
			color : "#2596be"},
            position: new google.maps.LatLng(locations[i].lat, locations[i].lng),
        });


        google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
                //html로 표시될 인포 윈도우의 내용
                infowindow.setContent(locations[i].place);
                //인포윈도우가 표시될 위치
                infowindow.open(map, marker);
            }
        })(marker, i));
        
        if (marker) {
            marker.addListener('click', function() {
                //중심 위치를 클릭된 마커의 위치로 변경
                map.setCenter(this.getPosition());
                //마커 클릭 시의 줌 변화
                map.setZoom(14);
            });
        }



    }
}