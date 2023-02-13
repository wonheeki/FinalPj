package com.ki.jun091tp.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ki.jun091tp.map.Charge;
import com.ki.jun091tp.map.Facilities;
import com.ki.jun091tp.map.MapDAO;
import com.ki.jun091tp.map.Subway;

@Controller
public class MyPageController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private MapDAO mapDAO;
	
	@RequestMapping(value = "/member.notice.view1", method = RequestMethod.GET)
	public String noticeview1(HttpServletRequest req) {
		req.setAttribute("cp", "notice/noticeView1.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.notice.view2", method = RequestMethod.GET)
	public String noticeview2(HttpServletRequest req) {
		req.setAttribute("cp", "notice/noticeView2.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.notice.view3", method = RequestMethod.GET)
	public String noticeview3(HttpServletRequest req) {
		req.setAttribute("cp", "notice/noticeView3.jsp");
		return "index";
	}
	@RequestMapping(value = "/member.notice.view4", method = RequestMethod.GET)
	public String noticeview4(HttpServletRequest req) {
		req.setAttribute("cp", "notice/noticeView4.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.notice.go", method = RequestMethod.GET)
	public String notice(HttpServletRequest req) {
		req.setAttribute("cp", "notice/notice.jsp");
		return "index";
	}
	// 마이페이지의 내 즐겨찾기로 가기
	   @RequestMapping(value = "/member.likeList.go", method = RequestMethod.GET)
	   public String likeList(Subway s, Facilities f, Charge c,HttpServletRequest req) {
	      mapDAO.getMyBookmark(s,f,c, req);
	      req.setAttribute("cp", "likeList.jsp");
	      return "index";
	   }
	
	@RequestMapping(value = "/member.mypage.go", method = RequestMethod.GET)
	public String mypage(HttpServletRequest req) {
		mDAO.dividAddr(req);
		req.setAttribute("cp", "info.jsp");
		return "index";
	}
	// 카카오 회원정보 수정
	@RequestMapping(value = "/member.kakaoMypage.go", method = RequestMethod.POST)
	public String kakaoMypage(Member m, HttpServletRequest req) {
		//mDAO.dividAddr(req);
		mDAO.kakao(m, req);
		//mDAO.kakaoLogin(m, req);
		req.setAttribute("cp", "info.jsp");
		return "index";
	}
	
}
