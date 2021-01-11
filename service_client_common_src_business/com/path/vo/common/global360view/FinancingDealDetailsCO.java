package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.TRSDEALVO;
import com.path.vo.core.common.RetailBaseVO;

public class FinancingDealDetailsCO extends RetailBaseVO {

	
	private TRSDEALVO trsDealVO;
	private BigDecimal currDecimalPoints;
	private String currBriefDescEng;
	private String cifLongNameEng;
	private String branchBriefDescEng;
	private String prodBriefNameEng;
	private Integer prodClassCode;
	private BigDecimal dealAmt;
	private BigDecimal yield;
	private BigDecimal cvAmt;
	private String status;
	
	private Date valueDate;
	private BigDecimal amount;
	private BigDecimal fromFacility;
	
//	DBU191081 Muhammed Anas Start 
	private BigDecimal remainingAmt;
	private String boughtCurrency;
	private String soldCurrency;
//	DBU191081 Muhammed Anas End	
	
	public TRSDEALVO getTrsDealVO() {
		return trsDealVO;
	}
	public void setTrsDealVO(TRSDEALVO trsDealVO) {
		this.trsDealVO = trsDealVO;
	}
	public BigDecimal getCurrDecimalPoints() {
		return currDecimalPoints;
	}
	public void setCurrDecimalPoints(BigDecimal currDecimalPoints) {
		this.currDecimalPoints = currDecimalPoints;
	}
	public String getCurrBriefDescEng() {
		return currBriefDescEng;
	}
	public void setCurrBriefDescEng(String currBriefDescEng) {
		this.currBriefDescEng = currBriefDescEng;
	}
	public String getCifLongNameEng() {
		return cifLongNameEng;
	}
	public void setCifLongNameEng(String cifLongNameEng) {
		this.cifLongNameEng = cifLongNameEng;
	}
	public String getBranchBriefDescEng() {
		return branchBriefDescEng;
	}
	public void setBranchBriefDescEng(String branchBriefDescEng) {
		this.branchBriefDescEng = branchBriefDescEng;
	}
	public BigDecimal getDealAmt() {
		return dealAmt;
	}
	public void setDealAmt(BigDecimal dealAmt) {
		this.dealAmt = dealAmt;
	}
	public BigDecimal getYield() {
		return yield;
	}
	public void setYield(BigDecimal yield) {
		this.yield = yield;
	}
	public void setProdBriefNameEng(String prodBriefNameEng) {
		this.prodBriefNameEng = prodBriefNameEng;
	}
	public String getProdBriefNameEng() {
		return prodBriefNameEng;
	}
	public void setCvAmt(BigDecimal cvAmt) {
		this.cvAmt = cvAmt;
	}
	public BigDecimal getCvAmt() {
		/*if(trsDealVO.getDEAL_MULTDIV().equalsIgnoreCase(AccountsConstant.MULT_DIV_IND_MUL))
		{
		    if(NumberUtil.isEmptyDecimal(trsDealVO.getDEAL_RATE()) || trsDealVO.getDEAL_RATE().compareTo(BigDecimal.ZERO) == 0)
		    {
		    	
		    	cvAmt = NumberUtil.roundToBigDecimal(dealAmt, currDecimalPoints.intValue());
		    }
		    else
		    {
		    	cvAmt = dealAmt.multiply(trsDealVO.getDEAL_RATE()).divide( trsDealVO.getDEAL_UNIT(), currDecimalPoints.intValue(), RoundingMode.HALF_UP);
		    }
		}
		else if(trsDealVO.getDEAL_MULTDIV().equalsIgnoreCase(AccountsConstant.MULT_DIV_IND_DIV))
		{
		    if(NumberUtil.isEmptyDecimal(trsDealVO.getDEAL_RATE()) || trsDealVO.getDEAL_RATE().compareTo(BigDecimal.ZERO) == 0)
		    {
		    	cvAmt = NumberUtil.roundToBigDecimal(dealAmt, currDecimalPoints.intValue());
		    }
		    else
		    {	
		    	cvAmt  = dealAmt.divide(trsDealVO.getDEAL_RATE(),   currDecimalPoints.intValue(), RoundingMode.HALF_UP).multiply( trsDealVO.getDEAL_UNIT());
		    }
		}*/
		return cvAmt;
	}
	public void setProdClassCode(Integer prodClassCode) {
		this.prodClassCode = prodClassCode;
	}
	public Integer getProdClassCode() {
		return prodClassCode;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setFromFacility(BigDecimal fromFacility) {
		this.fromFacility = fromFacility;
	}
	public BigDecimal getFromFacility() {
		return fromFacility;
	}
	public BigDecimal getRemainingAmt() {
		return remainingAmt;
	}
	public void setRemainingAmt(BigDecimal remainingAmt) {
		this.remainingAmt = remainingAmt;
	}
	public String getBoughtCurrency() {
		return boughtCurrency;
	}
	public void setBoughtCurrency(String boughtCurrency) {
		this.boughtCurrency = boughtCurrency;
	}
	public String getSoldCurrency() {
		return soldCurrency;
	}
	public void setSoldCurrency(String soldCurrency) {
		this.soldCurrency = soldCurrency;
	}
	
	 
	
}
