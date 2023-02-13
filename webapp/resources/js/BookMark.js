//alert("메롱");
// 서버로 전송할 즐겨찾기  Sub 데이터
const formSub = {
	u_id : '${loginMember.u_id}',	
	sub_no : '${subways.sub_no}'
}
// 서버로 전송할 즐겨찾기 Fac 데이터
const formFac = {
		u_id : '${loginMember.u_id}',	
		fac_no : '${subways.sub_station}'
	}
// 서버로 전송할 즐겨찾기 Charge 데이터
const formCharge = {
		u_id : '${loginMember.u_id}',	
		ch_no : '${subways.sub_station}'
	}
// 즐겨찾기 버튼을 눌렀을 때! (충전기)
$("#BookMark1").click(function(e){
	$.ajax({
		url : 'map.bkCharge.go',
		type:'POST',
		data: formCharge,
		success:function(result){
			// success : 서버가 요청을 성공적으로 수행했을 때 실행될 메소드
			// result : 서버가 반환한 파라미터
			if(result == '성공'){
				alert("즐겨찾기가 되었습니다.");
			}else if(result == '실패'){
				alert("즐겨찾기가 실패하였습니다.");
			}
		}
	})
});
//즐겨찾기 버튼을 눌렀을 때! (지하철)
$('#BookMark3').click(function(e){
	alert("메롱");
	$.ajax({
		url :'map.bkSub.go',
		type:'GET',
		data: formSub,
		success:function(result){
			// success : 서버가 요청을 성공적으로 수행했을 때 실행될 메소드
			// result : 서버가 반환한 파라미터
			if(result == '성공'){
				alert("즐겨찾기가 되었습니다.");
			}else if(result == '실패'){
				alert("즐겨찾기가 실패하였습니다.");
			}
		}
	})
});
//즐겨찾기 버튼을 눌렀을 때! (공공시설)
$("#BookMark2").click(function(e){
	$.ajax({
		url :'map.bkFac.go',
		type:'POST',
		data: formFac,
		success:function(result){
			// success : 서버가 요청을 성공적으로 수행했을 때 실행될 메소드
			// result : 서버가 반환한 파라미터
			if(result == '성공'){
				alert("즐겨찾기가 되었습니다.");
			}else if(result == '실패'){
				alert("즐겨찾기가 실패하였습니다.");
			}
		}
	})
});