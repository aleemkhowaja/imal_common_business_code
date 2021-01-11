package com.path.vo.core.floatingratecode;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FloatingRateCodeSC extends GridParamsSC {
	
	private BigDecimal IBOR_CODE;
	private String BRIEF_DESC_ENG;
	
	public BigDecimal getIBOR_CODE() {
		return IBOR_CODE;
	}
	public void setIBOR_CODE(BigDecimal iBORCODE) {
		IBOR_CODE = iBORCODE;
	}
	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}
	public void setBRIEF_DESC_ENG(String bRIEFDESCENG) {
		BRIEF_DESC_ENG = bRIEFDESCENG;
	}
	


}
