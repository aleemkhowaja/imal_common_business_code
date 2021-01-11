package com.path.vo.core.ciftrxtypelimit;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifTrxTypeLimitSC extends GridParamsSC {

	private BigDecimal currencyCode;
	private BigDecimal countryCode;
	public BigDecimal getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(BigDecimal currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(BigDecimal countryCode) {
		this.countryCode = countryCode;
	}
	 
}
