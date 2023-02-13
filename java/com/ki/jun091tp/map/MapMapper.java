package com.ki.jun091tp.map;

import java.util.List;

public interface MapMapper {
	public abstract List<Facilities> getAllFac();
	public abstract List<Subway> getAllSub();
	public abstract List<Charge> getAllCharge();
	public abstract int insertBk_Fac(BookMark bk); //Fac 즐겨찾기 추가
	public abstract int insertBk_Sub(BookMark bk); // Sub 즐겨찾기 추가
	public abstract int insertBk_Charge(BookMark bk); // Charge 즐겨찾기 추가
	public abstract int deleteBk(BookMark bk); // 북마크 삭제 (충전소)
	public abstract int deleteBk2(BookMark bk); // 북마크 삭제 (공공시설)
	public abstract int deleteBk3(BookMark bk); // 북마크 삭제 (지하철)
	public abstract List<Subway> getThisSub(Subway s); // 지하철 상세정보
	public abstract List<Facilities> detailFac(Facilities f);
	public abstract List<Charge> detailChar(Charge ch);
	public abstract List<Subway> getAllBk(Subway s); // 북마크 값 전부 불러오기
	public abstract List<Facilities> getAllBk2(Facilities f);
	public abstract List<Charge> getAllBk3(Charge c);
	public abstract boolean starBk(BookMark bk); // 즐겨찾기 별
	public abstract List<Charge> searchCharge(Charge ch); // 충전소 검색
	public abstract List<Facilities> searchFac(Facilities f); // 시설 검색
	public abstract List<Subway> searchSub(Subway s); // 지하철 검색
}
