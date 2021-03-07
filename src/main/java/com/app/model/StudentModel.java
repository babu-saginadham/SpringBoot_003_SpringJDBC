package com.app.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentModel {

	Long sno;
	String sname;
	
	public Long getSno() {
		return sno;
	}
	public void setSno(Long sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
