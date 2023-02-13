package com.ki.jun091tp.board;

import java.math.BigDecimal;
import java.util.Date;
// 댓글 자바빈
public class Comment {
	private BigDecimal c_no;
	private BigDecimal b_no;
	private String c_writer;
	private Date c_regDate;
	private String c_txt;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(BigDecimal c_no, BigDecimal b_no, String c_writer,Date c_regDate, String c_txt) {
		super();
		this.c_no = c_no;
		this.b_no = b_no;
		this.c_writer = c_writer;
		this.c_regDate = c_regDate;
		this.c_txt = c_txt;
	}

	public BigDecimal getC_no() {
		return c_no;
	}

	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}

	public BigDecimal getB_no() {
		return b_no;
	}

	public void setC_js_no(BigDecimal b_no) {
		this.b_no = b_no;
	}

	public String getC_writer() {
		return c_writer;
	}

	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}

	public Date getC_regDate() {
		return c_regDate;
	}

	public void setC_regDate(Date c_regDate) {
		this.c_regDate = c_regDate;
	}

	public String getC_txt() {
		return c_txt;
	}

	public void setC_txt(String c_txt) {
		this.c_txt = c_txt;
	}
}