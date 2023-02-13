package com.ki.jun091tp.map;

import java.math.BigDecimal;

public class BookMark {
	BigDecimal bk_no;
	String u_id;
	BigDecimal sub_no;
	BigDecimal f_no;
	BigDecimal ch_no;

	public BookMark() {
		// TODO Auto-generated constructor stub
	}

	public BookMark(BigDecimal bk_no, String u_id, BigDecimal sub_no, BigDecimal f_no, BigDecimal ch_no) {
		super();
		this.bk_no = bk_no;
		this.u_id = u_id;
		this.sub_no = sub_no;
		this.f_no = f_no;
		this.ch_no = ch_no;
	}

	public BigDecimal getBk_no() {
		return bk_no;
	}

	public void setBk_no(BigDecimal bk_no) {
		this.bk_no = bk_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public BigDecimal getSub_no() {
		return sub_no;
	}

	public void setSub_no(BigDecimal sub_no) {
		this.sub_no = sub_no;
	}

	public BigDecimal getF_no() {
		return f_no;
	}

	public void setF_no(BigDecimal f_no) {
		this.f_no = f_no;
	}

	public BigDecimal getCh_no() {
		return ch_no;
	}

	public void setCh_no(BigDecimal ch_no) {
		this.ch_no = ch_no;
	}
	
}

