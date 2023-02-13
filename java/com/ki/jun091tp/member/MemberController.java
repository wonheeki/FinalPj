package com.ki.jun091tp.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;

	// 아이디 찾기 페이지로 이동
	@RequestMapping(value = "/member.findID", method = RequestMethod.GET)
	public String findID(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		req.setAttribute("cp", "member/findID.jsp");
		return "index";
	}

	// 비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "/member.findPW", method = RequestMethod.GET)
	public String findPW(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		req.setAttribute("cp", "member/findPW.jsp");
		return "index";
	}

	// 아이디 찾기 페이지에서 result페이지로 이동
	@RequestMapping(value = "/member.goResultID", method = RequestMethod.GET)
	public String goResultID(Member m, HttpServletRequest req) {
		mDAO.findMemberID(m, req);
		req.setAttribute("cp", "member/result.jsp");
		return "index";
	}

	// 비밀번호 찾기 페이지에서 result페이지로 이동
	@RequestMapping(value = "/member.goResultPW", method = RequestMethod.GET)
	public String goResultPW(Member m, HttpServletRequest req) {
		mDAO.findMemberPW(m, req);
		req.setAttribute("cp", "member/result.jsp");
		return "index";
	}

	// 아이디 중복체크
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Members memberIdCheck(Member m, HttpServletRequest req) {
		return mDAO.memberIdCheck(m);
	}

	// 닉네임 중복체크
	@RequestMapping(value = "/member.nickname.check", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Members memberNicknameCheck(Member m, HttpServletRequest req) {
		return mDAO.memberNicknameCheck(m);
	}

	// 회원가입
	@RequestMapping(value = "/member.signup", method = RequestMethod.POST)
	public String joinMember(Member m, HttpServletRequest req) {
		mDAO.join(m, req);
		req.setAttribute("cp", "member/result.jsp");
		return "index";
	}

	// 로그아웃
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logoutMember(HttpServletRequest req) {
		mDAO.logout(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 회원 탈퇴
	@RequestMapping(value = "/member.resign", method = RequestMethod.GET)
	public String memberResign(HttpServletRequest req) {
		mDAO.delete(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 회원 수정
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(Member m, HttpServletRequest req) {
		mDAO.update(m, req);
		req.setAttribute("cp", "home.jsp");
//		req.setAttribute("cp", "member/info.jsp");
		return "index";
	}

	// 로그인 페이지로 이동
	@RequestMapping(value = "/member.login.go", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		req.setAttribute("cp", "member/login.jsp");
		return "index";
	}

	// 회원가입페이지로 이동
	@RequestMapping(value = "/member.signUp.go", method = RequestMethod.GET)
	public String signup(HttpServletRequest req) {
		req.setAttribute("cp", "member/signUp.jsp");
		return "index";
	}
	
	// 로그인 성공 (카카오 버전)
	@RequestMapping(value = "/member.successlogin", method = RequestMethod.POST)
	public String successLogin(Member m, HttpServletRequest req) {
		mDAO.kakaoLogin(m, req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 회원탈퇴..? 아마도
	@RequestMapping(value = "/member.delMember", method = RequestMethod.GET)
	public String delMember(HttpServletRequest req) {
		//mDAO.delete(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	// 로그인 성공
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String loginMember(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}


	// 비밀번호 변경페이지로 이동
	@RequestMapping(value = "/member.changePw", method = RequestMethod.POST)
	public String changePw(Member m, HttpServletRequest req) {
		req.setAttribute("cp", "member/changePW.jsp");
		return "index";
	}

	// 비밀번호 변경하기
	@RequestMapping(value = "/member.changePw2", method = RequestMethod.POST)
	public String changePw2(Member m, HttpServletRequest req) {
		mDAO.changePW(m, req);
		req.setAttribute("cp", "member/result.jsp");
		return "index";
	}

}
