package com.bean;
import java.util.*;
import java.nio.charset.*;

public class Registrationbean {
	private String regFname,regMname,regLname,dob,gender,state,city,email,mobno,pass,healthid;
	public Registrationbean(){}
	public Registrationbean(String regFname, String regMname, String regLname,
			String dob, String gender, String state, String city, String email,
			String mobno, String pass, String healthid) {
		super();
		this.regFname = regFname;
		this.regMname = regMname;
		this.regLname = regLname;
		this.dob = dob;
		this.gender = gender;
		this.state = state;
		this.city = city;
		this.email = email;
		this.mobno = mobno;
		this.pass = pass;
		this.healthid = healthid;
	}
	 
	public String getRegFname() {
		return regFname;
	}
	public void setRegFname(String regFname) {
		this.regFname = regFname;
	}
	public String getRegMname() {
		return regMname;
	}
	public void setRegMname(String regMname) {
		this.regMname = regMname;
	}
	public String getRegLname() {
		return regLname;
	}
	public void setRegLname(String regLname) {
		this.regLname = regLname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getHealthid() {
		return healthid;
	}
	public void setHealthid(String healthid) {
		
		this.healthid = healthid;
	};
	public void createHealthid() {
		int n = 20;
	     byte[] array = new byte[256];
	     new Random().nextBytes(array);
	     String randomString= new String(array, Charset.forName("UTF-8"));
	     StringBuffer r = new StringBuffer();
	     for (int k = 0; k < randomString.length(); k++) {  
	         char ch = randomString.charAt(k);  
	         if (((ch >= 'a' && ch <= 'z')
	              || (ch >= 'A' && ch <= 'Z')
	              || (ch >= '0' && ch <= '9'))
	             && (n > 0)) {  
	             r.append(ch);
	             n--;
	         }
	     }
		this.healthid = r.toString();
	};

}
