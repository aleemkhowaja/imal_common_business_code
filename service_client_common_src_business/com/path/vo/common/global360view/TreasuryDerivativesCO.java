package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

public class TreasuryDerivativesCO extends RetailBaseVO {
	
	private BigDecimal dealCY;
	private String currencyDesc;
	private BigDecimal promissoryFX;
	private BigDecimal profitRateSwap;
	private BigDecimal crossCYSwap;
	private BigDecimal currDecimalPoints;
	
	
	public BigDecimal getDealCY() {
		return dealCY;
	}
	public void setDealCY(BigDecimal dealCY) {
		this.dealCY = dealCY;
	}
	public String getCurrencyDesc() {
		return currencyDesc;
	}
	public void setCurrencyDesc(String currencyDesc) {
		this.currencyDesc = currencyDesc;
	}
	public BigDecimal getPromissoryFX() {
		return promissoryFX;
	}
	public void setPromissoryFX(BigDecimal promissoryFX) {
		this.promissoryFX = promissoryFX;
	}
	public BigDecimal getProfitRateSwap() {
		return profitRateSwap;
	}
	public void setProfitRateSwap(BigDecimal profitRateSwap) {
		this.profitRateSwap = profitRateSwap;
	}
	public BigDecimal getCrossCYSwap() {
		return crossCYSwap;
	}
	public void setCrossCYSwap(BigDecimal crossCYSwap) {
		this.crossCYSwap = crossCYSwap;
	}
	public BigDecimal getCurrDecimalPoints() {
		return currDecimalPoints;
	}
	public void setCurrDecimalPoints(BigDecimal currDecimalPoints) {
		this.currDecimalPoints = currDecimalPoints;
	}

}
