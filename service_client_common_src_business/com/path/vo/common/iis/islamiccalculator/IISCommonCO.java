package com.path.vo.common.iis.islamiccalculator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.TRSPAYPLAN_CRITERIAVO;
import com.path.lib.vo.BaseVO;

public class IISCommonCO extends BaseVO implements Serializable
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal cifNo;
    private String idNo;
    private BigDecimal lineNo;
    private Date runningDate;

    private String status;
    private String value;
    private BigDecimal blackListed;
    private BigDecimal clientStatus;
    private BigDecimal blackListType;
    private String blackListLongNameEng;
    private BigDecimal blackListCodeSource;
    private String blackListLongDescEng;
    private BigDecimal blackListCode;
    private Date startDate;
    private Date maturityDate;
    private Date firstPayDate;
    private Date commencementDate;
    private BigDecimal roundingFactor;
    private BigDecimal paymPeriodNbr;
    private String paymPeriodicity;
    private BigDecimal gracePeriodOption;
    private BigDecimal gracePeriod;
    private BigDecimal classCode;
    private Date valueDate;
    private String gracePeriodicity;
    private BigDecimal tempCode;
    private BigDecimal noOfPayments;
    private List<TRSPAYPLAN_CRITERIAVO> iisPayplanCriteria;
    private String payResAmount;
    private String paymPeriodPos;
    private BigDecimal cifIncome;
    private BigDecimal cifApprovedSalary;
    private BigDecimal cifOtherIncome;
    private BigDecimal productClass;
    private String partyType;
    private BigDecimal currency;

    private BigDecimal baloonPercentage;
    private BigDecimal rosterRegisterCode;
    private BigDecimal rosterCodeyield;
    private BigDecimal rosterCodeModarib;
    private BigDecimal rosterLineno;
    private BigDecimal rosterNoOfPayments;
    private String entityType;
    private String salaryWithBank;
    private BigDecimal rosterEntityCode;
    private BigDecimal rosterDealAmount;
    private BigDecimal orginalYield;
    private BigDecimal vatCode;
    private String ApplyYearHoliday;
    private BigDecimal trCurrency;
    private BigDecimal pfCurrency;
    private Date crossDate;
    private BigDecimal exchangeRateCurrency;
    private Date exchangeDate;
    private Date maximumDateRate;
    private BigDecimal exchageRate;
    private BigDecimal crossRate;
    private BigDecimal daysAfterMaximumPeriod;
    private double dealCyDecimalPoint;
    // 30/06/2013 commited for linchu - start
    private BigDecimal typeCode;

    private String calcShowCifIncomeInd;
    private String accessRestricted;
    // 30/06/2013 commited for linchu - end

    // TP#214078; Ramesh; Date 26/09/2014 [Start]
    private String progRef;
    private String appName;
    // TP#214078; Ramesh; Date 26/09/2014 [End]

    private String crud;

    // TP# 267361;deepu.mohandas 03/02/2015
    private String blackListLongNameArab;
    private String language;

    // TP# BB130052;deepu.mohandas 25/05/2015
    private String allowMultipleClassLimit;
    private BigDecimal dealType;
    private BigDecimal limitCode;

    // Added By Arun for JAIZ modificatin
    private BigDecimal planNbr;
    private BigDecimal planSeq;
    private BigDecimal dealNo;
    private int considerDate;
    private BigDecimal planProfitPartially;
    private BigDecimal settlementAmt;
    private BigDecimal installmentAmt;

    // TP# 222800BM140006 - Limit for Yield Roster in IIS Sreejith
    private String productType;
    private BigDecimal rosterCodeYield;
    private BigDecimal STAFF_YIELD;
    private BigDecimal STAFF_YIELD_MIN;
    private BigDecimal STAFF_YIELD_MAX;
    private BigDecimal YIELD;
    private BigDecimal NON_DOMICILE_YIELD_MIN;
    private BigDecimal NON_DOMICILE_YIELD_MAX;
    private BigDecimal DOMICILE_YIELD;
    private BigDecimal DOMICILE_YIELD_MIN;
    private BigDecimal DOMICILE_YIELD_MAX;
    private String ALLOW_EDIT_YIELD_OUTSIDE_RANGE;
    private String ALLOW_EDIT_DEFAULTED_YIELD;
    private BigDecimal amount;
    private String acPartyType;
    private BigDecimal ptMethod;
    // TP# 222800BM140006 - Limit for Yield Roster in IIS end Sreejith
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [Begin]
    private String calledFrom;
    private LOSmessagesCO losMessagesCO;
    // LOS integration; Saheer.Naduthodi; 13/12/2017 [End]
    private BigDecimal LimitCY;
    private Date settlementDate;
    private String profitUpfront;
    private BigDecimal dealcy;
    
    private BigDecimal accBr;
    private BigDecimal accCy;
    private BigDecimal vatRate;
    private BigDecimal vatMaxRate;
    private BigDecimal vatMinRate;
    
    private BigDecimal errorCode;
    private BigDecimal returnCode;
    private BigDecimal trxNbr;
    private String errorMessage;
    private String errorMessage2;
    private String userId;
    private String restrictionFactor;
    
    public String getBlackListLongNameArab()
    {
	return blackListLongNameArab;
    }

    public void setBlackListLongNameArab(String blackListLongNameArab)
    {
	this.blackListLongNameArab = blackListLongNameArab;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getApplyYearHoliday()
    {
	return ApplyYearHoliday;
    }

    public void setApplyYearHoliday(String applyYearHoliday)
    {
	ApplyYearHoliday = applyYearHoliday;
    }

    public BigDecimal getVatCode()
    {
	return vatCode;
    }

    public void setVatCode(BigDecimal vatCode)
    {
	this.vatCode = vatCode;
    }

    public BigDecimal getBaloonPercentage()
    {
	return baloonPercentage;
    }

    public void setBaloonPercentage(BigDecimal baloonPercentage)
    {
	this.baloonPercentage = baloonPercentage;
    }

    public String getValue()
    {
	return value;
    }

    public void setValue(String value)
    {
	this.value = value;
    }

    public Date getFirstPayDate()
    {
	return firstPayDate;
    }

    public void setFirstPayDate(Date firstPayDate)
    {
	this.firstPayDate = firstPayDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public List<TRSPAYPLAN_CRITERIAVO> getIisPayplanCriteria()
    {
	return iisPayplanCriteria;
    }

    public void setIisPayplanCriteria(List<TRSPAYPLAN_CRITERIAVO> iisPayplanCriteria)
    {
	this.iisPayplanCriteria = iisPayplanCriteria;
    }

    public String getPaymPeriodicity()
    {
	return paymPeriodicity;
    }

    public void setPaymPeriodicity(String paymPeriodicity)
    {
	this.paymPeriodicity = paymPeriodicity;
    }

    public BigDecimal getRoundingFactor()
    {
	return roundingFactor;
    }

    public void setRoundingFactor(BigDecimal roundingFactor)
    {
	this.roundingFactor = roundingFactor;
    }

    public BigDecimal getPaymPeriodNbr()
    {
	return paymPeriodNbr;
    }

    public void setPaymPeriodNbr(BigDecimal paymPeriodNbr)
    {
	this.paymPeriodNbr = paymPeriodNbr;
    }

    public BigDecimal getGracePeriodOption()
    {
	return gracePeriodOption;
    }

    public void setGracePeriodOption(BigDecimal gracePeriodOption)
    {
	this.gracePeriodOption = gracePeriodOption;
    }

    public BigDecimal getGracePeriod()
    {
	return gracePeriod;
    }

    public void setGracePeriod(BigDecimal gracePeriod)
    {
	this.gracePeriod = gracePeriod;
    }

    public String getGracePeriodicity()
    {
	return gracePeriodicity;
    }

    public void setGracePeriodicity(String gracePeriodicity)
    {
	this.gracePeriodicity = gracePeriodicity;
    }

    public BigDecimal getTempCode()
    {
	return tempCode;
    }

    public void setTempCode(BigDecimal tempCode)
    {
	this.tempCode = tempCode;
    }

    public String getPayResAmount()
    {
	return payResAmount;
    }

    public void setPayResAmount(String payResAmount)
    {
	this.payResAmount = payResAmount;
    }

    public String getPaymPeriodPos()
    {
	return paymPeriodPos;
    }

    public void setPaymPeriodPos(String paymPeriodPos)
    {
	this.paymPeriodPos = paymPeriodPos;
    }

    public BigDecimal getNoOfPayments()
    {
	return noOfPayments;
    }

    public void setNoOfPayments(BigDecimal noOfPayments)
    {
	this.noOfPayments = noOfPayments;
    }

    private Integer cifStatus = 0;

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getBlackListed()
    {
	return blackListed;
    }

    public void setBlackListed(BigDecimal blackListed)
    {
	this.blackListed = blackListed;
    }

    public BigDecimal getClientStatus()
    {
	return clientStatus;
    }

    public void setClientStatus(BigDecimal clientStatus)
    {
	this.clientStatus = clientStatus;
    }

    public BigDecimal getBlackListType()
    {
	return blackListType;
    }

    public void setBlackListType(BigDecimal blackListType)
    {
	this.blackListType = blackListType;
    }

    public String getBlackListLongNameEng()
    {
	return blackListLongNameEng;
    }

    public void setBlackListLongNameEng(String blackListLongNameEng)
    {
	this.blackListLongNameEng = blackListLongNameEng;
    }

    public BigDecimal getBlackListCodeSource()
    {
	return blackListCodeSource;
    }

    public void setBlackListCodeSource(BigDecimal blackListCodeSource)
    {
	this.blackListCodeSource = blackListCodeSource;
    }

    public String getBlackListLongDescEng()
    {
	return blackListLongDescEng;
    }

    public void setBlackListLongDescEng(String blackListLongDescEng)
    {
	this.blackListLongDescEng = blackListLongDescEng;
    }

    public BigDecimal getBlackListCode()
    {
	return blackListCode;
    }

    public void setBlackListCode(BigDecimal blackListCode)
    {
	this.blackListCode = blackListCode;
    }

    public Integer getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(Integer cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIdNo()
    {
	return idNo;
    }

    public void setIdNo(String idNo)
    {
	this.idNo = idNo;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getCifIncome()
    {
	return cifIncome;
    }

    public BigDecimal getCifApprovedSalary()
    {
	return cifApprovedSalary;
    }

    public BigDecimal getCifOtherIncome()
    {
	return cifOtherIncome;
    }

    public String getPartyType()
    {
	return partyType;
    }

    public void setPartyType(String partyType)
    {
	this.partyType = partyType;
    }

    public BigDecimal getCurrency()
    {
	return currency;
    }

    public void setCurrency(BigDecimal currency)
    {
	this.currency = currency;
    }

    public BigDecimal getRosterRegisterCode()
    {
	return rosterRegisterCode;
    }

    public void setRosterRegisterCode(BigDecimal rosterRegisterCode)
    {
	this.rosterRegisterCode = rosterRegisterCode;
    }

    public BigDecimal getRosterCodeyield()
    {
	return rosterCodeyield;
    }

    public void setRosterCodeyield(BigDecimal rosterCodeyield)
    {
	this.rosterCodeyield = rosterCodeyield;
    }

    public BigDecimal getRosterCodeModarib()
    {
	return rosterCodeModarib;
    }

    public void setRosterCodeModarib(BigDecimal rosterCodeModarib)
    {
	this.rosterCodeModarib = rosterCodeModarib;
    }

    public BigDecimal getRosterLineno()
    {
	return rosterLineno;
    }

    public void setRosterLineno(BigDecimal lineno)
    {
	this.rosterLineno = lineno;
    }

    public BigDecimal getRosterNoOfPayments()
    {
	return rosterNoOfPayments;
    }

    public void setRosterNoOfPayments(BigDecimal rosterNoOfPayments)
    {
	this.rosterNoOfPayments = rosterNoOfPayments;
    }

    public String getEntityType()
    {
	return entityType;
    }

    public void setEntityType(String entityType)
    {
	this.entityType = entityType;
    }

    public BigDecimal getRosterEntityCode()
    {
	return rosterEntityCode;
    }

    public void setRosterEntityCode(BigDecimal rosterEntityCode)
    {
	this.rosterEntityCode = rosterEntityCode;
    }

    public BigDecimal getRosterDealAmount()
    {
	return rosterDealAmount;
    }

    public void setRosterDealAmount(BigDecimal rosterDealAmount)
    {
	this.rosterDealAmount = rosterDealAmount;
    }

    public String getSalaryWithBank()
    {
	return salaryWithBank;
    }

    public void setSalaryWithBank(String salaryWithBank)
    {
	this.salaryWithBank = salaryWithBank;
    }

    public BigDecimal getOrginalYield()
    {
	return orginalYield;
    }

    public void setOrginalYield(BigDecimal orginalYield)
    {
	this.orginalYield = orginalYield;
    }

    public Date getCommencementDate()
    {
	return commencementDate;
    }

    public void setCommencementDate(Date commencementDate)
    {
	this.commencementDate = commencementDate;
    }

    public void setCifIncome(BigDecimal cifIncome)
    {
	this.cifIncome = cifIncome;
    }

    public void setCifApprovedSalary(BigDecimal cifApprovedSalary)
    {
	this.cifApprovedSalary = cifApprovedSalary;
    }

    public void setCifOtherIncome(BigDecimal cifOtherIncome)
    {
	this.cifOtherIncome = cifOtherIncome;
    }

    public BigDecimal getExchangeRateCurrency()
    {
	return exchangeRateCurrency;
    }

    public void setExchangeRateCurrency(BigDecimal exchangeRateCurrency)
    {
	this.exchangeRateCurrency = exchangeRateCurrency;
    }

    public Date getExchangeDate()
    {
	return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate)
    {
	this.exchangeDate = exchangeDate;
    }

    public Date getMaximumDateRate()
    {
	return maximumDateRate;
    }

    public void setMaximumDateRate(Date maximumDateRate)
    {
	this.maximumDateRate = maximumDateRate;
    }

    public BigDecimal getExchageRate()
    {
	return exchageRate;
    }

    public void setExchageRate(BigDecimal exchageRate)
    {
	this.exchageRate = exchageRate;
    }

    public BigDecimal getTrCurrency()
    {
	return trCurrency;
    }

    public void setTrCurrency(BigDecimal trCurrency)
    {
	this.trCurrency = trCurrency;
    }

    public BigDecimal getPfCurrency()
    {
	return pfCurrency;
    }

    public void setPfCurrency(BigDecimal pfCurrency)
    {
	this.pfCurrency = pfCurrency;
    }

    public Date getCrossDate()
    {
	return crossDate;
    }

    public void setCrossDate(Date crossDate)
    {
	this.crossDate = crossDate;
    }

    public BigDecimal getCrossRate()
    {
	return crossRate;
    }

    public void setCrossRate(BigDecimal crossRate)
    {
	this.crossRate = crossRate;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public Date getStartDate()
    {
	return startDate;
    }

    public void setStartDate(Date startDate)
    {
	this.startDate = startDate;
    }

    public BigDecimal getClassCode()
    {
	return classCode;
    }

    public void setClassCode(BigDecimal classCode)
    {
	this.classCode = classCode;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public BigDecimal getDaysAfterMaximumPeriod()
    {
	return daysAfterMaximumPeriod;
    }

    public void setDaysAfterMaximumPeriod(BigDecimal daysAfterMaximumPeriod)
    {
	this.daysAfterMaximumPeriod = daysAfterMaximumPeriod;
    }

    public double getDealCyDecimalPoint()
    {
	return dealCyDecimalPoint;
    }

    public void setDealCyDecimalPoint(double dealCyDecimalPoint)
    {
	this.dealCyDecimalPoint = dealCyDecimalPoint;
    }

    // 30/06/2013 commited for linchu - start
    public void setCalcShowCifIncomeInd(String calcShowCifIncomeInd)
    {
	this.calcShowCifIncomeInd = calcShowCifIncomeInd;
    }

    public String getCalcShowCifIncomeInd()
    {
	return calcShowCifIncomeInd;
    }

    public void setAccessRestricted(String accessRestricted)
    {
	this.accessRestricted = accessRestricted;
    }

    public String getAccessRestricted()
    {
	return accessRestricted;
    }

    public void setTypeCode(BigDecimal typeCode)
    {
	this.typeCode = typeCode;
    }

    public BigDecimal getTypeCode()
    {
	return typeCode;
    }

    // 30/06/2013 commited for linchu - end
    public String getCrud()
    {
	return crud;
    }

    public void setCrud(String crud)
    {
	this.crud = crud;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getAppName()
    {
	return appName;
    }

    public String getAllowMultipleClassLimit()
    {
	return allowMultipleClassLimit;
    }

    public void setAllowMultipleClassLimit(String allowMultipleClassLimit)
    {
	this.allowMultipleClassLimit = allowMultipleClassLimit;
    }

    public BigDecimal getDealType()
    {
	return dealType;
    }

    public void setDealType(BigDecimal dealType)
    {
	this.dealType = dealType;
    }

    public BigDecimal getLimitCode()
    {
	return limitCode;
    }

    public void setLimitCode(BigDecimal limitCode)
    {
	this.limitCode = limitCode;
    }

    public BigDecimal getPlanNbr()
    {
	return planNbr;
    }

    public void setPlanNbr(BigDecimal planNbr)
    {
	this.planNbr = planNbr;
    }

    public BigDecimal getPlanSeq()
    {
	return planSeq;
    }

    public void setPlanSeq(BigDecimal planSeq)
    {
	this.planSeq = planSeq;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public int getConsiderDate()
    {
	return considerDate;
    }

    public void setConsiderDate(int considerDate)
    {
	this.considerDate = considerDate;
    }

    public BigDecimal getPlanProfitPartially()
    {
	return planProfitPartially;
    }

    public void setPlanProfitPartially(BigDecimal planProfitPartially)
    {
	this.planProfitPartially = planProfitPartially;
    }

    public BigDecimal getSettlementAmt()
    {
	return settlementAmt;
    }

    public void setSettlementAmt(BigDecimal settlementAmt)
    {
	this.settlementAmt = settlementAmt;
    }

    public BigDecimal getInstallmentAmt()
    {
	return installmentAmt;
    }

    public void setInstallmentAmt(BigDecimal installmentAmt)
    {
	this.installmentAmt = installmentAmt;
    }

    public String getProductType()
    {
	return productType;
    }

    public void setProductType(String productType)
    {
	this.productType = productType;
    }

    public BigDecimal getRosterCodeYield()
    {
	return rosterCodeYield;
    }

    public void setRosterCodeYield(BigDecimal rosterCodeYield)
    {
	this.rosterCodeYield = rosterCodeYield;
    }

    public BigDecimal getSTAFF_YIELD()
    {
	return STAFF_YIELD;
    }

    public void setSTAFF_YIELD(BigDecimal sTAFFYIELD)
    {
	STAFF_YIELD = sTAFFYIELD;
    }

    public BigDecimal getSTAFF_YIELD_MIN()
    {
	return STAFF_YIELD_MIN;
    }

    public void setSTAFF_YIELD_MIN(BigDecimal sTAFFYIELDMIN)
    {
	STAFF_YIELD_MIN = sTAFFYIELDMIN;
    }

    public BigDecimal getSTAFF_YIELD_MAX()
    {
	return STAFF_YIELD_MAX;
    }

    public void setSTAFF_YIELD_MAX(BigDecimal sTAFFYIELDMAX)
    {
	STAFF_YIELD_MAX = sTAFFYIELDMAX;
    }

    public BigDecimal getYIELD()
    {
	return YIELD;
    }

    public void setYIELD(BigDecimal yIELD)
    {
	YIELD = yIELD;
    }

    public BigDecimal getNON_DOMICILE_YIELD_MIN()
    {
	return NON_DOMICILE_YIELD_MIN;
    }

    public void setNON_DOMICILE_YIELD_MIN(BigDecimal nONDOMICILEYIELDMIN)
    {
	NON_DOMICILE_YIELD_MIN = nONDOMICILEYIELDMIN;
    }

    public BigDecimal getNON_DOMICILE_YIELD_MAX()
    {
	return NON_DOMICILE_YIELD_MAX;
    }

    public void setNON_DOMICILE_YIELD_MAX(BigDecimal nONDOMICILEYIELDMAX)
    {
	NON_DOMICILE_YIELD_MAX = nONDOMICILEYIELDMAX;
    }

    public BigDecimal getDOMICILE_YIELD()
    {
	return DOMICILE_YIELD;
    }

    public void setDOMICILE_YIELD(BigDecimal dOMICILEYIELD)
    {
	DOMICILE_YIELD = dOMICILEYIELD;
    }

    public BigDecimal getDOMICILE_YIELD_MIN()
    {
	return DOMICILE_YIELD_MIN;
    }

    public void setDOMICILE_YIELD_MIN(BigDecimal dOMICILEYIELDMIN)
    {
	DOMICILE_YIELD_MIN = dOMICILEYIELDMIN;
    }

    public BigDecimal getDOMICILE_YIELD_MAX()
    {
	return DOMICILE_YIELD_MAX;
    }

    public void setDOMICILE_YIELD_MAX(BigDecimal dOMICILEYIELDMAX)
    {
	DOMICILE_YIELD_MAX = dOMICILEYIELDMAX;
    }

    public String getALLOW_EDIT_YIELD_OUTSIDE_RANGE()
    {
	return ALLOW_EDIT_YIELD_OUTSIDE_RANGE;
    }

    public void setALLOW_EDIT_YIELD_OUTSIDE_RANGE(String aLLOWEDITYIELDOUTSIDERANGE)
    {
	ALLOW_EDIT_YIELD_OUTSIDE_RANGE = aLLOWEDITYIELDOUTSIDERANGE;
    }

    public String getALLOW_EDIT_DEFAULTED_YIELD()
    {
	return ALLOW_EDIT_DEFAULTED_YIELD;
    }

    public void setALLOW_EDIT_DEFAULTED_YIELD(String aLLOWEDITDEFAULTEDYIELD)
    {
	ALLOW_EDIT_DEFAULTED_YIELD = aLLOWEDITDEFAULTEDYIELD;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public String getAcPartyType()
    {
	return acPartyType;
    }

    public void setAcPartyType(String acPartyType)
    {
	this.acPartyType = acPartyType;
    }

    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public LOSmessagesCO getLosMessagesCO()
    {
	return losMessagesCO;
    }

    public void setLosMessagesCO(LOSmessagesCO losMessagesCO)
    {
	this.losMessagesCO = losMessagesCO;
    }

    public BigDecimal getPtMethod()
    {
	return ptMethod;
    }

    public void setPtMethod(BigDecimal ptMethod)
    {
	this.ptMethod = ptMethod;
    }

    public BigDecimal getLimitCY()
    {
	return LimitCY;
    }

    public void setLimitCY(BigDecimal limitCY)
    {
	LimitCY = limitCY;
    }

    public Date getSettlementDate()
    {
	return settlementDate;
    }

    public void setSettlementDate(Date settlementDate)
    {
	this.settlementDate = settlementDate;
    }

    public String getProfitUpfront()
    {
	return profitUpfront;
    }

    public void setProfitUpfront(String profitUpfront)
    {
	this.profitUpfront = profitUpfront;
    }

    public BigDecimal getDealcy()
    {
	return dealcy;
    }

    public void setDealcy(BigDecimal dealcy)
    {
	this.dealcy = dealcy;
    }

	public BigDecimal getAccBr() {
		return accBr;
	}

	public void setAccBr(BigDecimal accBr) {
		this.accBr = accBr;
	}

	public BigDecimal getAccCy() {
		return accCy;
	}

	public void setAccCy(BigDecimal accCy) {
		this.accCy = accCy;
	}

	public BigDecimal getVatRate() {
		return vatRate;
	}

	public void setVatRate(BigDecimal vatRate) {
		this.vatRate = vatRate;
	}

	public BigDecimal getVatMaxRate() {
		return vatMaxRate;
	}

	public void setVatMaxRate(BigDecimal vatMaxRate) {
		this.vatMaxRate = vatMaxRate;
	}

	public BigDecimal getVatMinRate() {
		return vatMinRate;
	}

	public void setVatMinRate(BigDecimal vatMinRate) {
		this.vatMinRate = vatMinRate;
	}

	public BigDecimal getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(BigDecimal errorCode) {
		this.errorCode = errorCode;
	}

	public BigDecimal getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(BigDecimal returnCode) {
		this.returnCode = returnCode;
	}

	public BigDecimal getTrxNbr() {
		return trxNbr;
	}

	public void setTrxNbr(BigDecimal trxNbr) {
		this.trxNbr = trxNbr;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage2() {
		return errorMessage2;
	}

	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRestrictionFactor() {
		return restrictionFactor;
	}

	public void setRestrictionFactor(String restrictionFactor) {
		this.restrictionFactor = restrictionFactor;
	}
}
