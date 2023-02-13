package com.ki.jun091tp.board;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Board {
	
	private BigDecimal rn;
	private BigDecimal b_no;
	private String b_title;
	private String b_txt;
	private String u_id;
	private String b_writer;
	private Date b_regDate;
	private BigDecimal b_readCounter;
	
	private List<Comment> b_comment; // 댓글들
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(BigDecimal rn, BigDecimal b_no, String b_title, String b_txt, String u_id, String b_writer,
			Date b_regDate, BigDecimal b_readCounter, List<Comment> b_comment) {
		super();
		this.rn = rn;
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_txt = b_txt;
		this.u_id = u_id;
		this.b_writer = b_writer;
		this.b_regDate = b_regDate;
		this.b_readCounter = b_readCounter;
		this.b_comment = b_comment;
	}


	public BigDecimal getRn() {
		return rn;
	}


	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}


	public BigDecimal getB_no() {
		return b_no;
	}


	public void setB_no(BigDecimal b_no) {
		this.b_no = b_no;
	}


	public String getB_title() {
		return b_title;
	}


	public void setB_title(String b_title) {
		this.b_title = b_title;
	}


	public String getB_txt() {
		return b_txt;
	}


	public void setB_txt(String b_txt) {
		this.b_txt = b_txt;
	}


	public String getU_id() {
		return u_id;
	}


	public void setU_id(String u_id) {
		this.u_id = u_id;
	}


	public String getB_writer() {
		return b_writer;
	}


	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}


	public Date getB_regDate() {
		return b_regDate;
	}


	public void setB_regDate(Date b_regDate) {
		this.b_regDate = b_regDate;
	}


	public BigDecimal getB_readCounter() {
		return b_readCounter;
	}


	public void setB_readCounter(BigDecimal b_readCounter) {
		this.b_readCounter = b_readCounter;
	}


	public List<Comment> getB_comment() {
		return b_comment;
	}


	public void setB_comment(List<Comment> b_comment) {
		this.b_comment = b_comment;
	}
	
	
}
