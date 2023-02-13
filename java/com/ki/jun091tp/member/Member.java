package com.ki.jun091tp.member;

public class Member {
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_nickname;
	private String u_email;
	private String u_tel;
	private String u_addr;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	

	public Member(String u_id, String u_pw, String u_name, String u_nickname, String u_email, String u_tel,
			String u_addr) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_nickname = u_nickname;
		this.u_email = u_email;
		this.u_tel = u_tel;
		this.u_addr = u_addr;
	}


	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_pw() {
		return u_pw;
	}

	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_nickname() {
		return u_nickname;
	}

	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	public String getU_addr() {
		return u_addr;
	}

	public void setU_addr(String u_addr) {
		this.u_addr = u_addr;
	}
	
	
	
	
}
