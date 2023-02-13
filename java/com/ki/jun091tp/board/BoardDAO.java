package com.ki.jun091tp.board;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ki.jun091tp.SiteOption;
import com.ki.jun091tp.member.Member;

@Service
public class BoardDAO {
	private int allBoardCount;

	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption so;

	public void countAllBoard() {
		allBoardCount = ss.getMapper(BoardMapper.class).getAllBoardCount();
	}

	public void getBoard(Board b, HttpServletRequest req) {
		try {
			// jsp에서 token값 받아오기
			String token = req.getParameter("token"); // 141414에 글을 썼다
			// 지금 이 메소드에서만 사용할 token 저장 공간 임시적으로 만들기
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) { // st2가 null이 아니면서 토큰과 st2가 같으면
				req.setAttribute("r", "글쓰기 실패- 새로고침"); // 14시14분14초에 글을 쓰고 14시14분14초에 새로고침 누르면
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			b.setU_id(m.getU_id()); // board자바빈에 loginMember 세션에 담긴 id 정보를 담기

			String txt = b.getB_txt();
			txt = txt.replace("\r\n", "<br>");
			b.setB_txt(txt);
			allBoardCount++;

			if (ss.getMapper(BoardMapper.class).writeBoard(b) == 1) {
				req.setAttribute("r", "글쓰기 성공!");
				req.getSession().setAttribute("st", token);
				// System.out.println("토큰값 : " + token);
				// System.out.println("임시공간 : " + st2);
			} else {
				req.setAttribute("r", "글쓰기 실패!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기 실패!-db");
		}
	}

	public void getMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		String search = (String) req.getSession().getAttribute("search");
		int msgCount = allBoardCount;
		/*
		 * if (search == null) { // 전체조회(검색어가 없으면) msgCount = allBoardCount; search =
		 * ""; } else { //검색 후 조회 BoardSelector bSel2 = new BoardSelector(search, 0, 0);
		 * msgCount = ss.getMapper(BoardMapper.class).getSearchBoardCount(bSel2); }
		 */
		int allPageCount = (int) Math.ceil((double) msgCount / so.getBoardPerPage());
		req.setAttribute("allPageCount", allPageCount);

		int start = (page - 1) * so.getBoardPerPage() + 1;
		int end = (page == allPageCount) ? msgCount : start + so.getBoardPerPage() - 1;

		BoardSelector bSel = new BoardSelector(search, start, end);
		List<Board> boardMsgs = ss.getMapper(BoardMapper.class).getBoard(bSel);
		req.setAttribute("msgs", boardMsgs);

	}
	
	// 조회수
	public void readCounter(Board b, HttpServletRequest req) {
		try {
			ss.getMapper(BoardMapper.class).readCounterBoard(b);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 게시판 상세내용
	public void detail(Board b,Comment c, HttpServletRequest req) {
		try {
//		Board boards = ss.getMapper(BoardMapper.class).DetailBoard(b);
		List<Board> comments = ss.getMapper(BoardMapper.class).getAllBoard(b);
//		req.setAttribute("boards", boards);
		
		for(Board board : comments) {
			board.setB_comment(ss.getMapper(BoardMapper.class).getComment(board));
		}
		req.setAttribute("c1", comments);
		BigDecimal b_no = b.getB_no();
		c.setC_js_no(b_no);
//		boards.setB_comment(ss.getMapper(BoardMapper.class).getComment((Board) comments));
//		req.setAttribute("c1", comments);
//		req.setAttribute("c1", c1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 조회순
		public void getMaxCount(int page ,HttpServletRequest req) {
			req.setAttribute("curPage", page);
			String search = (String) req.getSession().getAttribute("search");
			int msgCount = allBoardCount;
			/*
			if (search == null) { // 전체조회(검색어가 없으면)
				msgCount = allBoardCount;
				search = "";
			} else { //검색 후 조회
				BoardSelector bSel2 = new BoardSelector(search, 0, 0);
				msgCount = ss.getMapper(BoardMapper.class).getSearchBoardCount(bSel2);
			} 
			*/
			int allPageCount = (int) Math.ceil((double) msgCount / so.getBoardPerPage()); // 페이지 갯수 = 총 게시글 / 5
			req.setAttribute("allPageCount", allPageCount);
			
			int start = (so.getBoardPerPage() * (page - 1)) + 1;
			int end = (page == allPageCount) ? msgCount : (start + so.getBoardPerPage() - 1);
			
			BoardSelector bSel = new BoardSelector(search, start, end);
			List<Board> boardMsgs = ss.getMapper(BoardMapper.class).count(bSel);
			req.setAttribute("msgs", boardMsgs);
		}

	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search", search);
	}

	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	// 게시글 수정
	   public void updateDetail(Board b, HttpServletRequest req) {
	      // 수정 전의 내용 불러오기
	      try {
	         BigDecimal b_no = b.getB_no();
	         String b_title = req.getParameter("b_title");
	         String b_txt = req.getParameter("b_txt");

	         b.setB_no(b_no);
	         b.setB_title(b_title);
	         b.setB_txt(b_txt);

	         if (ss.getMapper(BoardMapper.class).UpdateBoard(b) == 1) {
	            req.setAttribute("r", "글수정성공");
//	            req.getSession().setAttribute("boardGo", b);
	         } else {
	            req.setAttribute("r", "글수정실패");
	         }
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	         req.setAttribute("r", "글수정실패DB");
	      }
	   }
	// 게시글 삭제
	public void deleteDetail(Board b, HttpServletRequest req) {
		try {
			BigDecimal b_no = b.getB_no();
			b.setB_no(b_no);
			if (ss.getMapper(BoardMapper.class).DeleteBoard(b) == 1) {
				req.setAttribute("r", "삭제성공");
			} else {
				req.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제실패DB");
		}
	}

	// 마이페이지 - 내 글 보기
	public void getMyMsg(Board b, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String u_id = m.getU_id();
		b.setU_id(u_id);
		List<Board> boardMyMsgs = ss.getMapper(BoardMapper.class).getMyBoard(b);
		req.setAttribute("mymsgs", boardMyMsgs);
	}
	// 댓글 삭제
	public void deleteComment(Comment c, HttpServletRequest req) {
		try {
//			BigDecimal c_no = new BigDecimal(req.getParameter("c_no"));
//			c.setC_no(c_no);
			BigDecimal b_no = new BigDecimal(req.getParameter("b_no"));
			c.setC_js_no(b_no);
			
			if (ss.getMapper(BoardMapper.class).deleteComment(c) == 1) {
				req.setAttribute("r", "글삭제성공");
			} else {
				req.setAttribute("r", "글삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글삭제실패-DB");
		}
	}
	// 댓글 수정
	public void updateComment(Comment c, HttpServletRequest req) {
		try {
			
			if (ss.getMapper(BoardMapper.class).updateComment(c) == 1) {
				req.setAttribute("r", "글수정성공");
			} else {
				req.setAttribute("r", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글수정실패-DB");
		}
	}
	// 댓글쓰기
	public void writeComment(Comment c, HttpServletRequest req) {
		try {
//				BigDecimal b_no = new BigDecimal(req.getParameter("bno"));
//				c.setB_no(b_no);
			String token1 = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token1.equals(st2)) {
				req.setAttribute("r", "댓글쓰기 실패-새로고침");
				return;
			}
//			Member m = (Member) req.getSession().getAttribute("loginMember");
//			c.setC_writer(m.getU_id());
//			int b_no = Integer.parseInt(req.getParameter("b_no"));
//			c.setC_js_no(b_no);
			
			if (ss.getMapper(BoardMapper.class).writeComment(c) == 1) {
				req.setAttribute("r", "댓글쓰기성공");
				req.getSession().setAttribute("st", token1);
			} else {
				req.setAttribute("r", "댓글쓰기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글쓰기실패");
		}
	}

}