package com.ki.jun091tp.map;

import java.math.BigDecimal;

public class Subway {
	private BigDecimal sub_no;
	private String sub_line_name;
	private String sub_station;
	private BigDecimal sub_latitude;
	private BigDecimal sub_longitude;
	private String sub_telno_info;
	private String u_id;
	private BigDecimal rn;
	
	public Subway() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Subway(BigDecimal sub_no, String sub_line_name, String sub_station, BigDecimal sub_latitude,
			BigDecimal sub_longitude, String sub_telno_info, String u_id, BigDecimal rn) {
		super();
		this.sub_no = sub_no;
		this.sub_line_name = sub_line_name;
		this.sub_station = sub_station;
		this.sub_latitude = sub_latitude;
		this.sub_longitude = sub_longitude;
		this.sub_telno_info = sub_telno_info;
		this.u_id = u_id;
		this.rn = rn;
	}


	public BigDecimal getSub_no() {
		return sub_no;
	}

	public void setSub_no(BigDecimal sub_no) {
		this.sub_no = sub_no;
	}

	public String getSub_line_name() {
		return sub_line_name;
	}

	public void setSub_line_name(String sub_line_name) {
		this.sub_line_name = sub_line_name;
	}

	public String getSub_station() {
		return sub_station;
	}

	public void setSub_station(String sub_station) {
		this.sub_station = sub_station;
	}

	public BigDecimal getSub_latitude() {
		return sub_latitude;
	}

	public void setSub_latitude(BigDecimal sub_latitude) {
		this.sub_latitude = sub_latitude;
	}

	public BigDecimal getSub_longitude() {
		return sub_longitude;
	}

	public void setSub_longitude(BigDecimal sub_longitude) {
		this.sub_longitude = sub_longitude;
	}

	public String getSub_telno_info() {
		return sub_telno_info;
	}

	public void setSub_telno_info(String sub_telno_info) {
		this.sub_telno_info = sub_telno_info;
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
