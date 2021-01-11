package com.path.dbmaps.vo;

import java.math.BigDecimal;

import com.path.lib.vo.BaseVO;

public class CIF_COUNTRY_INFOVOKey extends BaseVO{
	
    private BigDecimal COMP_CODE;
    private BigDecimal CIF_NO;
    private BigDecimal COUNTRY_CODE;

    
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
	public BigDecimal getCOUNTRY_CODE() {
		return COUNTRY_CODE;
	}
	public void setCOUNTRY_CODE(BigDecimal COUNTRY_CODE) {
		this.COUNTRY_CODE = COUNTRY_CODE;
	}
   
}
