package com.ki.jun091tp.member;

import java.util.List;

public interface MemberMapper {
	public abstract List<Member> getMemberById(Member m);
	public abstract List<Member> getMemberByNickname(Member m);
	public abstract int deleteMember(Member m);
	public abstract int updateMember(Member m);
	public abstract int kakaoLogin(Member m); // 카카오 회원가입
	public abstract int signMember(Member m);
	public abstract List<Member> findMemberID(Member m); // 아이디 찾기
	public abstract List<Member> findMemberPW(Member m); // 비밀번호 찾기
	public abstract int changePW(Member m);
}
