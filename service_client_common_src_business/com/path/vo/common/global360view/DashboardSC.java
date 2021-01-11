/**
 * 
 */
package com.path.vo.common.global360view;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: marwanmaddah
 * 
 *          DashboardSC.java used to
 */
public class DashboardSC extends GridParamsSC
{
    private String langCode;
    private BigDecimal lovType;
    private BigDecimal rmitStatusLov;
    private BigDecimal appForlovType;
    private String appName;
    private String progRef;
    private String ivCrud;
    private BigDecimal accBr;// branch code for account
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private BigDecimal cif_no;
    private BigDecimal slNo;
    private String accNum;
    private String addRef;
    private BigDecimal facilityCode;
    private BigDecimal loginTypeByBr;
    private String assestsOrLiab;
    private BigDecimal lovPeriodicity;
    private String lcType;
    private BigDecimal errorCode;
    private String errorMessage;
    private BigDecimal lovTypePrimSupp;
    private List<String> privilegesToCheck;
    private BigDecimal portfolioSeq;
    private String prtflPosSummaryOption = "1";
    private Date fromDate;
    private String securityName;
    private BigDecimal securityCode1;
    private BigDecimal securityCode2;
    private String curName;
    private String asOfDateStr;
    private String callSource;
    
    private String maskedCardNo;
    

    /**
     * used in SafeboxesListAction
     */
    private String language;

    private BigDecimal paymentModeLovType;
    private BigDecimal duesStatusLovType;
    private BigDecimal duesTypeLovType;
    
    private BigDecimal dueCode;
    private String action;
    private String dueStatus;
    private Date asOfDate;

    private String portfolioBaseCy;
    private String portfolioName;
    private BigDecimal tellerCode;
    
    private BigDecimal loginBranchCode;
    
    private String allowCifCreationMaskYN;
    
    // added by nancy - 01/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    private String colname;
    // end nancy 
    
    //added by abbas for Bug#623864
    private BigDecimal consolCy; 

    private BigDecimal frAcBr;
    private BigDecimal frAcCy;
    private BigDecimal frAcGl;
    private BigDecimal frAcCif;
    private BigDecimal frAcSl;
    private BigDecimal toAcBr;
    private BigDecimal toAcCy;
    private BigDecimal toAcGl;
    private BigDecimal toAcCif;
    private BigDecimal toAcSl;
    
    private BigDecimal restrBranchCode;
    
    private BigDecimal lineNbr;
    private BigDecimal showFullySettledDD;
    private String originalProgRef;
    private BigDecimal cifNo;
    private String hideInternalAccount;

    private BigDecimal trsStatusLovType;
    
    private String trsStatus;
    
    private String parentCif;
    
    // DBU191081 Muhammed Anas Start
    private String showCumulativeDataOfParentCifYN;
    // DBU191081 Muhammed Anas End

    
    /**
     * @return the langCode
     */
    public String getLangCode()
    {
	return langCode;
    }

    /**
     * @param langCode the langCode to set
     */
    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    /**
     * @return the appName
     */
    public String getAppName()
    {
	return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
	return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    /**
     * @return the ivCrud
     */
    public String getIvCrud()
    {
	return ivCrud;
    }

    /**
     * @param ivCrud the ivCrud to set
     */
    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    /**
     * @return the lovType
     */
    public BigDecimal getLovType()
    {
	return lovType;
    }

    /**
     * @param lovType the lovType to set
     */
    public void setLovType(BigDecimal lovType)
    {
	this.lovType = lovType;
    }

    /**
     * @return the cif_no
     */
    public BigDecimal getCif_no()
    {
	return cif_no;
    }

    /**
     * @param cifNo the cif_no to set
     */
    public void setCif_no(BigDecimal cifNo)
    {
	cif_no = cifNo;
    }

    /**
     * @return the language
     */
    public String getLanguage()
    {
	return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language)
    {
	this.language = language;
    }

    /**
     * @return the accNum
     */
    public String getAccNum()
    {
	return accNum;
    }

    /**
     * @param accNum the accNum to set
     */
    public void setAccNum(String accNum)
    {
	this.accNum = accNum;
    }

    /**
     * @return the glCode
     */
    public BigDecimal getGlCode()
    {
	return glCode;
    }

    /**
     * @param glCode the glCode to set
     */
    public void setGlCode(BigDecimal glCode)
    {
	this.glCode = glCode;
    }

    /**
     * @return the currencyCode
     */
    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    /**
     * @return the slNo
     */
    public BigDecimal getSlNo()
    {
	return slNo;
    }

    /**
     * @param slNo the slNo to set
     */
    public void setSlNo(BigDecimal slNo)
    {
	this.slNo = slNo;
    }

    public BigDecimal getFacilityCode()
    {
	return facilityCode;
    }

    public void setFacilityCode(BigDecimal facilityCode)
    {
	this.facilityCode = facilityCode;
    }

    /**
     * @return the assestsOrLiab
     */
    public String getAssestsOrLiab()
    {
	return assestsOrLiab;
    }

    /**
     * @param assestsOrLiab the assestsOrLiab to set
     */
    public void setAssestsOrLiab(String assestsOrLiab)
    {
	this.assestsOrLiab = assestsOrLiab;
    }

    /**
     * @return the loginTypeByBr
     */
    public BigDecimal getLoginTypeByBr()
    {
	return loginTypeByBr;
    }

    /**
     * @param loginTypeByBr the loginTypeByBr to set
     */
    public void setLoginTypeByBr(BigDecimal loginTypeByBr)
    {
	this.loginTypeByBr = loginTypeByBr;
    }

    public BigDecimal getLovPeriodicity()
    {
	return lovPeriodicity;
    }

    public BigDecimal getTellerCode()
    {
        return tellerCode;
    }

    public void setTellerCode(BigDecimal tellerCode)
    {
        this.tellerCode = tellerCode;
    }

    public void setLovPeriodicity(BigDecimal lovPeriodicity)
    {
	this.lovPeriodicity = lovPeriodicity;
    }

    public String getLcType()
    {
	return lcType;
    }

    public void setLcType(String lcType)
    {
	this.lcType = lcType;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    /**
     * @return the lovTypePrimSupp
     */
    public BigDecimal getLovTypePrimSupp()
    {
	return lovTypePrimSupp;
    }

    /**
     * @param lovTypePrimSupp the lovTypePrimSupp to set
     */
    public void setLovTypePrimSupp(BigDecimal lovTypePrimSupp)
    {
	this.lovTypePrimSupp = lovTypePrimSupp;
    }

    /**
     * @return the privilegesToCheck
     */
    public List<String> getPrivilegesToCheck()
    {
	return privilegesToCheck;
    }

    /**
     * @param privilegesToCheck the privilegesToCheck to set
     */
    public void setPrivilegesToCheck(List<String> privilegesToCheck)
    {
	this.privilegesToCheck = privilegesToCheck;
    }

    /**
     * @return the portfolioSeq
     */
    public BigDecimal getPortfolioSeq()
    {
	return portfolioSeq;
    }

    /**
     * @param portfolioSeq the portfolioSeq to set
     */
    public void setPortfolioSeq(BigDecimal portfolioSeq)
    {
	this.portfolioSeq = portfolioSeq;
    }

    public BigDecimal getAppForlovType()
    {
	return appForlovType;
    }

    public void setAppForlovType(BigDecimal appForlovType)
    {
	this.appForlovType = appForlovType;
    }

    public String getPrtflPosSummaryOption()
    {
	return prtflPosSummaryOption;
    }

    public void setPrtflPosSummaryOption(String prtflPosSummaryOption)
    {
	this.prtflPosSummaryOption = prtflPosSummaryOption;
    }

    public Date getFromDate()
    {
	return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    public BigDecimal getSecurityCode1()
    {
	return securityCode1;
    }

    public void setSecurityCode1(BigDecimal securityCode1)
    {
	this.securityCode1 = securityCode1;
    }

    public BigDecimal getSecurityCode2()
    {
	return securityCode2;
    }

    public void setSecurityCode2(BigDecimal securityCode2)
    {
	this.securityCode2 = securityCode2;
    }

    public String getSecurityName()
    {
	return securityName;
    }

    public void setSecurityName(String securityName)
    {
	this.securityName = securityName;
    }

    /**
     * @return the rmitStatusLov
     */
    public BigDecimal getRmitStatusLov()
    {
	return rmitStatusLov;
    }

    /**
     * @param rmitStatusLov the rmitStatusLov to set
     */
    public void setRmitStatusLov(BigDecimal rmitStatusLov)
    {
	this.rmitStatusLov = rmitStatusLov;
    }

    public String getCurName()
    {
	return curName;
    }

    public void setCurName(String curName)
    {
	this.curName = curName;
    }

    /**
     * @return the asOfDateStr
     */
    public String getAsOfDateStr()
    {
	return asOfDateStr;
    }

    /**
     * @param asOfDateStr the asOfDateStr to set
     */
    public void setAsOfDateStr(String asOfDateStr)
    {
	this.asOfDateStr = asOfDateStr;
    }

    /**
     * @return the callSource
     */
    public String getCallSource()
    {
	return callSource;
    }

    /**
     * @param callSource the callSource to set
     */
    public void setCallSource(String callSource)
    {
	this.callSource = callSource;
    }

    public BigDecimal getAccBr()
    {
	return accBr;
    }

    public void setAccBr(BigDecimal accBr)
    {
	this.accBr = accBr;
    }

    public BigDecimal getPaymentModeLovType()
    {
	return paymentModeLovType;
    }

    public void setPaymentModeLovType(BigDecimal paymentModeLovType)
    {
	this.paymentModeLovType = paymentModeLovType;
    }

    public BigDecimal getDuesStatusLovType()
    {
	return duesStatusLovType;
    }

    public void setDuesStatusLovType(BigDecimal duesStatusLovType)
    {
	this.duesStatusLovType = duesStatusLovType;
    }

    public BigDecimal getDueCode()
    {
        return dueCode;
    }

    public void setDueCode(BigDecimal dueCode)
    {
        this.dueCode = dueCode;
    }

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }

    public String getDueStatus()
    {
        return dueStatus;
    }

    public void setDueStatus(String dueStatus)
    {
        this.dueStatus = dueStatus;
    }

    public String getMaskedCardNo()
    {
        return maskedCardNo;
    }

    public void setMaskedCardNo(String maskedCardNo)
    {
        this.maskedCardNo = maskedCardNo;
    }

    public Date getAsOfDate()
    {
        return asOfDate;
    }

    public void setAsOfDate(Date asOfDate)
    {
        this.asOfDate = asOfDate;
    }

    public String getPortfolioBaseCy()
    {
        return portfolioBaseCy;
    }

    public void setPortfolioBaseCy(String portfolioBaseCy)
    {
        this.portfolioBaseCy = portfolioBaseCy;
    }

    public String getPortfolioName()
    {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName)
    {
        this.portfolioName = portfolioName;
    }

    public BigDecimal getDuesTypeLovType()
    {
        return duesTypeLovType;
    }

    public void setDuesTypeLovType(BigDecimal duesTypeLovType)
    {
        this.duesTypeLovType = duesTypeLovType;
    }

    public BigDecimal getLoginBranchCode()
    {
        return loginBranchCode;
    }

    public void setLoginBranchCode(BigDecimal loginBranchCode)
    {
        this.loginBranchCode = loginBranchCode;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

 // added by nancy - 01/02/2018-606672-AMANAUPG170147 - Missing Functionality in 360 Degrees screen
    public String getColname()
    {
        return colname;
    }

    public void setColname(String colname)
    {
        this.colname = colname;
    }
    //end nancy 


    public BigDecimal getConsolCy()
    {
        return consolCy;
    }

    public void setConsolCy(BigDecimal consolCy)
    {
        this.consolCy = consolCy;
        }

    public BigDecimal getFrAcBr()
    {
        return frAcBr;
    }

    public void setFrAcBr(BigDecimal frAcBr)
    {
        this.frAcBr = frAcBr;
    }

    public BigDecimal getFrAcCy()
    {
        return frAcCy;
    }

    public void setFrAcCy(BigDecimal frAcCy)
    {
        this.frAcCy = frAcCy;
    }

    public BigDecimal getFrAcGl()
    {
        return frAcGl;
    }

    public void setFrAcGl(BigDecimal frAcGl)
    {
        this.frAcGl = frAcGl;
    }

    public BigDecimal getFrAcCif()
    {
        return frAcCif;
    }

    public void setFrAcCif(BigDecimal frAcCif)
    {
        this.frAcCif = frAcCif;
    }

    public BigDecimal getFrAcSl()
    {
        return frAcSl;
    }

    public void setFrAcSl(BigDecimal frAcSl)
    {
        this.frAcSl = frAcSl;
    }

    public BigDecimal getToAcBr()
    {
        return toAcBr;
    }

    public void setToAcBr(BigDecimal toAcBr)
    {
        this.toAcBr = toAcBr;
    }

    public BigDecimal getToAcCy()
    {
        return toAcCy;
    }

    public void setToAcCy(BigDecimal toAcCy)
    {
        this.toAcCy = toAcCy;
    }

    public BigDecimal getToAcGl()
    {
        return toAcGl;
    }

    public void setToAcGl(BigDecimal toAcGl)
    {
        this.toAcGl = toAcGl;
    }

    public BigDecimal getToAcCif()
    {
        return toAcCif;
    }

    public void setToAcCif(BigDecimal toAcCif)
    {
        this.toAcCif = toAcCif;
    }

    public BigDecimal getToAcSl()
    {
        return toAcSl;
    }

    public void setToAcSl(BigDecimal toAcSl)
    {
        this.toAcSl = toAcSl;
    }
    
    public BigDecimal getRestrBranchCode()
    {
        return restrBranchCode;
    }

    public void setRestrBranchCode(BigDecimal restrBranchCode)
    {
        this.restrBranchCode = restrBranchCode;
    }

    public String getAddRef()
    {
        return addRef;
    }

    public void setAddRef(String addRef)
    {
        this.addRef = addRef;
    }
    
    public BigDecimal getLineNbr()
    {
	return lineNbr;
    }

    public void setLineNbr(BigDecimal lineNbr)
    {
	this.lineNbr = lineNbr;
    }

    public BigDecimal getShowFullySettledDD()
    {
	return showFullySettledDD;
    }

    public void setShowFullySettledDD(BigDecimal showFullySettledDD)
    {
	this.showFullySettledDD = showFullySettledDD;
    }

    public String getOriginalProgRef()
    {
        return originalProgRef;
    }

    public void setOriginalProgRef(String originalProgRef)
    {
        this.originalProgRef = originalProgRef;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

	public String getHideInternalAccount() {
		return hideInternalAccount;
	}

	public void setHideInternalAccount(String hideInternalAccount) {
		this.hideInternalAccount = hideInternalAccount;
	}

	public BigDecimal getTrsStatusLovType()
	{
	    return trsStatusLovType;
	}

	public void setTrsStatusLovType(BigDecimal trsStatusLovType)
	{
	    this.trsStatusLovType = trsStatusLovType;
	}

	public String getTrsStatus()
	{
	    return trsStatus;
	}

	public void setTrsStatus(String trsStatus)
	{
	    this.trsStatus = trsStatus;
	}
	

	public String getParentCif()
	{
	    return parentCif;
	}

	public void setParentCif(String parentCif)
	{
	    this.parentCif = parentCif;
	}
	    
	public String getShowCumulativeDataOfParentCifYN() {
	    return showCumulativeDataOfParentCifYN;
	 }

	public void setShowCumulativeDataOfParentCifYN(String showCumulativeDataOfParentCifYN) {
	    this.showCumulativeDataOfParentCifYN = showCumulativeDataOfParentCifYN;
	 }
    
}
