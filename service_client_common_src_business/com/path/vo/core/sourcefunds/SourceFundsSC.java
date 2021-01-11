package com.path.vo.core.sourcefunds;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author mariachamieh
 * 
 *          SourceFundsSC.java used to
 */
public class SourceFundsSC extends GridParamsSC
{
	private BigDecimal code;
	private String SOURCE_FUNDS_CODE;
	private String BRIEF_DESC_ENG;
	private String LONG_DESC_ENG;
	
	public BigDecimal getCode() {
		return code;
	}

	public void setCode(BigDecimal code) {
		this.code = code;
	}

	public String getSOURCE_FUNDS_CODE() {
		return SOURCE_FUNDS_CODE;
	}

	public void setSOURCE_FUNDS_CODE(String sOURCE_FUNDS_CODE) {
		SOURCE_FUNDS_CODE = sOURCE_FUNDS_CODE;
	}

	public String getBRIEF_DESC_ENG() {
		return BRIEF_DESC_ENG;
	}

	public void setBRIEF_DESC_ENG(String bRIEF_DESC_ENG) {
		BRIEF_DESC_ENG = bRIEF_DESC_ENG;
	}

	public String getLONG_DESC_ENG() {
		return LONG_DESC_ENG;
	}

	public void setLONG_DESC_ENG(String lONG_DESC_ENG) {
		LONG_DESC_ENG = lONG_DESC_ENG;
	}
}
