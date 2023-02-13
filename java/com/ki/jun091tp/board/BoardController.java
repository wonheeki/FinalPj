package com.ki.jun091tp.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ki.jun091tp.TokenMaker;
import com.ki.jun091tp.member.MemberDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO bDAO;

	@Autowired
	private MemberDAO mDAO;
	
	private boolean isFirstReq;

	public BoardController() {
		isFirstReq = true;
	}

	@RequestMapping(value = "/board.go", method = RequestMethod.GET)
	public String boardGo(HttpServletRequest req) {
		if (isFirstReq) {
			bDAO.countAllBoard();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		// bDAO.searchClear(req);
		bDAO.getMsg(1, req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/board.count.go", method = RequestMethod.GET)
	public String boardCount(HttpServletRequest req) {
		if (isFirstReq) {
			bDAO.countAllBoard();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		//bDAO.searchClear(req);
//		bDAO.getMsg(1, req);
		bDAO.getMaxCount(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_count.jsp");
		return "index";
	}
	@RequestMapping(value = "/board.write.go", method = RequestMethod.GET)
	public String boardWriteGo(HttpServletRequest req) {
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_write.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.write", method = RequestMethod.POST)
	public String boardWrite(Board b, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) { // 로그인을 한 사람만 글을 쓸 수 있도록
			bDAO.getBoard(b, req);
		}
		bDAO.getMsg(1, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	// 게시판 상세보기
	@RequestMapping(value = "/board.view.go", method = RequestMethod.GET)
	public String boardView(Comment c, Board b, HttpServletRequest req) {
		bDAO.detail(b,c, req);
		/*
		 * if (mDAO.loginCheck(req)) { }
		 */
		bDAO.readCounter(b, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_view.jsp");
		return "index";
	}

	// 수정페이지로 이동
	   @RequestMapping(value = "/board.edit.go", method = RequestMethod.GET)
	   public String boardEdit(Board b,Comment c, HttpServletRequest req) {
	      bDAO.detail(b,c, req);
	      TokenMaker.makeToken(req);
	      req.setAttribute("cp", "board/board_edit.jsp");
	      return "index";
	   }

	   // 게시판 글 수정
	   @RequestMapping(value = "/board.update", method = RequestMethod.POST)
	   public String boardEdit2(Board b,Comment c, HttpServletRequest req) {
	      bDAO.updateDetail(b, req);
	      bDAO.detail(b,c, req);
	      bDAO.updateDetail(b, req); // 수정 한 게시글을 다시불러와야하므로 updateDetail 메소드 다시 써주기
	      TokenMaker.makeToken(req);
//	       bDAO.getBoard(b, req);
	      req.setAttribute("cp", "board/board_view.jsp"); // board.jsp로 했을때 목록이 안떠서 홈으로 바꾼 거임
	      return "index";
	   }
	// 게시판 글 삭제
	@RequestMapping(value = "/board.delete", method = RequestMethod.GET)
	public String boardDelete(Board b, HttpServletRequest req) {
		bDAO.deleteDetail(b, req);
		bDAO.getMsg(1, req);
		
		req.setAttribute("cp", "board/board.jsp"); // board.jsp로 했을때 목록이 안떠서 홈으로 바꾼 거임
		return "index";
	}

	// 최신순 페이징
	@RequestMapping(value = "/board.page.change", method = RequestMethod.GET)
	public String boardPageChange(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		bDAO.getMsg(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board.jsp");
		return "index";
	}
	// 조회순 페이징
	@RequestMapping(value = "/boardCount.page.change", method = RequestMethod.GET)
	public String boardCountPageChange(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
//		bDAO.getMsg(p, req);
		bDAO.getMaxCount(p, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_count.jsp");
		return "index";
	}

	// 마이페이지의 내가 쓴 글로 가기
	@RequestMapping(value = "/board.my.view.go", method = RequestMethod.GET)
	public String boardMyView(Board b,Comment c, HttpServletRequest req) {
		bDAO.getMyMsg(b, req);
		bDAO.detail(b,c, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_view.jsp");
		return "index";
	}

	// 마이페이지의 내가 쓴 글 보기
	@RequestMapping(value = "/member.writeList.go", method = RequestMethod.GET)
	public String boardGo(Board b, HttpServletRequest req) {
		// bDAO.searchClear(req);
		bDAO.getMyMsg(b, req);
		req.setAttribute("cp", "writeList.jsp");
		return "index";
	}

	// 댓글쓰기
	@RequestMapping(value = "/board.comment.write", method = RequestMethod.GET)
	public String writeComment(Comment c,Board b, HttpServletRequest req) {
		bDAO.detail(b,c, req); // 1
		bDAO.writeComment(c,req); // 2
		bDAO.detail(b,c, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_view.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.comment.update", method = RequestMethod.GET)
	public String updateComment(Comment c, Board b, HttpServletRequest req) {
//			bDAO.detail(b, req); //1
//			cDAO.updateComment(c, req);//2
//			cDAO.getAllComment(b, req);//3
		bDAO.detail(b,c, req);
		bDAO.updateComment(c, req);
		bDAO.detail(b, c, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_view.jsp");
		return "index";
	}

	@RequestMapping(value = "/board.comment.delete", method = RequestMethod.GET)
	public String deleteComment(Comment c, Board b, HttpServletRequest req) {
		bDAO.detail(b,c, req);
		bDAO.deleteComment(c, req);
		bDAO.detail(b, c, req);
		TokenMaker.makeToken(req);
		req.setAttribute("cp", "board/board_view.jsp");
		return "index";
	}
}
