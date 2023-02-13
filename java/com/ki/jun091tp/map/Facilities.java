package com.ki.jun091tp.map;

import java.math.BigDecimal;

public class Facilities {
	private BigDecimal f_no;
	private String f_fclt_nm;
	private String f_FCLT_KIND_NM;
	private String f_JRSD_SGG_NM;
	private String f_FCLT_ADDR;
	private BigDecimal f_Latitude;
	private BigDecimal f_Longitude;
	private String u_id;
	private BigDecimal rn;

	
	public Facilities() {
		// TODO Auto-generated constructor stub
	}



	public Facilities(BigDecimal f_no, String f_fclt_nm, String f_FCLT_KIND_NM, String f_JRSD_SGG_NM,
			String f_FCLT_ADDR, BigDecimal f_Latitude, BigDecimal f_Longitude, String u_id, BigDecimal rn) {
		super();
		this.f_no = f_no;
		this.f_fclt_nm = f_fclt_nm;
		this.f_FCLT_KIND_NM = f_FCLT_KIND_NM;
		this.f_JRSD_SGG_NM = f_JRSD_SGG_NM;
		this.f_FCLT_ADDR = f_FCLT_ADDR;
		this.f_Latitude = f_Latitude;
		this.f_Longitude = f_Longitude;
		this.u_id = u_id;
		this.rn = rn;
	}





	public BigDecimal getF_no() {
		return f_no;
	}


	public void setF_no(BigDecimal f_no) {
		this.f_no = f_no;
	}


	public String getF_fclt_nm() {
		return f_fclt_nm;
	}


	public void setF_fclt_nm(String f_fclt_nm) {
		this.f_fclt_nm = f_fclt_nm;
	}


	public String getF_FCLT_KIND_NM() {
		return f_FCLT_KIND_NM;
	}


	public void setF_FCLT_KIND_NM(String f_FCLT_KIND_NM) {
		this.f_FCLT_KIND_NM = f_FCLT_KIND_NM;
	}


	public String getF_JRSD_SGG_NM() {
		return f_JRSD_SGG_NM;
	}


	public void setF_JRSD_SGG_NM(String f_JRSD_SGG_NM) {
		this.f_JRSD_SGG_NM = f_JRSD_SGG_NM;
	}

	public String getF_FCLT_ADDR() {
		return f_FCLT_ADDR;
	}


	public void setF_FCLT_ADDR(String f_FCLT_ADDR) {
		this.f_FCLT_ADDR = f_FCLT_ADDR;
	}


	public BigDecimal getF_Latitude() {
		return f_Latitude;
	}


	public void setF_Latitude(BigDecimal f_Latitude) {
		this.f_Latitude = f_Latitude;
	}


	public BigDecimal getF_Longitude() {
		return f_Longitude;
	}

	public void setF_Longitude(BigDecimal f_Longitude) {
		this.f_Longitude = f_Longitude;
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
