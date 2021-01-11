package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CIF_KYC_FINANC_INFO_CNTRYVOKey extends BaseVO{
	
    private BigDecimal 	COMP_CODE;
    private BigDecimal 	CIF_NO;
    private BigDecimal 	LINE_NO;
    private String		KYC_FINANCIAL_TYPE;
    private BigDecimal 	COUNTRY_CODE;
    
	public BigDecimal getCOMP_CODE() {
		return COMP_CODE;
	}
	public void setCOMP_CODE(BigDecimal COMP_CODE) {
		this.COMP_CODE = COMP_CODE;
	}
	public BigDecimal getCIF_NO() {
		return CIF_NO;
	}
	public void setCIF_NO(BigDecimal CIF_NO) {
		this.CIF_NO = CIF_NO;
	}
	public BigDecimal getLINE_NO() {
		return LINE_NO;
	}
	public void setLINE_NO(BigDecimal LINE_NO) {
		this.LINE_NO = LINE_NO;
	}
	public String getKYC_FINANCIAL_TYPE() {
		return KYC_FINANCIAL_TYPE;
	}
	public void setKYC_FINANCIAL_TYPE(String KYC_FINANCIAL_TYPE) {
        this.KYC_FINANCIAL_TYPE = KYC_FINANCIAL_TYPE == null ? null : KYC_FINANCIAL_TYPE.trim();
	}
	public BigDecimal getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}
	public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE) {
		this.COUNTRY_CODE = COUNTRY_CODE;
	}
    

    
}
