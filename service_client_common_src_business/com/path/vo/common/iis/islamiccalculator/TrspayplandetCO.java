package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.TRSPAYPLANDETVO;
import com.path.lib.common.util.NumberUtil;

public class TrspayplandetCO extends TRSPAYPLANDETVO implements Serializable, Cloneable
{

    private String normalInstallment;

    private BigDecimal OUTSTANDING_AMOUNT = BigDecimal.ZERO;

    private BigDecimal PROFIT_ON_CHARGES = BigDecimal.ZERO;

    private BigDecimal PROFIT_ON_INSURANCE = BigDecimal.ZERO;

    private BigDecimal CHARGES_EXCLUDE_PROFI_CALC = BigDecimal.ZERO;

    private BigDecimal INSURANCE_EXCLUDE_PROFI_CALC = BigDecimal.ZERO;

    private BigDecimal PUSHDOWN_PROFIT_AFTER_XIRR = BigDecimal.ZERO;

    private BigDecimal SETTLING_AGENCY_FEE_AMT = BigDecimal.ZERO;

    private BigDecimal ROR = BigDecimal.ZERO;

    private BigDecimal USER_DEFINED_AMOUNT = BigDecimal.ZERO;
    
    private BigDecimal  USER_DEFINED_PRFIT_AMOUNT;
    
    private String  excludeRescheduleYn;
    
    private BigDecimal  OVERDUE_INSTLMNT_EXCESS_PRFT;

    private String userDefined;
    private String flexiPaymentYN = ConstantsCommon.NO;

    private BigDecimal PRINCIPLE_AMT = BigDecimal.ZERO;
    private BigDecimal VAT_AND_INSTALLMENT_AMOUNT = BigDecimal.ZERO;

    private BigDecimal scheduleAmtFormat;

    private BigDecimal constantRorFormat;
    private Boolean CC_BALLOON_PAYMENT;
    private String ACC_NAME;
    private String COVERING_ACC_NAME;
    private BigDecimal REMAINING_AMOUNT;
    private String ACTUAL_PAYMENT_TYPE;

    private BigDecimal CAPITAL_AMT_BEFORE_XIRR_DUMMY;
    private BigDecimal CAPITAL_AMT_DUMMY;
    private BigDecimal PRINCIPLE_AMT_DUMMY;
    private BigDecimal PROFIT_AMT_BEFORE_XIRR_DUMMY;
    private BigDecimal PROFIT_AMT_DUMMY;
    private String LINE_STATUS;
    private String deal_status;
    private BigDecimal APPROVED_SETTLMT;
    private BigDecimal ACTIVE_SETTLED;
    private BigDecimal ACTUAL_SETTLED;
    private BigDecimal AMOUNT_RECEIVED_FROM_PARTY;
    private String CHEQUE;
    private BigDecimal ACTUAL_SETTLED_CAPITAL;
    private BigDecimal ACTUAL_SETTLED_PROFIT;
    private BigDecimal ADVANCE_INSURANCE_AMOUNT;
    private BigDecimal INSTALLMENT_AMOUNT;
    private BigDecimal TEMP_LINE_NBR;
    private BigDecimal installmentAmountWithInsurance;
    private String DUE_DATE_ACTION;
    // EWBI160081; Saheer.Naduthodi; 02/03/2017 [Begin]
    private BigDecimal settlChargesInstalment;
    private BigDecimal settlChargesNotInstalment;
    // EWBI160081; Saheer.Naduthodi; 02/03/2017 [End]

    private Date SKIPPED_DATE;
    private BigDecimal TRX_NBR;
    private String CIF_NAME;
    private BigDecimal CY_DECIMAL;
    private String SELECTED_YN;
    // Deepu 421068 ICD160002 13/09/2017
    private BigDecimal profitAmountAgencyFees;

    private BigDecimal advanceInsuranceAmount;
    // SBI170098 ; Saheer.Naduthodi; 29/11/2017 [Begin]
    private BigDecimal totalProfit;
    private BigDecimal totalInstallmentAmount;
    // SBI170098 ; Saheer.Naduthodi; 29/11/2017 [End]

    // BBRUP180520 - BBR14-UAT1 ; d.james; 23/08/2018 [Begin]
    private String account;
    private BigDecimal lineNumber;
    // 714070-BBRUP180640
    private BigDecimal PRINCIPLE_AMT_BEFORE_XIRR = BigDecimal.ZERO;

    private String balloonPaymentDesc;
    private String originalInvoiceNo;
    private String newInvoiceNo;

    private Date REVALUATION_RATE_DATE;

    private String calledFrom;

    // IIAB170200 - ABEI190296 - Modifying Skipping Installments Screen
    private BigDecimal skipChargeCode;
    private BigDecimal skipCharge;
    private String skipChargeYN;
    private BigDecimal CIF_TYPE;
    private BigDecimal CLASS;

    // TP# BAJI200034 Fawas.Kuruvakkottil 10/06/2020
    private BigDecimal incidentalChargeAmount;
    private BigDecimal finalInstallment;
    private BigDecimal advInsVatAmount;
	 private BigDecimal vatChargesAtDealPlan;

    // ABE - AIBB200060- 1031583
    private BigDecimal noOfMonths;
    private BigDecimal amountPlusVat;

    public BigDecimal getProfitAmountAgencyFees()
    {
	return profitAmountAgencyFees;
    }

    public void setProfitAmountAgencyFees(BigDecimal profitAmountAgencyFees)
    {
	this.profitAmountAgencyFees = profitAmountAgencyFees;
    }

    public BigDecimal getTRX_NBR()
    {
	return TRX_NBR;
    }

    public void setTRX_NBR(BigDecimal tRX_NBR)
    {
	TRX_NBR = tRX_NBR;
    }

    public String getCIF_NAME()
    {
	return CIF_NAME;
    }

    public void setCIF_NAME(String cIF_NAME)
    {
	CIF_NAME = cIF_NAME;
    }

    public Date getSKIPPED_DATE()
    {
	return SKIPPED_DATE;
    }

    public void setSKIPPED_DATE(Date sKIPPED_DATE)
    {
	SKIPPED_DATE = sKIPPED_DATE;
    }

    public Object clone() throws CloneNotSupportedException
    {
	return super.clone();
    }

    public BigDecimal getConstantRorFormat()
    {
	return constantRorFormat;
    }

    public void setConstantRorFormat(BigDecimal constantRorFormat)
    {
	this.constantRorFormat = constantRorFormat;
    }

    public BigDecimal getPRINCIPLE_AMT()
    {
	return PRINCIPLE_AMT;
    }

    public void setPRINCIPLE_AMT(BigDecimal pRINCIPLEAMT)
    {
	PRINCIPLE_AMT = pRINCIPLEAMT;
    }

    public String getUserDefined()
    {
	return userDefined;
    }

    public void setUserDefined(String userDefined)
    {
	this.userDefined = userDefined;
    }

    public String getNormalInstallment()
    {
	return normalInstallment;
    }

    public void setNormalInstallment(String normalInstallment)
    {
	this.normalInstallment = normalInstallment;
    }

    public BigDecimal getOUTSTANDING_AMOUNT()
    {
	return OUTSTANDING_AMOUNT;
    }

    public void setOUTSTANDING_AMOUNT(BigDecimal oUTSTANDINGAMOUNT)
    {
	OUTSTANDING_AMOUNT = oUTSTANDINGAMOUNT;
    }

    public BigDecimal getPROFIT_ON_CHARGES()
    {
	return PROFIT_ON_CHARGES;
    }

    public void setPROFIT_ON_CHARGES(BigDecimal pROFITONCHARGES)
    {
	PROFIT_ON_CHARGES = pROFITONCHARGES;
    }

    public BigDecimal getPROFIT_ON_INSURANCE()
    {
	return PROFIT_ON_INSURANCE;
    }

    public void setPROFIT_ON_INSURANCE(BigDecimal pROFITONINSURANCE)
    {
	PROFIT_ON_INSURANCE = pROFITONINSURANCE;
    }

    public BigDecimal getCHARGES_EXCLUDE_PROFI_CALC()
    {
	return CHARGES_EXCLUDE_PROFI_CALC;
    }

    public void setCHARGES_EXCLUDE_PROFI_CALC(BigDecimal cHARGESEXCLUDEPROFICALC)
    {
	CHARGES_EXCLUDE_PROFI_CALC = cHARGESEXCLUDEPROFICALC;
    }

    public BigDecimal getINSURANCE_EXCLUDE_PROFI_CALC()
    {
	return INSURANCE_EXCLUDE_PROFI_CALC;
    }

    public void setINSURANCE_EXCLUDE_PROFI_CALC(BigDecimal iNSURANCEEXCLUDEPROFICALC)
    {
	INSURANCE_EXCLUDE_PROFI_CALC = iNSURANCEEXCLUDEPROFICALC;
    }

    public BigDecimal getPUSHDOWN_PROFIT_AFTER_XIRR()
    {
	return PUSHDOWN_PROFIT_AFTER_XIRR;
    }

    public void setPUSHDOWN_PROFIT_AFTER_XIRR(BigDecimal pUSHDOWNPROFITAFTERXIRR)
    {
	PUSHDOWN_PROFIT_AFTER_XIRR = pUSHDOWNPROFITAFTERXIRR;
    }

    public BigDecimal getROR()
    {
	return ROR;
    }

    public void setROR(BigDecimal rOR)
    {
	ROR = rOR;
    }

    public BigDecimal getUSER_DEFINED_AMOUNT()
    {
	return USER_DEFINED_AMOUNT;
    }

    public void setUSER_DEFINED_AMOUNT(BigDecimal uSERDEFINEDAMOUNT)
    {
	USER_DEFINED_AMOUNT = uSERDEFINEDAMOUNT;
    }

    public BigDecimal getScheduleAmtFormat()
    {
	return scheduleAmtFormat;
    }

    public void setScheduleAmtFormat(BigDecimal scheduleAmtFormat)
    {
	this.scheduleAmtFormat = scheduleAmtFormat;
    }

    public Boolean getCC_BALLOON_PAYMENT()
    {
	return CC_BALLOON_PAYMENT;
    }

    public void setCC_BALLOON_PAYMENT(Boolean cCBALLOONPAYMENT)
    {
	CC_BALLOON_PAYMENT = cCBALLOONPAYMENT;
    }

    public BigDecimal getVAT_AND_INSTALLMENT_AMOUNT()
    {
	return VAT_AND_INSTALLMENT_AMOUNT;
    }

    public void setVAT_AND_INSTALLMENT_AMOUNT(BigDecimal vATANDINSTALLMENTAMOUNT)
    {
	VAT_AND_INSTALLMENT_AMOUNT = vATANDINSTALLMENTAMOUNT;
    }

    public String getACC_NAME()
    {
	return ACC_NAME;
    }

    public void setACC_NAME(String aCCNAME)
    {
	ACC_NAME = aCCNAME;
    }

    public String getCOVERING_ACC_NAME()
    {
	return COVERING_ACC_NAME;
    }

    public void setCOVERING_ACC_NAME(String cOVERINGACCNAME)
    {
	COVERING_ACC_NAME = cOVERINGACCNAME;
    }

    public BigDecimal getREMAINING_AMOUNT()
    {
	return REMAINING_AMOUNT;
    }

    public void setREMAINING_AMOUNT(BigDecimal rEMAININGAMOUNT)
    {
	REMAINING_AMOUNT = rEMAININGAMOUNT;
    }

    public String getACTUAL_PAYMENT_TYPE()
    {
	return ACTUAL_PAYMENT_TYPE;
    }

    public void setACTUAL_PAYMENT_TYPE(String aCTUALPAYMENTTYPE)
    {
	ACTUAL_PAYMENT_TYPE = aCTUALPAYMENTTYPE;
    }

    public BigDecimal getCAPITAL_AMT_BEFORE_XIRR_DUMMY()
    {
	return CAPITAL_AMT_BEFORE_XIRR_DUMMY;
    }

    public void setCAPITAL_AMT_BEFORE_XIRR_DUMMY(BigDecimal cAPITALAMTBEFOREXIRRDUMMY)
    {
	CAPITAL_AMT_BEFORE_XIRR_DUMMY = cAPITALAMTBEFOREXIRRDUMMY;
    }

    public BigDecimal getCAPITAL_AMT_DUMMY()
    {
	return CAPITAL_AMT_DUMMY;
    }

    public void setCAPITAL_AMT_DUMMY(BigDecimal cAPITALAMTDUMMY)
    {
	CAPITAL_AMT_DUMMY = cAPITALAMTDUMMY;
    }

    public BigDecimal getPRINCIPLE_AMT_DUMMY()
    {
	return PRINCIPLE_AMT_DUMMY;
    }

    public void setPRINCIPLE_AMT_DUMMY(BigDecimal pRINCIPLEAMTDUMMY)
    {
	PRINCIPLE_AMT_DUMMY = pRINCIPLEAMTDUMMY;
    }

    public BigDecimal getPROFIT_AMT_BEFORE_XIRR_DUMMY()
    {
	return PROFIT_AMT_BEFORE_XIRR_DUMMY;
    }

    public void setPROFIT_AMT_BEFORE_XIRR_DUMMY(BigDecimal pROFITAMTBEFOREXIRRDUMMY)
    {
	PROFIT_AMT_BEFORE_XIRR_DUMMY = pROFITAMTBEFOREXIRRDUMMY;
    }

    public BigDecimal getPROFIT_AMT_DUMMY()
    {
	return PROFIT_AMT_DUMMY;
    }

    public void setPROFIT_AMT_DUMMY(BigDecimal pROFITAMTDUMMY)
    {
	PROFIT_AMT_DUMMY = pROFITAMTDUMMY;
    }

    public String getLINE_STATUS()
    {
	return LINE_STATUS;
    }

    public void setLINE_STATUS(String lINESTATUS)
    {
	LINE_STATUS = lINESTATUS;
    }

    public BigDecimal getAPPROVED_SETTLMT()
    {
	return APPROVED_SETTLMT;
    }

    public void setAPPROVED_SETTLMT(BigDecimal aPPROVEDSETTLMT)
    {
	APPROVED_SETTLMT = aPPROVEDSETTLMT;
    }

    public BigDecimal getACTIVE_SETTLED()
    {
	return ACTIVE_SETTLED;
    }

    public void setACTIVE_SETTLED(BigDecimal aCTIVESETTLED)
    {
	ACTIVE_SETTLED = aCTIVESETTLED;
    }

    public BigDecimal getACTUAL_SETTLED()
    {
	return ACTUAL_SETTLED;
    }

    public void setACTUAL_SETTLED(BigDecimal aCTUALSETTLED)
    {
	ACTUAL_SETTLED = aCTUALSETTLED;
    }

    public String getDeal_status()
    {
	return deal_status;
    }

    public void setDeal_status(String dealStatus)
    {
	deal_status = dealStatus;
    }

    public BigDecimal getAMOUNT_RECEIVED_FROM_PARTY()
    {
	return AMOUNT_RECEIVED_FROM_PARTY;
    }

    public void setAMOUNT_RECEIVED_FROM_PARTY(BigDecimal aMOUNTRECEIVEDFROMPARTY)
    {
	AMOUNT_RECEIVED_FROM_PARTY = aMOUNTRECEIVEDFROMPARTY;
    }

    public String getCHEQUE()
    {
	return CHEQUE;
    }

    public void setCHEQUE(String cHEQUE)
    {
	CHEQUE = cHEQUE;
    }

    public BigDecimal getACTUAL_SETTLED_CAPITAL()
    {
	return ACTUAL_SETTLED_CAPITAL;
    }

    public void setACTUAL_SETTLED_CAPITAL(BigDecimal aCTUALSETTLEDCAPITAL)
    {
	ACTUAL_SETTLED_CAPITAL = aCTUALSETTLEDCAPITAL;
    }

    public BigDecimal getACTUAL_SETTLED_PROFIT()
    {
	return ACTUAL_SETTLED_PROFIT;
    }

    public void setACTUAL_SETTLED_PROFIT(BigDecimal aCTUALSETTLEDPROFIT)
    {
	ACTUAL_SETTLED_PROFIT = aCTUALSETTLEDPROFIT;
    }

    public BigDecimal getADVANCE_INSURANCE_AMOUNT()
    {
	return ADVANCE_INSURANCE_AMOUNT;
    }

    public void setADVANCE_INSURANCE_AMOUNT(BigDecimal aDVANCEINSURANCEAMOUNT)
    {
	ADVANCE_INSURANCE_AMOUNT = aDVANCEINSURANCEAMOUNT;
    }

    public BigDecimal getINSTALLMENT_AMOUNT()
    {
	return INSTALLMENT_AMOUNT;
    }

    public void setINSTALLMENT_AMOUNT(BigDecimal iNSTALLMENTAMOUNT)
    {
	INSTALLMENT_AMOUNT = iNSTALLMENTAMOUNT;
    }

    public BigDecimal getTEMP_LINE_NBR()
    {
	return TEMP_LINE_NBR;
    }

    public void setTEMP_LINE_NBR(BigDecimal tEMPLINENBR)
    {
	TEMP_LINE_NBR = tEMPLINENBR;
    }

    public BigDecimal getInstallmentAmountWithInsurance()
    {
	return installmentAmountWithInsurance;
    }

    public void setInstallmentAmountWithInsurance(BigDecimal installmentAmountWithInsurance)
    {
	this.installmentAmountWithInsurance = installmentAmountWithInsurance;
    }

    public String getDUE_DATE_ACTION()
    {
	return DUE_DATE_ACTION;
    }

    public void setDUE_DATE_ACTION(String dUEDATEACTION)
    {
	DUE_DATE_ACTION = dUEDATEACTION;
    }

    public BigDecimal getSETTLING_AGENCY_FEE_AMT()
    {
	return SETTLING_AGENCY_FEE_AMT;
    }

    public void setSETTLING_AGENCY_FEE_AMT(BigDecimal sETTLINGAGENCYFEEAMT)
    {
	SETTLING_AGENCY_FEE_AMT = sETTLINGAGENCYFEEAMT;
    }

    public BigDecimal getSettlChargesInstalment()
    {
	return settlChargesInstalment;
    }

    public void setSettlChargesInstalment(BigDecimal settlChargesInstalment)
    {
	this.settlChargesInstalment = settlChargesInstalment;
    }

    public BigDecimal getSettlChargesNotInstalment()
    {
	return settlChargesNotInstalment;
    }

    public void setSettlChargesNotInstalment(BigDecimal settlChargesNotInstalment)
    {
	this.settlChargesNotInstalment = settlChargesNotInstalment;
    }

    /**
     * @return the cY_DECIMAL
     */
    public BigDecimal getCY_DECIMAL()
    {
	return CY_DECIMAL;
    }

    /**
     * @param cY_DECIMAL the cY_DECIMAL to set
     */
    public void setCY_DECIMAL(BigDecimal cY_DECIMAL)
    {
	CY_DECIMAL = cY_DECIMAL;
    }

    /**
     * @return the sELECTED_YN
     */
    public String getSELECTED_YN()
    {
	return SELECTED_YN;
    }

    /**
     * @param sELECTED_YN the sELECTED_YN to set
     */
    public void setSELECTED_YN(String sELECTED_YN)
    {
	SELECTED_YN = sELECTED_YN;
    }

    /**
     * @return the advanceInsuranceAmount
     */
    public BigDecimal getAdvanceInsuranceAmount()
    {
	return advanceInsuranceAmount;
    }

    /**
     * @param advanceInsuranceAmount the advanceInsuranceAmount to set
     */
    public void setAdvanceInsuranceAmount(BigDecimal advanceInsuranceAmount)
    {
	this.advanceInsuranceAmount = advanceInsuranceAmount;
    }

    public BigDecimal getTotalProfit()
    {
	return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit)
    {
	this.totalProfit = totalProfit;
    }

    public BigDecimal getTotalInstallmentAmount()
    {
	return totalInstallmentAmount;
    }

    public void setTotalInstallmentAmount(BigDecimal totalInstallmentAmount)
    {
	this.totalInstallmentAmount = totalInstallmentAmount;
    }

    public String getFlexiPaymentYN()
    {
	return flexiPaymentYN;
    }

    public void setFlexiPaymentYN(String flexiPaymentYN)
    {
	this.flexiPaymentYN = flexiPaymentYN;
    }

    public String getAccount()
    {
	return account;
    }

    public void setAccount(String account)
    {
	this.account = account;
    }

    public BigDecimal getLineNumber()
    {
	return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber)
    {
	this.lineNumber = lineNumber;
    }

    public BigDecimal getPRINCIPLE_AMT_BEFORE_XIRR()
    {
	return PRINCIPLE_AMT_BEFORE_XIRR;
    }

    public void setPRINCIPLE_AMT_BEFORE_XIRR(BigDecimal pRINCIPLE_AMT_BEFORE_XIRR)
    {
	PRINCIPLE_AMT_BEFORE_XIRR = pRINCIPLE_AMT_BEFORE_XIRR;
    }

    public String getBalloonPaymentDesc()
    {
	return balloonPaymentDesc;
    }

    public void setBalloonPaymentDesc(String balloonPaymentDesc)
    {
	this.balloonPaymentDesc = balloonPaymentDesc;
    }

    public String getOriginalInvoiceNo()
    {
	return originalInvoiceNo;
    }

    public void setOriginalInvoiceNo(String originalInvoiceNo)
    {
	this.originalInvoiceNo = originalInvoiceNo;
    }

    public String getNewInvoiceNo()
    {
	return newInvoiceNo;
    }

    public void setNewInvoiceNo(String newInvoiceNo)
    {
	this.newInvoiceNo = newInvoiceNo;
    }

    public Date getREVALUATION_RATE_DATE()
    {
	return REVALUATION_RATE_DATE;
    }

    public void setREVALUATION_RATE_DATE(Date rEVALUATION_RATE_DATE)
    {
	REVALUATION_RATE_DATE = rEVALUATION_RATE_DATE;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public BigDecimal getSkipChargeCode()
    {
	return NumberUtil.emptyDecimalToZero(skipChargeCode);
    }

    public void setSkipChargeCode(BigDecimal skipChargeCode)
    {
	this.skipChargeCode = skipChargeCode;
    }

    public BigDecimal getSkipCharge()
    {
	return NumberUtil.emptyDecimalToZero(skipCharge);
    }

    public void setSkipCharge(BigDecimal skipCharge)
    {
	this.skipCharge = skipCharge;
    }

    public String getSkipChargeYN()
    {
	return skipChargeYN;
    }

    public void setSkipChargeYN(String skipChargeYN)
    {
	this.skipChargeYN = skipChargeYN;
    }

    public BigDecimal getCIF_TYPE()
    {
	return CIF_TYPE;
    }

    public void setCIF_TYPE(BigDecimal cIF_TYPE)
    {
	CIF_TYPE = cIF_TYPE;
    }

    public BigDecimal getCLASS()
    {
	return CLASS;
    }

    public void setCLASS(BigDecimal cLASS)
    {
	CLASS = cLASS;
    }

    
    public BigDecimal getIncidentalChargeAmount()
    {
	return incidentalChargeAmount;
    }

    public void setIncidentalChargeAmount(BigDecimal incidentalChargeAmount)
    {
	this.incidentalChargeAmount = incidentalChargeAmount;
    }

    public BigDecimal getNoOfMonths()
    {
	return noOfMonths;
    }

    public void setNoOfMonths(BigDecimal noOfMonths)
    {
	this.noOfMonths = noOfMonths;
    }

	
    public BigDecimal getFinalInstallment()
     {
	return finalInstallment;
     }
 
    public void setFinalInstallment(BigDecimal finalInstallment)
     {
	this.finalInstallment = finalInstallment;
     }
 
    public BigDecimal getAdvInsVatAmount()
    {
	return advInsVatAmount;
    }

    public void setAdvInsVatAmount(BigDecimal advInsVatAmount)
    {
	this.advInsVatAmount = advInsVatAmount;
    }

	public BigDecimal getUSER_DEFINED_PRFIT_AMOUNT() {
		return USER_DEFINED_PRFIT_AMOUNT;
	}

	public void setUSER_DEFINED_PRFIT_AMOUNT(BigDecimal uSER_DEFINED_PRFIT_AMOUNT) {
		USER_DEFINED_PRFIT_AMOUNT = uSER_DEFINED_PRFIT_AMOUNT;
	}

	public String getExcludeRescheduleYn() {
		return excludeRescheduleYn;
	}

	public void setExcludeRescheduleYn(String excludeRescheduleYn) {
		this.excludeRescheduleYn = excludeRescheduleYn;
	}

	public BigDecimal getOVERDUE_INSTLMNT_EXCESS_PRFT() {
		return OVERDUE_INSTLMNT_EXCESS_PRFT;
	}

	public void setOVERDUE_INSTLMNT_EXCESS_PRFT(BigDecimal oVERDUE_INSTLMNT_EXCESS_PRFT) {
		OVERDUE_INSTLMNT_EXCESS_PRFT = oVERDUE_INSTLMNT_EXCESS_PRFT;
	}

	public BigDecimal getAmountPlusVat()
    {
	return amountPlusVat;
    }
	
    public void setAmountPlusVat(BigDecimal amountPlusVat)
    {
	this.amountPlusVat = amountPlusVat;
    }
	
	public BigDecimal getVatChargesAtDealPlan()
    {
	return vatChargesAtDealPlan;
    }

    public void setVatChargesAtDealPlan(BigDecimal vatChargesAtDealPlan)
    {
	this.vatChargesAtDealPlan = vatChargesAtDealPlan;
    }
	
}
