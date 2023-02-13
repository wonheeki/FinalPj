package com.ki.jun091tp.map;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ki.jun091tp.member.Member;

@Service
public class MapDAO {
	@Autowired
	SqlSession ss;

	public Facilitiess getAllFacJSON(HttpServletRequest req) {
		return new Facilitiess(ss.getMapper(MapMapper.class).getAllFac());
	}

	public Subways getAllSubJSON(HttpServletRequest req) {
		return new Subways(ss.getMapper(MapMapper.class).getAllSub());
	}

	public Charges getAllChargeJSON(HttpServletRequest req) {
		return new Charges(ss.getMapper(MapMapper.class).getAllCharge());
	}

	// 지하철 상세내용
	public void detailSub(Subway s, HttpServletRequest req) {
		try {

			List<Subway> subways = ss.getMapper(MapMapper.class).getThisSub(s);
			req.setAttribute("subways", subways);

			BigDecimal sub_no = s.getSub_no();
			s.setSub_no(sub_no);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 시설 상세정보
	public void detailFac(Facilities f, HttpServletRequest req) {
		try {
			List<Facilities> ff = ss.getMapper(MapMapper.class).detailFac(f);
			req.setAttribute("fac", ff);
			
			BigDecimal f_no = f.getF_no();
			f.setF_no(f_no);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 충전소 상세정보
	public void detailChar(Charge ch, HttpServletRequest req) {
		try {
			List<Charge> cc = ss.getMapper(MapMapper.class).detailChar(ch);
			req.setAttribute("cha", cc);
			
			BigDecimal ch_no = ch.getCh_no();
			ch.setCh_no(ch_no);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 즐겨찾기 지하철
	public void BookMarkSubway(HttpServletRequest req, BookMark bk) {
		try {

			if (ss.getMapper(MapMapper.class).insertBk_Sub(bk) == 1) {
				req.setAttribute("result", "성공");
			} else {
				req.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "실패");
		}
	}

	// 즐겨찾기 충전기
	public void BookMarkCharge(HttpServletRequest req, BookMark bk) {
		try {
			if (ss.getMapper(MapMapper.class).insertBk_Charge(bk) == 1) {
				req.setAttribute("result", "성공");
			} else {
				req.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "실패");
		}
	}

	// 즐겨찾기 공공시설
	public void BookMarkFac(HttpServletRequest req, BookMark bk) {
		try {
			if (ss.getMapper(MapMapper.class).insertBk_Fac(bk) == 1) {
				req.setAttribute("result", "성공");
			} else {
				req.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "실패");
		}
	}

	// 즐겨찾기 삭제
	public void DeleteBkCh(HttpServletRequest req, BookMark bk) {
		try {
			if (ss.getMapper(MapMapper.class).deleteBk(bk) == 1) {
				req.setAttribute("Bkresult", "즐찾삭제성공");
			} else {
				req.setAttribute("Bkresult", "즐찾삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("Bkresult", "즐찾삭제실패DB");
		}
	}

	// 즐겨찾기 삭제
	public void DeleteBkFac(HttpServletRequest req, BookMark bk) {
		try {
			if (ss.getMapper(MapMapper.class).deleteBk2(bk) == 1) {
				req.setAttribute("Bkresult", "즐찾삭제성공");
			} else {
				req.setAttribute("Bkresult", "즐찾삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("Bkresult", "즐찾삭제실패DB");
		}
	}

	// 즐겨찾기 삭제
	public void DeleteBkSub(HttpServletRequest req, BookMark bk) {
		try {

			if (ss.getMapper(MapMapper.class).deleteBk3(bk) == 1) {
				req.setAttribute("Bkresult", "즐찾삭제성공");
			} else {
				req.setAttribute("Bkresult", "즐찾삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("Bkresult", "즐찾삭제실패");
		}
	}

	// 마이페이지 즐찾 목록 가져오기
	public void getMyBookmark(Subway s, Facilities f, Charge c, HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String u_id = m.getU_id();
		s.setU_id(u_id);
		List<Subway> bookMyMsgs = ss.getMapper(MapMapper.class).getAllBk(s);
		req.setAttribute("book", bookMyMsgs);
		List<Facilities> bookMyMsgs2 = ss.getMapper(MapMapper.class).getAllBk2(f);
		req.setAttribute("book2", bookMyMsgs2);
		List<Charge> bookMyMsgs3 = ss.getMapper(MapMapper.class).getAllBk3(c);
		req.setAttribute("book3", bookMyMsgs3);
	}

	// 즐겨찾기 별찍기
	public void checkStar(HttpServletRequest req, BookMark bk) {
		try {
			if (ss.getMapper(MapMapper.class).starBk(bk)) {
				req.setAttribute("star", "s");
			} else {
				req.setAttribute("star", "f");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("star", "f");
		}
	}

	// 충전소 검색
	   public Charges searchCharge(Charge ch, HttpServletRequest req) {
	      return new Charges(ss.getMapper(MapMapper.class).searchCharge(ch));
	   }
	// 시설 검색
	   public Facilitiess searchFac(Facilities f, HttpServletRequest req) {
	      return new Facilitiess(ss.getMapper(MapMapper.class).searchFac(f));
	   }
	// 지하철 검색
	   public Subways searchSub(Subway s, HttpServletRequest req) {
	      return new Subways(ss.getMapper(MapMapper.class).searchSub(s));
	   }

}
