package com.path.vo.common.fms.limitscommon;

import java.math.BigDecimal;
import java.util.Date;

import com.path.lib.vo.BaseVO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Vysakh.das
 * 
 *          FmsLimitsInputCO.java used to
 */
@SuppressWarnings("serial")
public class FmsLimitsInputCO extends BaseVO
{
    BigDecimal companyCode;
    BigDecimal branchCode;
    BigDecimal cifCode;
    BigDecimal facilityCode;
    BigDecimal drawDowncode;
    BigDecimal dealCode;
    BigDecimal dealAmount;
    BigDecimal dealAmountOld;
    BigDecimal dealYield;
    BigDecimal dealCy;
    BigDecimal dealRate;
    BigDecimal dealUnit;
    String multiDiv;
    String generalType;
    BigDecimal productClass;
    BigDecimal classType;
    Date valueDate;
    Date maturityDate;
    BigDecimal facilityBranch;
    BigDecimal sublimitNumber;
    BigDecimal drawdownBranch;
    BigDecimal paidAmount;
    String dealFlag;
    String drawdownFlag;
    BigDecimal companyAmount;
    BigDecimal clientAmount;
    BigDecimal payplanNumber;
    BigDecimal payplanSequence;
    BigDecimal unutilizedAmount;
    BigDecimal trsNumber;
    String tfaDrawdown;
    String userId;
    Date sysDate;
    BigDecimal errCode;
    String skipValidationYN = "N";
    String language;
	String appName;
	
	String allowExcessOverLimitYN;
	
	public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }
	
	public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }
	
	
    public String getSkipValidationYN()
    {
        return skipValidationYN;
    }

    public void setSkipValidationYN(String skipValidationYN)
    {
        this.skipValidationYN = skipValidationYN;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getGlCode()
    {
	return glCode;
    }

    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    public BigDecimal getSlNbr()
    {
	return slNbr;
    }

    public void setSlNbr(BigDecimal slNbr)
    {
	this.slNbr = slNbr;
    }

    public BigDecimal getOverDraftLimit()
    {
	return overDraftLimit;
    }

    public void setOverDraftLimit(BigDecimal overDraftLimit)
    {
	this.overDraftLimit = overDraftLimit;
    }

    public BigDecimal getFacilitySubLimitNbr()
    {
	return facilitySubLimitNbr;
    }

    public void setFacilitySubLimitNbr(BigDecimal facilitySubLimitNbr)
    {
	this.facilitySubLimitNbr = facilitySubLimitNbr;
    }

    public BigDecimal getYtdFCBal()
    {
	return ytdFCBal;
    }

    public void setYtdFCBal(BigDecimal ytdFCBal)
    {
	this.ytdFCBal = ytdFCBal;
    }

    public BigDecimal getYtdCVBal()
    {
	return ytdCVBal;
    }

    public void setYtdCVBal(BigDecimal ytdCVBal)
    {
	this.ytdCVBal = ytdCVBal;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    String errMsg;
    String dealType;
    String autoDrwdwn;
    String cashFinance;
    String ddDescEng;
    String ddDescArab;
    String tfaDdOrDdPrinted;
    BigDecimal currencyCode;
    BigDecimal glCode;
    BigDecimal slNbr;
    BigDecimal overDraftLimit;
    BigDecimal facilitySubLimitNbr;
    BigDecimal ytdFCBal;
    BigDecimal ytdCVBal;
    String flag;

    public BigDecimal getCompanyCode()
    {
	return companyCode;
    }

    public void setCompanyCode(BigDecimal companyCode)
    {
	this.companyCode = companyCode;
    }

    public BigDecimal getBranchCode()
    {
	return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
	this.branchCode = branchCode;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public BigDecimal getFacilityCode()
    {
	return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
	this.facilityCode = facilityCode;
    }

    public BigDecimal getDrawDowncode()
    {
	return drawDowncode;
    }

    public void setDrawDowncode(BigDecimal drawDowncode)
    {
	this.drawDowncode = drawDowncode;
    }

    public BigDecimal getDealCode()
    {
	return dealCode;
    }

    public void setDealCode(BigDecimal dealCode)
    {
	this.dealCode = dealCode;
    }

    public BigDecimal getDealAmount()
    {
	return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount)
    {
	this.dealAmount = dealAmount;
    }

    public BigDecimal getDealYield()
    {
	return dealYield;
    }

    public void setDealYield(BigDecimal dealYield)
    {
	this.dealYield = dealYield;
    }

    public BigDecimal getDealCy()
    {
	return dealCy;
    }

    public void setDealCy(BigDecimal dealCy)
    {
	this.dealCy = dealCy;
    }

    public BigDecimal getDealRate()
    {
	return dealRate;
    }

    public void setDealRate(BigDecimal dealRate)
    {
	this.dealRate = dealRate;
    }

    public BigDecimal getDealUnit()
    {
	return dealUnit;
    }

    public void setDealUnit(BigDecimal dealUnit)
    {
	this.dealUnit = dealUnit;
    }

    public String getMultiDiv()
    {
	return multiDiv;
    }

    public void setMultiDiv(String multiDiv)
    {
	this.multiDiv = multiDiv;
    }

    public String getGeneralType()
    {
	return generalType;
    }

    public void setGeneralType(String generalType)
    {
	this.generalType = generalType;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public BigDecimal getClassType()
    {
	return classType;
    }

    public void setClassType(BigDecimal classType)
    {
	this.classType = classType;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getMaturityDate()
    {
	return maturityDate;
    }

    public void setMaturityDate(Date maturityDate)
    {
	this.maturityDate = maturityDate;
    }

    public BigDecimal getFacilityBranch()
    {
	return facilityBranch;
    }

    public void setFacilityBranch(BigDecimal facilityBranch)
    {
	this.facilityBranch = facilityBranch;
    }

    public BigDecimal getSublimitNumber()
    {
	return sublimitNumber;
    }

    public void setSublimitNumber(BigDecimal sublimitNumber)
    {
	this.sublimitNumber = sublimitNumber;
    }

    public BigDecimal getDrawdownBranch()
    {
	return drawdownBranch;
    }

    public void setDrawdownBranch(BigDecimal drawdownBranch)
    {
	this.drawdownBranch = drawdownBranch;
    }

    public BigDecimal getPaidAmount()
    {
	return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount)
    {
	this.paidAmount = paidAmount;
    }

    public String getDealFlag()
    {
	return dealFlag;
    }

    public void setDealFlag(String dealFlag)
    {
	this.dealFlag = dealFlag;
    }

    public String getDrawdownFlag()
    {
	return drawdownFlag;
    }

    public void setDrawdownFlag(String drawdownFlag)
    {
	this.drawdownFlag = drawdownFlag;
    }

    public BigDecimal getCompanyAmount()
    {
	return companyAmount;
    }

    public void setCompanyAmount(BigDecimal companyAmount)
    {
	this.companyAmount = companyAmount;
    }

    public BigDecimal getClientAmount()
    {
	return clientAmount;
    }

    public void setClientAmount(BigDecimal clientAmount)
    {
	this.clientAmount = clientAmount;
    }

    public BigDecimal getPayplanNumber()
    {
	return payplanNumber;
    }

    public void setPayplanNumber(BigDecimal payplanNumber)
    {
	this.payplanNumber = payplanNumber;
    }

    public BigDecimal getPayplanSequence()
    {
	return payplanSequence;
    }

    public void setPayplanSequence(BigDecimal payplanSequence)
    {
	this.payplanSequence = payplanSequence;
    }

    public BigDecimal getUnutilizedAmount()
    {
	return unutilizedAmount;
    }

    public void setUnutilizedAmount(BigDecimal unutilizedAmount)
    {
	this.unutilizedAmount = unutilizedAmount;
    }

    public BigDecimal getTrsNumber()
    {
	return trsNumber;
    }

    public void setTrsNumber(BigDecimal trsNumber)
    {
	this.trsNumber = trsNumber;
    }

    public String getTfaDrawdown()
    {
	return tfaDrawdown;
    }

    public void setTfaDrawdown(String tfaDrawdown)
    {
	this.tfaDrawdown = tfaDrawdown;
    }

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

    public Date getSysDate()
    {
	return sysDate;
    }

    public void setSysDate(Date sysDate)
    {
	this.sysDate = sysDate;
    }

    public BigDecimal getErrCode()
    {
	return errCode;
    }

    public void setErrCode(BigDecimal errCode)
    {
	this.errCode = errCode;
    }

    public String getErrMsg()
    {
	return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
	this.errMsg = errMsg;
    }

    public String getDealType()
    {
	return dealType;
    }

    public void setDealType(String dealType)
    {
	this.dealType = dealType;
    }

    public String getAutoDrwdwn()
    {
	return autoDrwdwn;
    }

    public void setAutoDrwdwn(String autoDrwdwn)
    {
	this.autoDrwdwn = autoDrwdwn;
    }

    public String getCashFinance()
    {
	return cashFinance;
    }

    public void setCashFinance(String cashFinance)
    {
	this.cashFinance = cashFinance;
    }

    public String getDdDescEng()
    {
	return ddDescEng;
    }

    public void setDdDescEng(String ddDescEng)
    {
	this.ddDescEng = ddDescEng;
    }

    public String getDdDescArab()
    {
	return ddDescArab;
    }

    public void setDdDescArab(String ddDescArab)
    {
	this.ddDescArab = ddDescArab;
    }

    public String getTfaDdOrDdPrinted()
    {
	return tfaDdOrDdPrinted;
    }

    public void setTfaDdOrDdPrinted(String tfaDdOrDdPrinted)
    {
	this.tfaDdOrDdPrinted = tfaDdOrDdPrinted;
    }

    public BigDecimal getDealAmountOld()
    {
	return dealAmountOld;
    }

    public void setDealAmountOld(BigDecimal dealAmountOld)
    {
	this.dealAmountOld = dealAmountOld;
    }

	public String getAllowExcessOverLimitYN() {
		return allowExcessOverLimitYN;
	}

	public void setAllowExcessOverLimitYN(String allowExcessOverLimitYN) {
		this.allowExcessOverLimitYN = allowExcessOverLimitYN;
	}

}
