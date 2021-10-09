package com.bean;

public class MedicalInfoBean {
	String bg,bp,height,weight,allergies,memail;
	public MedicalInfoBean(){}
	public MedicalInfoBean(String bg, String bp, String height, String weight,
			String allergies, String memail) {
		super();
		this.bg = bg;
		this.bp = bp;
		this.height = height;
		this.weight = weight;
		this.allergies = allergies;
		this.memail = memail;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getBp() {
		return bp;
	}
	public void setBp(String bp) {
		this.bp = bp;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	
}
