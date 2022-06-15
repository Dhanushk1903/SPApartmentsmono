package com.main.dto;

import com.main.entity.Admin;

public class AdminDTO {
	private String aid;
	private String aname;
	private String password;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
//	admin dto to entity conversion
	public static Admin entitytoDTO ( AdminDTO adminDTO) {
		Admin admin= new Admin();
		admin.setAid(adminDTO.getAid());
		admin.setAname(adminDTO.getAname());
		admin.setPassword(adminDTO.getPassword());
		return admin;
	}
	
}
