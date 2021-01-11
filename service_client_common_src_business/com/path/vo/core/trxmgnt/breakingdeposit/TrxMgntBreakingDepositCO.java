package com.path.vo.core.trxmgnt.breakingdeposit;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CTSTRS_BENEF_DETVO;
import com.path.dbmaps.vo.CTSTRS_BREAK_DEPVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntBreakingDepositCO extends RetailBaseVO{
 
	
	
	
	
	
	private CTSTRS_BENEF_DETVO ctsTrsBenefDetVO;
	private CTSTRS_BREAK_DEPVO ctstrsBreakOfDeposit ;
	private String MORE_BENEF_DESC_CITY;
	private AMFVO amfVO ;
	private AMFVO istrInvAcc ;
	private AMFVO istrToAcc ;
	
	private String relatedGl;
	private String fullBreakDeposit;
	private String excludePcsDistribution;
	
	private BigDecimal zakatCV;
	private BigDecimal zakatFC;
	private BigDecimal zakatChgCV;
	private BigDecimal zakatChgFC;
	private Date systemDate;
	private BigDecimal baseCurrency;
	private BigDecimal baseCurrencyDecimal;
	
	
	private BigDecimal adecAccrualCv;
	private BigDecimal adecAccrualFc;
	private BigDecimal adecAdvCv;
	private BigDecimal adecAdvFC;
	
	
	private BigDecimal adecBal;
	private BigDecimal adecProfit;
	private BigDecimal adecPenalty;
	private BigDecimal adecNetProfit;
	private String asOverPenalty;

	private String errorCode;
	private String errorMessage;
	
	
		
	public BigDecimal getAdecBal() {
		return adecBal;
	}

	public BigDecimal getAdecProfit() {
		return adecProfit;
	}

	public BigDecimal getAdecPenalty() {
		return adecPenalty;
	}

	public BigDecimal getAdecNetProfit() {
		return adecNetProfit;
	}

	public String getAsOverPenalty() {
		return asOverPenalty;
	}

	public void setAdecBal(BigDecimal adecBal) {
		this.adecBal = adecBal;
	}

	public void setAdecProfit(BigDecimal adecProfit) {
		this.adecProfit = adecProfit;
	}

	public void setAdecPenalty(BigDecimal adecPenalty) {
		this.adecPenalty = adecPenalty;
	}

	public void setAdecNetProfit(BigDecimal adecNetProfit) {
		this.adecNetProfit = adecNetProfit;
	}

	public void setAsOverPenalty(String asOverPenalty) {
		this.asOverPenalty = asOverPenalty;
	}

	public BigDecimal getAdecAccrualCv() {
		return adecAccrualCv;
	}

	public BigDecimal getAdecAccrualFc() {
		return adecAccrualFc;
	}

	public BigDecimal getAdecAdvCv() {
		return adecAdvCv;
	}

	public BigDecimal getAdecAdvFC() {
		return adecAdvFC;
	}

	public void setAdecAccrualCv(BigDecimal adecAccrualCv) {
		this.adecAccrualCv = adecAccrualCv;
	}

	public void setAdecAccrualFc(BigDecimal adecAccrualFc) {
		this.adecAccrualFc = adecAccrualFc;
	}

	public void setAdecAdvCv(BigDecimal adecAdvCv) {
		this.adecAdvCv = adecAdvCv;
	}

	public void setAdecAdvFC(BigDecimal adecAdvFC) {
		this.adecAdvFC = adecAdvFC;
	}

	public String getExcludePcsDistribution() {
		return excludePcsDistribution;
	}

	public void setExcludePcsDistribution(String excludePcsDistribution) {
		this.excludePcsDistribution = excludePcsDistribution;
	}

	public BigDecimal getBaseCurrency() {
		return baseCurrency;
	}

	public BigDecimal getBaseCurrencyDecimal() {
		return baseCurrencyDecimal;
	}

	public void setBaseCurrency(BigDecimal baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public void setBaseCurrencyDecimal(BigDecimal baseCurrencyDecimal) {
		this.baseCurrencyDecimal = baseCurrencyDecimal;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public BigDecimal getZakatCV() {
		return zakatCV;
	}

	public BigDecimal getZakatFC() {
		return zakatFC;
	}

	public BigDecimal getZakatChgCV() {
		return zakatChgCV;
	}

	public BigDecimal getZakatChgFC() {
		return zakatChgFC;
	}

	public void setZakatCV(BigDecimal zakatCV) {
		this.zakatCV = zakatCV;
	}

	public void setZakatFC(BigDecimal zakatFC) {
		this.zakatFC = zakatFC;
	}

	public void setZakatChgCV(BigDecimal zakatChgCV) {
		this.zakatChgCV = zakatChgCV;
	}

	public void setZakatChgFC(BigDecimal zakatChgFC) {
		this.zakatChgFC = zakatChgFC;
	}

	public String getRelatedGl() {
		return relatedGl;
	}

	public String getFullBreakDeposit() {
		return fullBreakDeposit;
	}

	public void setRelatedGl(String relatedGl) {
		this.relatedGl = relatedGl;
	}

	public void setFullBreakDeposit(String fullBreakDeposit) {
		this.fullBreakDeposit = fullBreakDeposit;
	}

	public CTSTRS_BREAK_DEPVO getCtstrsBreakOfDeposit() {
		return ctstrsBreakOfDeposit;
	}

	public void setCtstrsBreakOfDeposit(CTSTRS_BREAK_DEPVO ctstrsBreakOfDeposit) {
		this.ctstrsBreakOfDeposit = ctstrsBreakOfDeposit;
	}

	public AMFVO getAmfVO() {
		return amfVO;
	}

	public void setAmfVO(AMFVO amfVO) {
		this.amfVO = amfVO;
	}

	public String getMORE_BENEF_DESC_CITY() {
		return MORE_BENEF_DESC_CITY;
	}

	public void setMORE_BENEF_DESC_CITY(String mOREBENEFDESCCITY) {
		MORE_BENEF_DESC_CITY = mOREBENEFDESCCITY;
	}

	public CTSTRS_BENEF_DETVO getCtsTrsBenefDetVO() {
		return ctsTrsBenefDetVO;
	}

	public void setCtsTrsBenefDetVO(CTSTRS_BENEF_DETVO ctsTrsBenefDetVO) {
		this.ctsTrsBenefDetVO = ctsTrsBenefDetVO;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public AMFVO getIstrInvAcc() {
		return istrInvAcc;
	}

	public AMFVO getIstrToAcc() {
		return istrToAcc;
	}

	public void setIstrInvAcc(AMFVO istrInvAcc) {
		this.istrInvAcc = istrInvAcc;
	}

	public void setIstrToAcc(AMFVO istrToAcc) {
		this.istrToAcc = istrToAcc;
	}

	
 }
