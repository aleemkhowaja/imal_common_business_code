package com.path.vo.core.gl;

import java.io.Serializable;
import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

public class GLCO extends RetailBaseVO implements Serializable{
	private BigDecimal GL_CODE;  
	private String BRIEF_DESC_ENG;  
	private String BRIEF_DESC_ARAB;
	private String AC_SIGN ;
	private String ADDITIONAL_REFERENCE;
	private String BS_CONTRA;
	private String CATEGORY;
	private String TERM_IND;
	private BigDecimal TERM_DAYS;
    
	private String LONG_DESC_ENG;
    private String LONG_DESC_ARAB;
    private String GL_TYPE;
  	
    public BigDecimal getGL_CODE() {
		return GL_CODE;
	}
	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}
	public String getBRIEF_DESC_ARAB() {
		return BRIEF_DESC_ARAB;
	}
	public String getAC_SIGN() {
		return AC_SIGN;
	}
	public String getADDITIONAL_REFERENCE() {
		return ADDITIONAL_REFERENCE;
	}
	public String getBS_CONTRA() {
		return BS_CONTRA;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public String getTERM_IND() {
		return TERM_IND;
	}
	public BigDecimal getTERM_DAYS() {
		return TERM_DAYS;
	}
	public void setGL_CODE(BigDecimal gLCODE) {
		GL_CODE = gLCODE;
	}
	public void setBRIEF_DESC_ENG(String bRIEFDESCENG) {
		BRIEF_DESC_ENG = bRIEFDESCENG;
	}
	public void setBRIEF_DESC_ARAB(String bRIEFDESCARAB) {
		BRIEF_DESC_ARAB = bRIEFDESCARAB;
	}
	public void setAC_SIGN(String aCSIGN) {
		AC_SIGN = aCSIGN;
	}
	public void setADDITIONAL_REFERENCE(String aDDITIONALREFERENCE) {
		ADDITIONAL_REFERENCE = aDDITIONALREFERENCE;
	}
	public void setBS_CONTRA(String bSCONTRA) {
		BS_CONTRA = bSCONTRA;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public void setTERM_IND(String tERMIND) {
		TERM_IND = tERMIND;
	}
	public void setTERM_DAYS(BigDecimal tERMDAYS) {
		TERM_DAYS = tERMDAYS;
	}
	public String getLONG_DESC_ENG() {
		return LONG_DESC_ENG;
	}
	public void setLONG_DESC_ENG(String lONGDESCENG) {
		LONG_DESC_ENG = lONGDESCENG;
	}
	public String getLONG_DESC_ARAB() {
		return LONG_DESC_ARAB;
	}
	public void setLONG_DESC_ARAB(String lONGDESCARAB) {
		LONG_DESC_ARAB = lONGDESCARAB;
	}
	public String getGL_TYPE() {
		return GL_TYPE;
	}
	public void setGL_TYPE(String gLTYPE) {
		GL_TYPE = gLTYPE;
	}

}
