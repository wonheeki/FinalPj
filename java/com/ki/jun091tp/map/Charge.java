package com.ki.jun091tp.map;

import java.math.BigDecimal;

public class Charge {
	private BigDecimal ch_no;
	private String ch_FCLTYNM;
	private String ch_SIGNGUNM;
	private String ch_RDNMADR;
	private BigDecimal ch_Latitude;
	private BigDecimal ch_Longitude;
	private String ch_INSTLLCDESC;
	private String ch_WEEKDAYOPEROPENHHMM;
	private String ch_WEEKDAYOPERCOLSEHHMM;
	private String ch_SATOPEROPEROPENHHMM;
	private String ch_SATOPERCLOSEHHMM;
	private String ch_INSTITUTIONNM;
	private String ch_INSTITUTIONPHONENUMBER;
	private String u_id;
	private BigDecimal rn;
	
	public Charge() {
		// TODO Auto-generated constructor stub
	}

	

	public Charge(BigDecimal ch_no, String ch_FCLTYNM, String ch_SIGNGUNM, String ch_RDNMADR, BigDecimal ch_Latitude,
			BigDecimal ch_Longitude, String ch_INSTLLCDESC, String ch_WEEKDAYOPEROPENHHMM,
			String ch_WEEKDAYOPERCOLSEHHMM, String ch_SATOPEROPEROPENHHMM, String ch_SATOPERCLOSEHHMM,
			String ch_INSTITUTIONNM, String ch_INSTITUTIONPHONENUMBER, String u_id, BigDecimal rn) {
		super();
		this.ch_no = ch_no;
		this.ch_FCLTYNM = ch_FCLTYNM;
		this.ch_SIGNGUNM = ch_SIGNGUNM;
		this.ch_RDNMADR = ch_RDNMADR;
		this.ch_Latitude = ch_Latitude;
		this.ch_Longitude = ch_Longitude;
		this.ch_INSTLLCDESC = ch_INSTLLCDESC;
		this.ch_WEEKDAYOPEROPENHHMM = ch_WEEKDAYOPEROPENHHMM;
		this.ch_WEEKDAYOPERCOLSEHHMM = ch_WEEKDAYOPERCOLSEHHMM;
		this.ch_SATOPEROPEROPENHHMM = ch_SATOPEROPEROPENHHMM;
		this.ch_SATOPERCLOSEHHMM = ch_SATOPERCLOSEHHMM;
		this.ch_INSTITUTIONNM = ch_INSTITUTIONNM;
		this.ch_INSTITUTIONPHONENUMBER = ch_INSTITUTIONPHONENUMBER;
		this.u_id = u_id;
		this.rn = rn;
	}



	public BigDecimal getCh_no() {
		return ch_no;
	}

	public void setCh_no(BigDecimal ch_no) {
		this.ch_no = ch_no;
	}

	public String getCh_FCLTYNM() {
		return ch_FCLTYNM;
	}

	public void setCh_FCLTYNM(String ch_FCLTYNM) {
		this.ch_FCLTYNM = ch_FCLTYNM;
	}

	public String getCh_SIGNGUNM() {
		return ch_SIGNGUNM;
	}

	public void setCh_SIGNGUNM(String ch_SIGNGUNM) {
		this.ch_SIGNGUNM = ch_SIGNGUNM;
	}

	public String getCh_RDNMADR() {
		return ch_RDNMADR;
	}

	public void setCh_RDNMADR(String ch_RDNMADR) {
		this.ch_RDNMADR = ch_RDNMADR;
	}

	public BigDecimal getCh_Latitude() {
		return ch_Latitude;
	}

	public void setCh_Latitude(BigDecimal ch_Latitude) {
		this.ch_Latitude = ch_Latitude;
	}

	public BigDecimal getCh_Longitude() {
		return ch_Longitude;
	}

	public void setCh_Longitude(BigDecimal ch_Longitude) {
		this.ch_Longitude = ch_Longitude;
	}

	public String getCh_INSTLLCDESC() {
		return ch_INSTLLCDESC;
	}

	public void setCh_INSTLLCDESC(String ch_INSTLLCDESC) {
		this.ch_INSTLLCDESC = ch_INSTLLCDESC;
	}

	public String getCh_WEEKDAYOPEROPENHHMM() {
		return ch_WEEKDAYOPEROPENHHMM;
	}

	public void setCh_WEEKDAYOPEROPENHHMM(String ch_WEEKDAYOPEROPENHHMM) {
		this.ch_WEEKDAYOPEROPENHHMM = ch_WEEKDAYOPEROPENHHMM;
	}

	public String getCh_WEEKDAYOPERCOLSEHHMM() {
		return ch_WEEKDAYOPERCOLSEHHMM;
	}

	public void setCh_WEEKDAYOPERCOLSEHHMM(String ch_WEEKDAYOPERCOLSEHHMM) {
		this.ch_WEEKDAYOPERCOLSEHHMM = ch_WEEKDAYOPERCOLSEHHMM;
	}

	public String getCh_SATOPEROPEROPENHHMM() {
		return ch_SATOPEROPEROPENHHMM;
	}

	public void setCh_SATOPEROPEROPENHHMM(String ch_SATOPEROPEROPENHHMM) {
		this.ch_SATOPEROPEROPENHHMM = ch_SATOPEROPEROPENHHMM;
	}

	public String getCh_SATOPERCLOSEHHMM() {
		return ch_SATOPERCLOSEHHMM;
	}

	public void setCh_SATOPERCLOSEHHMM(String ch_SATOPERCLOSEHHMM) {
		this.ch_SATOPERCLOSEHHMM = ch_SATOPERCLOSEHHMM;
	}

	public String getCh_INSTITUTIONNM() {
		return ch_INSTITUTIONNM;
	}

	public void setCh_INSTITUTIONNM(String ch_INSTITUTIONNM) {
		this.ch_INSTITUTIONNM = ch_INSTITUTIONNM;
	}

	public String getCh_INSTITUTIONPHONENUMBER() {
		return ch_INSTITUTIONPHONENUMBER;
	}

	public void setCh_INSTITUTIONPHONENUMBER(String ch_INSTITUTIONPHONENUMBER) {
		this.ch_INSTITUTIONPHONENUMBER = ch_INSTITUTIONPHONENUMBER;
	}



	public String getU_id() {
		return u_id;
	}



	public void setU_id(String u_id) {
		this.u_id = u_id;
	}



	public BigDecimal getRn() {
		return rn;
	}



	public void setRn(BigDecimal rn) {
		this.rn = rn;
	}
	
	
}
