package com.ki.jun091tp.map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapController {
	@Autowired
	private MapDAO mDAO;

	// 공공시설 정보 가져오기
	@RequestMapping(value = "/facilities.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Facilitiess facGet(HttpServletRequest req, HttpServletResponse res) { // 응답내용이 Stocks
		// 현재 사이트 외부에서 AJAX 가능하게(Cross-Domain AJAX가능하게)하려면
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.getAllFacJSON(req);
	}

	// 지하철 정보 가져오기
	@RequestMapping(value = "/subway.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Subways SubGet(HttpServletRequest req, HttpServletResponse res) { // 응답내용이 Stocks
		// 현재 사이트 외부에서 AJAX 가능하게(Cross-Domain AJAX가능하게)하려면
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.getAllSubJSON(req);
	}

	// 충전소 정보 가져오기
	@RequestMapping(value = "/charge.get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Charges ChargeGet(HttpServletRequest req, HttpServletResponse res) { // 응답내용이 Stocks
		// 현재 사이트 외부에서 AJAX 가능하게(Cross-Domain AJAX가능하게)하려면
		res.addHeader("Access-Control-Allow-Origin", "*");
		return mDAO.getAllChargeJSON(req);
	}

	// 맵 페이지로 이동 (공공시설이 가장 먼저 뜸)
	@RequestMapping(value = "/map.go", method = RequestMethod.GET)
	public String MapGo(HttpServletRequest req) {
		req.setAttribute("cp", "map/facSearch.jsp");
		return "index";
	}
	
	// 지하철 지도 페이지로 이동
	@RequestMapping(value = "/map.sub.go", method = RequestMethod.GET)
	public String MapSubGo(HttpServletRequest req) {
		req.setAttribute("cp", "map/subSearch.jsp");
		return "index";
	}

	// 충전소 지도체이지로 이동
	@RequestMapping(value = "/map.charge.go", method = RequestMethod.GET)
	public String MapChargeGo(HttpServletRequest req) {
		req.setAttribute("cp", "map/chargeSearch.jsp");
		return "index";
	}

	// 지하철 상세페이지로 이동
	@RequestMapping(value = "/map.view.go", method = RequestMethod.GET)
	public String MapViewGo(Subway s, BookMark bk, HttpServletRequest req) {
		mDAO.detailSub(s, req);
		mDAO.checkStar(req, bk);
		req.setAttribute("cp", "map/subView.jsp");
		return "index";
	}

	// 공공시설 상세페이지로 이동
	@RequestMapping(value = "/facMap.View.go", method = RequestMethod.GET)
	public String facMapViewGo(Facilities f, HttpServletRequest req) {
		mDAO.detailFac(f, req);
		req.setAttribute("cp", "map/facView.jsp");
		return "index";
	}

	// 충전소 상세페이지로 이동
	@RequestMapping(value = "/chargeMap.View.go", method = RequestMethod.GET)
	public String facMapViewGo(Charge ch, HttpServletRequest req) {
		mDAO.detailChar(ch, req);
		req.setAttribute("cp", "map/chargeView.jsp");
		return "index";
	}

	// 공공시설 즐겨찾기 추가
	@RequestMapping(value = "/map.bkFac.go", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String BkFacGo(Facilities f, BookMark bk, HttpServletRequest req) {
		mDAO.detailFac(f, req);
		mDAO.BookMarkFac(req, bk);
		req.setAttribute("cp", "map/facView.jsp");
		return "index";
	}

	// 지하철 즐겨찾기 추가
	@RequestMapping(value = "/map.bkSub.go", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String BkSubGo(Subway s, BookMark bk, HttpServletRequest req) {
		mDAO.checkStar(req, bk);
		mDAO.detailSub(s, req);
		mDAO.BookMarkSubway(req, bk);
		mDAO.checkStar(req, bk);
		req.setAttribute("cp", "map/mapView.jsp");
		return "index";
	}

	// 충전기 즐겨찾기 추가
	@RequestMapping(value = "/map.bkCharge.go", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String BkChargeGo(Charge ch, BookMark bk, HttpServletRequest req) {
		mDAO.detailChar(ch, req);
		mDAO.BookMarkCharge(req, bk);
		req.setAttribute("cp", "map/chargeView.jsp");
		return "index";
	}

	// 즐겨찾기 삭제
	@RequestMapping(value = "/map.deleteMyBk", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public String DeleteMyBk(Subway s, Charge c, Facilities f, BookMark bk, HttpServletRequest req) {
		mDAO.getMyBookmark(s, f, c, req);
		mDAO.DeleteBkCh(req, bk);
		mDAO.DeleteBkFac(req, bk);
		mDAO.DeleteBkSub(req, bk);
		mDAO.getMyBookmark(s, f, c, req);
		req.setAttribute("cp", "likeList.jsp");
		return "index";
	}

	// 충전소 검색페이지로 이동
	@RequestMapping(value = "/chargeMap.Search.go", method = RequestMethod.GET)
	public String chargeSearch1(Charge ch, HttpServletRequest req) {
		req.setAttribute("cp", "map/chargeSearch.jsp");
		return "index";
	}

	// 충전소 검색
	@RequestMapping(value = "/charge.search", method = RequestMethod.GET, produces="application/json; charset=utf-8")
	   public @ResponseBody Charges chargeSearch(Charge ch,HttpServletRequest req, HttpServletResponse res) {
	      res.addHeader("Access-Control-Allow-Origin", "*");
	      return mDAO.searchCharge(ch, req);
	   }
	// 시설 검색
		@RequestMapping(value = "/fac.search", method = RequestMethod.GET, produces="application/json; charset=utf-8")
		public @ResponseBody Facilitiess facSearch(Facilities f,HttpServletRequest req, HttpServletResponse res) {
			res.addHeader("Access-Control-Allow-Origin", "*");
			return mDAO.searchFac(f, req);
		}
	// 충전소 검색
		@RequestMapping(value = "/sub.search", method = RequestMethod.GET, produces="application/json; charset=utf-8")
		public @ResponseBody Subways subSearch(Subway s,HttpServletRequest req, HttpServletResponse res) {
			res.addHeader("Access-Control-Allow-Origin", "*");
			return mDAO.searchSub(s, req);
		}

}
