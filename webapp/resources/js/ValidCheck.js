// function 실행
$(function(){
	searchAddrEvent();
	idCheckEvent();
	nickNameCheckEvent();
	logoutEvent();
	goResign();
	boardUpdate();
//	commentDelete();
});

// 게시판 글수정
function boardUpdate(no,title,txt){
	
}


// 회원가입 checkValid()
function checkValid() {
		let idBox = document.signForm.u_id;
		let pwBox = document.signForm.u_pw;
		let re_pwBox = document.signForm.u_repw;
		let nameBox = document.signForm.u_name;
		let nicknameBox = document.signForm.u_nickname;
		let emailBox = document.signForm.u_email;
		let telBox = document.signForm.u_tel;
		
		//ID
		if(isEmpty(idBox) || atLeastLetter(idBox, 5) || containsAnother(idBox)){
			alert("아이디는 5~10글자, 한글,특수문자 금지, 필수입력입니다.");
			idBox.value="";
			idBox.focus();
			return false;
		}
		//PW
		if(isEmpty(pwBox) || atLeastLetter(pwBox, 5) || containsAnother(pwBox)){
			alert("비밀번호는 5~15글자, 한글,특수문자 금지, 필수 입력입니다.");
			pwBox.value="";
			pwBox.focus();
			return false;
		}//PW 확인
		if(isEmpty(re_pwBox) || atLeastLetter(re_pwBox, 5) || notEqualPw(pwBox, re_pwBox)){
			alert("비밀번호 확인은 비밀번호와 같아야합니다.");
			re_pwBox.value="";
			re_pwBox.focus();
			return false;
		}//이름
		if(isEmpty(nameBox)){
			alert("이름은 필수입니다. (최대 5글자)");
			nameBox.value="";
			nameBox.focus();
			return false;
		}//닉네임
		if(isEmpty(nicknameBox)){
			alert("닉네임은 필수입니다. (최대 10글자)");
			nicknameBox.value="";
			nicknameBox.focus();
			return false;
		}//이메일
		if(isEmpty(emailBox)){
			alert("이메일은 필수입니다.");
			emailBox.value="";
			emailBox.focus();
			return false;
		}//핸드폰번호
		if(isEmpty(telBox)){
			alert("핸드폰 번호는 필수입니다");
			telBox.value="";
			telBox.focus();
			return false;
		}
		return true;
	}

function checkValidMyInFo() {
	let pwBox = document.updateform.u_pw;
	let re_pwBox = document.updateform.u_repw;
	let nameBox = document.updateform.u_name;
	let nicknameBox = document.updateform.u_nickname;
	let emailBox = document.updateform.u_email;
	let telBox = document.updateform.u_tel;

	//PW
	if(isEmpty(pwBox) || atLeastLetter(pwBox, 5) || containsAnother(pwBox)){
		alert("비밀번호는 5~15글자, 한글,특수문자 금지, 필수 입력입니다.");
		pwBox.value="";
		pwBox.focus();
		return false;
	}//PW 확인
	if(isEmpty(re_pwBox) || atLeastLetter(re_pwBox, 5) || notEqualPw(pwBox, re_pwBox)){
		alert("비밀번호 확인은 비밀번호와 같아야합니다.");
		re_pwBox.value="";
		re_pwBox.focus();
		return false;
	}//이름
	if(isEmpty(nameBox)){
		alert("이름은 필수입니다. (최대 5글자)");
		nameBox.value="";
		nameBox.focus();
		return false;
	}//닉네임
	if(isEmpty(nicknameBox)){
		alert("닉네임은 필수입니다. (최대 10글자)");
		nicknameBox.value="";
		nicknameBox.focus();
		return false;
	}//이메일
	if(isEmpty(emailBox)){
		alert("이메일은 필수입니다.");
		emailBox.value="";
		emailBox.focus();
		return false;
	}//핸드폰번호
	if(isEmpty(telBox)){
		alert("핸드폰 번호는 필수입니다");
		telBox.value="";
		telBox.focus();
		return false;
	}
	return true;
}

// 로그아웃
function logoutEvent(){
	$('#logoutBtn').click(function(){
		let msg = confirm('로그아웃 하시겠습니까?');
		if (msg) {
			location.href = "member.logout";
		}
	});
}
// 회원탈퇴
function goResign(){
	$('#resignBtn').click(function(){
//		alert("ㄴㅇ러");
		let msg = prompt('진짜 탈퇴하시겠습니까? (Y/N)');
		if(msg == 'Y'){
			let msg2 = confirm('진짜 탈퇴하시겠습니까?');
			if(msg2){
				alert("바이~");
				location.href="member.resign";
			}
		}
	});
}

// 주소  (우편번호)
function searchAddrEvent(){
	$('#u_addr1, #u_addr2').click(()=>{
		new daum.Postcode({
			oncomplete: function(data) {
	            $('#u_addr1').val(data.zonecode);
	            $('#u_addr2').val(data.roadAddress);
	        }
		}).open();
	});
}

// id 중복확인 체크
function idCheckEvent(){
	$('#u_id').keyup(function(){
		let u_id = $(this).val();
		$.getJSON("member.id.check?u_id="+u_id, function(memberJSON){
			if(memberJSON.member[0]==null){
				$('#u_id').css("color","black");
			}else{
				$('#u_id').css("color","red");
//				alert("중복된 아이디 입니다.");
			}
		});
	});
}

// 닉네임 중복확인 체크
function nickNameCheckEvent(){
	$('#u_nickname').keyup(function(){
		let u_nickname = $(this).val();
		//alert(u_nickname);
		$.getJSON("member.nickname.check?u_nickname="+u_nickname, function(memberJSON){
			if(memberJSON.member[0]==null){ // 중복 id가 없다 (사용가능!)
				// member[0] -> mapper에서 조건을 걸어줬으므로 조건을 걸어준 nickname이 member[0]이 됨!
				$('#u_nickname').css("color", "black");
			}else{ // 중복 id일 때 (사용불가능!)
				$('#u_nickname').css("color","red");
			}
		});
	});
}

// 게시글 댓글 삭제
//function commentDelete(no){
//	   if (confirm("진짜로 삭제하시겠습니까?")) {
//	      location.href="board.comment.delete?c_no="+no;
//	   }
//	}
function commentUpdate(no,txt,b_no) {
//	alert("메렁");
	txt = prompt("수정할 내용을 적어주십시오.",txt);
	if(txt != null && txt.length > 0){
		location.href = "board.comment.update?c_no="+no+"&c_txt="+txt+"&b_no="+b_no;
	}
	
}
