package com.path.vo.common.global360view;

import java.math.BigDecimal;

import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealsCO extends RetailBaseVO {
	
	

	private String category;

	

	private BigDecimal totalAmt  = BigDecimal.ZERO;
	private BigDecimal settledAmt  =BigDecimal.ZERO;
	private BigDecimal outstandingAmt =BigDecimal.ZERO;
	private BigDecimal earnedProfit =BigDecimal.ZERO;
	private BigDecimal overdueAmt  =BigDecimal.ZERO;
	private BigDecimal guarantees= BigDecimal.ZERO;
	private BigDecimal collaterals =BigDecimal.ZERO;
	private BigDecimal promissoryNotes =BigDecimal.ZERO;
	private BigDecimal decimalPoints;
	private String multiDivInd;
	private BigDecimal dealRate;
	private BigDecimal unit;
	private String categoryId;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	public BigDecimal getSettledAmt() {
		return settledAmt;
	}
	public void setSettledAmt(BigDecimal settledAmt) {
		this.settledAmt = settledAmt;
	}
	public BigDecimal getOutstandingAmt() {
		return outstandingAmt;
	}
	public void setOutstandingAmt(BigDecimal outstandingAmt) {
		this.outstandingAmt = outstandingAmt;
	}
	public BigDecimal getEarnedProfit() {
		return earnedProfit;
	}
	public void setEarnedProfit(BigDecimal earnedProfit) {
		this.earnedProfit = earnedProfit;
	}
	public BigDecimal getOverdueAmt() {
		return overdueAmt;
	}
	public void setOverdueAmt(BigDecimal overdueAmt) {
		this.overdueAmt = overdueAmt;
	} 
	public BigDecimal getCollaterals() {
		return collaterals;
	}
	public void setCollaterals(BigDecimal collaterals) {
		this.collaterals = collaterals;
	}
	public BigDecimal getPromissoryNotes() {
		return promissoryNotes;
	}
	public void setPromissoryNotes(BigDecimal promissoryNotes) {
		this.promissoryNotes = promissoryNotes;
	}
	public void setGuarantees(BigDecimal guarantees) {
		this.guarantees = guarantees;
	}
	public BigDecimal getGuarantees() {
		return guarantees;
	}
	public BigDecimal getDecimalPoints() {
		return decimalPoints;
	}
	public void setDecimalPoints(BigDecimal decimalPoints) {
		this.decimalPoints = decimalPoints;
	}
	public String getMultiDivInd() {
		return multiDivInd;
	}
	public void setMultiDivInd(String multiDivInd) {
		this.multiDivInd = multiDivInd;
	}
	public BigDecimal getDealRate() {
		return dealRate;
	}
	public void setDealRate(BigDecimal dealRate) {
		this.dealRate = dealRate;
	}
	public BigDecimal getUnit() {
		return unit;
	}
	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}
	public String getCategoryId()
	{
	    return categoryId;
	}
	public void setCategoryId(String categoryId)
	{
	    this.categoryId = categoryId;
	}

}
