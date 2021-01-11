package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealsLimitUtilizationCO extends RetailBaseVO {
	
	
	private BigDecimal globalLimit;
	private BigDecimal utilizedAmt;
	private BigDecimal outstandingAmt;
	private Integer  currency;
	private String currencyDesc;
	private BigDecimal decimalPoints;
	
	public BigDecimal getGlobalLimit() {
		return globalLimit;
	}
	public void setGlobalLimit(BigDecimal globalLimit) {
		this.globalLimit = globalLimit;
	}
 
	public BigDecimal getOutstandingAmt() {
		return outstandingAmt;
	}
	public void setOutstandingAmt(BigDecimal outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}
	public Integer getCurrency() {
		return currency;
	}
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	public void setUtilizedAmt(BigDecimal utilizedAmt) {
		this.utilizedAmt = utilizedAmt;
	}
	public BigDecimal getUtilizedAmt() {
		return utilizedAmt;
	}
	public void setDecimalPoints(BigDecimal decimalPoints) {
		this.decimalPoints = decimalPoints;
	}
	public BigDecimal getDecimalPoints() {
		return decimalPoints;
	}

}
