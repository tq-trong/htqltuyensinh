package com.cusc.htqltuyensinh.dto;

public class SchoolDTO extends BaseDTO<SchoolDTO>{
	
	private String code;
	private String name;
	private long province;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getProvince() {
		return province;
	}
	public void setProvince(long province) {
		this.province = province;
	}
	
	
}
