package com.bean;

public class DiseaseBean {
	String DNAME,DDATE,DSYMP,DMED,DLOC,DHEIR,DEMAIL;
	public DiseaseBean(){}
	public DiseaseBean(String dNAME, String dDATE, String dSYMP, String dMED,
			String dLOC, String dHEIR, String dEMAIL) {
		super();
		DNAME = dNAME;
		DDATE = dDATE;
		DSYMP = dSYMP;
		DMED = dMED;
		DLOC = dLOC;
		DHEIR = dHEIR;
		DEMAIL = dEMAIL;
	}
	public String getDNAME() {
		return DNAME;
	}
	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}
	public String getDDATE() {
		return DDATE;
	}
	public void setDDATE(String dDATE) {
		DDATE = dDATE;
	}
	public String getDSYMP() {
		return DSYMP;
	}
	public void setDSYMP(String dSYMP) {
		DSYMP = dSYMP;
	}
	public String getDMED() {
		return DMED;
	}
	public void setDMED(String dMED) {
		DMED = dMED;
	}
	public String getDLOC() {
		return DLOC;
	}
	public void setDLOC(String dLOC) {
		DLOC = dLOC;
	}
	public String getDHEIR() {
		return DHEIR;
	}
	public void setDHEIR(String dHEIR) {
		DHEIR = dHEIR;
	}
	public String getDEMAIL() {
		return DEMAIL;
	}
	public void setDEMAIL(String dEMAIL) {
		DEMAIL = dEMAIL;
	}
	
}
