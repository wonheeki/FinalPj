package com.ki.jun091tp.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	// 아이디 찾기 (이름, 이메일 사용)
	public void findMemberID(Member m,HttpServletRequest req) {
		try {
			List<Member> members = ss.getMapper(MemberMapper.class).findMemberID(m);
			if(members.size() != 0) {
				Member id = members.get(0);
				 // 에러발생 원인 제 1 용의자↓
				if(req.getParameter("u_name").equals(m.getU_name()) && req.getParameter("u_email").equals(m.getU_email())) {
					req.setAttribute("r", "아이디조회성공");
					req.setAttribute("id", id.getU_id()); 
				}
			}else {
				req.setAttribute("r", "아이디조회실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "아이디조회실패DB");
		}
		
	}
	// 비밀번호 찾기(아이디, 핸폰 사용)
	public void findMemberPW(Member m, HttpServletRequest req) {
		try {
			String pwStar;
			
			List<Member> members = ss.getMapper(MemberMapper.class).findMemberPW(m);
			if(members.size() != 0) {
				Member pw = members.get(0);
				if(req.getParameter("u_id").equals(m.getU_id()) && req.getParameter("u_tel").equals(m.getU_tel())) {
					req.setAttribute("r", "비밀번호조회성공");
					pwStar=pw.getU_pw();
		               pwStar=pwStar.substring(0, pwStar.length()-3);
		               pwStar = pwStar+"***";
		               req.setAttribute("pw", pwStar);
				}else {
					req.setAttribute("r", "비밀번호조회실패");
				}
			}else {
				req.setAttribute("r", "비밀번호조회실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "비밀번호조회실패DB");
		}
	}
	// 주소나누기
	public void dividAddr(HttpServletRequest req) {
		// loginMember라는 session에 담긴 내용을 Javabean 하나 생성해서 담기
		Member m = (Member)req.getSession().getAttribute("loginMember");
		// 위에 생성한 Javabean에서 주소부분만 빼서 String그릇에 넣기
		String addr = m.getU_addr(); //봉은사로 119성옥빌딩!5동 503호!27031
		// !기준으로 나눠서 담을 String 배열 하나 생성해서 담기
		String[] addr2 = addr.split("!"); // {"봉은사로119성옥빌딩", "5동 503호", "27031"}
		req.setAttribute("addr", addr2);
	}
	// 회원탈퇴
	public void delete(HttpServletRequest req) {
		try {
			// session에서 loginMember로 되어 있는거 JavaBean 만들어서 담기
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// mapper에서 해당하는 쿼리문 실행해서 한줄 변화가 생기면 성공
			if (ss.getMapper(MemberMapper.class).deleteMember(m) == 1) {
				req.setAttribute("r", "탈퇴성공");
				// session에 있는 loginMember에는 아직 정보가 남아있는 상태 -> null값 처리
				req.getSession().setAttribute("loginMember", null);
			} else {
				req.setAttribute("r", "이미 탈퇴처리가 됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴 실패-DB서버문제");
		}
	}
	// 회원정보 수정
	public void update(Member m, HttpServletRequest req) {
		// 수정하기 전의 현재 로그인 된 회원 정보
		// Member lm = (Member) req.getSession().getAttribute("loginMember");
		
		try {
			String u_id = req.getParameter("u_id");
			String u_pw = req.getParameter("u_pw");
			String u_name = req.getParameter("u_name");
			String u_nickname = req.getParameter("u_nickname");
			String u_email = req.getParameter("u_email");
			String u_tel = req.getParameter("u_tel");
			String u_addr1 = req.getParameter("u_addr1");
			String u_addr2 = req.getParameter("u_addr2");
			String u_addr3 = req.getParameter("u_addr3");
			
			m.setU_id(u_id);
			m.setU_pw(u_pw);
			m.setU_name(u_name);
			m.setU_nickname(u_nickname);
			m.setU_email(u_email);
			m.setU_tel(u_tel);
			m.setU_addr(u_addr2 + "!" + u_addr3 + "!" + u_addr1);

			// DB수정
			if (ss.getMapper(MemberMapper.class).updateMember(m) == 1) {
				req.setAttribute("r", "수정성공");
				// 사이트에 반영 - loginMember를 새로운 것으로 바꾸기
				req.getSession().setAttribute("loginMember", m);
				
			} else {
				req.setAttribute("r", "수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패");
		}
		
	}

	
	public boolean loginCheck(HttpServletRequest req) {
		// loginMember라는 session에 담긴 회원 정보 가져와서 Member 자바빈에 담기
		Member m = (Member) req.getSession().getAttribute("loginMember");
		// login이 되지 않았을 경우에는 m그릇에 null처리가 되어 있을 것
		if (m != null) { // 로그인이 되어 있을 경우
			return true;
		} else {
			return false;
		}
	}
	
	// 회원가입
	public void join(Member m, HttpServletRequest req) {
		try {
			m.setU_id(req.getParameter("u_id"));
			m.setU_pw(req.getParameter("u_pw"));
			m.setU_name(req.getParameter("u_name"));
			m.setU_nickname(req.getParameter("u_nickname"));
			m.setU_email(req.getParameter("u_email"));
			m.setU_tel(req.getParameter("u_tel"));
			
			String u_addr1 = req.getParameter("u_addr1");
			String u_addr2 = req.getParameter("u_addr2");
			String u_addr3 = req.getParameter("u_addr3");
			
			String u_addr = u_addr2 + "!" + u_addr3 + "!" + u_addr1 + "!";
			m.setU_addr(u_addr);
			if(ss.getMapper(MemberMapper.class).signMember(m)==1) {
				req.setAttribute("r", "성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "실패");
		}
	}
	// 아이디 중복체크
	public Members memberIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}
	
	// 닉네임 중복체크
	public Members memberNicknameCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberByNickname(m));
	}
	// 로그인
	public void login(Member m, HttpServletRequest req) {
		try {
			// db에 저장되어 있는 id 인지 여부 파악을 위해서 db에 있는 데이터 가져오기
			List<Member> members = ss.getMapper(MemberMapper.class).getMemberById(m); // members가 db에 있는 데이터 가져오는 것
			
			if (members.size() != 0) { // id는 고유값이므로 != 0 >> 'id가 있으면' 이라는 뜻
				Member dbM = members.get(0); // mapper에 있는 것 중 0번째(m_id) 꺼 정보 가져와서 dbM에 담아라
				if (dbM.getU_pw().equals(m.getU_pw())) { // pw비교
					req.setAttribute("r", "로그인 성공");
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(600);
	
					// id를 입력하면 주소를 타고 가서 해당하는 아이디가 있나 체크 -> 있으면 그 아이디에 해당하는 데이터 뽑아와서 -> 비밀번호 비교
				} else {
					 req.setAttribute("r","로그인실패");
				}
			} else {
				req.setAttribute("r","로그인실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r","로그인실패");
		}
	}
	
	public void logout(HttpServletRequest req) {
		try {
			// loginMember라는 session의 attribute를 가져와서 -> 거기를 비우고
			req.getSession().setAttribute("loginMember", null);
			req.setAttribute("r", "로그아웃 성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그아웃");
		}
	}
	// 비밀번호 변경
	   public void changePW(Member m,HttpServletRequest req) {
	      try {
	         String u_id = req.getParameter("u_id");
	         String u_pw = req.getParameter("u_pw");
	         
	         m.setU_id(u_id);
	         m.setU_pw(u_pw);
	         if(ss.getMapper(MemberMapper.class).changePW(m)==1) {
	            req.setAttribute("r", "비번변경성공");
	         }else {
	            req.setAttribute("r", "비번변경실패");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         req.setAttribute("r", "비번변경실패");
	      }
	   }
	   // 카카오 회원가입
	   public void kakao(Member m, HttpServletRequest req) {
		try {
			
			
			String u_id = req.getParameter("u_id1");
			String u_email = req.getParameter("u_email1");
			
			System.out.println(u_id);
			System.out.println(u_email);
			
			
			m.setU_id(u_id);
			m.setU_email(u_email);
			
			if(ss.getMapper(MemberMapper.class).kakaoLogin(m)==1) {
				List<Member> members = ss.getMapper(MemberMapper.class).getMemberById(m);
				Member dbM = members.get(0);
				req.getSession().setAttribute("loginMember", dbM);
				req.getSession().setMaxInactiveInterval(600);
				req.setAttribute("r", "성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "실패");
		}
	}
 
	// 카카오 로그인
		public void kakaoLogin(Member m, HttpServletRequest req) {
			try {
				
				String u_id = req.getParameter("u_id1");
				String u_email = req.getParameter("u_email1");
				
				System.out.println(u_id);
				System.out.println(u_email);
				
				
				m.setU_id(u_id);
				m.setU_email(u_email);
				
				// db에 저장되어 있는 id 인지 여부 파악을 위해서 db에 있는 데이터 가져오기
				List<Member> members = ss.getMapper(MemberMapper.class).getMemberById(m); // members가 db에 있는 데이터 가져오는 것
				
				if (members.size() != 0) { // id는 고유값이므로 != 0 >> 'id가 있으면' 이라는 뜻
					Member dbM = members.get(0); // mapper에 있는 것 중 0번째(m_id) 꺼 정보 가져와서 dbM에 담아라
					req.setAttribute("r", "로그인 성공");
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(600);
		
					} else {
						 req.setAttribute("r","로그인실패");
					}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("r","로그인실패");
			}
		}

}
