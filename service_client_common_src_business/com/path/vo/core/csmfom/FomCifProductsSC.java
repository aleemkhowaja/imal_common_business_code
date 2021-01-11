package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomCifProductsSC extends GridParamsSC
{
    private BigDecimal cifNo;
    private BigDecimal lineNo;
    private String language;
    private String flag;
    private BigDecimal cifTypeCode;
    private BigDecimal cifCode;
    private BigDecimal currency_code;
    private BigDecimal gl_code;
    private BigDecimal sl_no;
    private BigDecimal CHEQUE_TYPE;
    private BigDecimal BILLS_TYPE;
    private String status;
    private String ivCrud;
    private String cifType;
    private boolean updatePassbook;
    private boolean updateBills;
    private String queryflag;
    private String cifStatus;

    private Integer noOfCifProducts;
    private String briefName;
    private String briefNameArab;
    private String longName;
    private String longNameArab;

    private BigDecimal baseCurrencyCode;

    private String issueChqbkState;
    private String issueBillsState;
    private String issueCardState;
    private String issuePassBookState;
    
    private String cifProductCifName;
    private String cifProductShortNameEng;
    private String cifProductShortNameArab;
    private String cifProductLongNameEng;
    private String cifProductLongNameArab;
    
    private String screenSrc;
    private BigDecimal compCodeCif;

    
    public BigDecimal getCHEQUE_TYPE()
    {
	return CHEQUE_TYPE;
    }

    public void setCHEQUE_TYPE(BigDecimal cHEQUETYPE)
    {
	CHEQUE_TYPE = cHEQUETYPE;
    }

    public BigDecimal getCurrency_code()
    {
	return currency_code;
    }

    public void setCurrency_code(BigDecimal currencyCode)
    {
	currency_code = currencyCode;
    }

    public BigDecimal getGl_code()
    {
	return gl_code;
    }

    public void setGl_code(BigDecimal glCode)
    {
	gl_code = glCode;
    }

    public BigDecimal getSl_no()
    {
	return sl_no;
    }

    public void setSl_no(BigDecimal slNo)
    {
	sl_no = slNo;
    }

    public String getQueryflag()
    {
	return queryflag;
    }

    public void setQueryflag(String queryflag)
    {
	this.queryflag = queryflag;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public String getFlag()
    {
	return flag;
    }

    public void setFlag(String flag)
    {
	this.flag = flag;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
	return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
	this.status = status;
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
     * @return the updatePassbook
     */
    public boolean isUpdatePassbook()
    {
	return updatePassbook;
    }

    /**
     * @param updatePassbook the updatePassbook to set
     */
    public void setUpdatePassbook(boolean updatePassbook)
    {
	this.updatePassbook = updatePassbook;
    }

    /**
     * @return the noOfCifProducts
     */
    public Integer getNoOfCifProducts()
    {
	return noOfCifProducts;
    }

    /**
     * @param noOfCifProducts the noOfCifProducts to set
     */
    public void setNoOfCifProducts(Integer noOfCifProducts)
    {
	this.noOfCifProducts = noOfCifProducts;
    }

    /**
     * @return the briefName
     */
    public String getBriefName()
    {
	return briefName;
    }

    /**
     * @param briefName the briefName to set
     */
    public void setBriefName(String briefName)
    {
	this.briefName = briefName;
    }

    /**
     * @return the briefNameArab
     */
    public String getBriefNameArab()
    {
	return briefNameArab;
    }

    /**
     * @param briefNameArab the briefNameArab to set
     */
    public void setBriefNameArab(String briefNameArab)
    {
	this.briefNameArab = briefNameArab;
    }

    /**
     * @return the longName
     */
    public String getLongName()
    {
	return longName;
    }

    /**
     * @param longName the longName to set
     */
    public void setLongName(String longName)
    {
	this.longName = longName;
    }

    /**
     * @return the longNameArab
     */
    public String getLongNameArab()
    {
	return longNameArab;
    }

    /**
     * @param longNameArab the longNameArab to set
     */
    public void setLongNameArab(String longNameArab)
    {
	this.longNameArab = longNameArab;
    }

    /**
     * @return the baseCurrencyCode
     */
    @Override
    public BigDecimal getBaseCurrencyCode()
    {
	return baseCurrencyCode;
    }

    /**
     * @param baseCurrencyCode the baseCurrencyCode to set
     */
    @Override
    public void setBaseCurrencyCode(BigDecimal baseCurrencyCode)
    {
	this.baseCurrencyCode = baseCurrencyCode;
    }

    /**
     * @return the issueChqbkState
     */
    public String getIssueChqbkState()
    {
	return issueChqbkState;
    }

    /**
     * @param issueChqbkState the issueChqbkState to set
     */
    public void setIssueChqbkState(String issueChqbkState)
    {
	this.issueChqbkState = issueChqbkState;
    }

    /**
     * @return the issueCardState
     */
    public String getIssueCardState()
    {
	return issueCardState;
    }

    /**
     * @param issueCardState the issueCardState to set
     */
    public void setIssueCardState(String issueCardState)
    {
	this.issueCardState = issueCardState;
    }

    /**
     * @return the issuePassBookState
     */
    public String getIssuePassBookState()
    {
	return issuePassBookState;
    }

    /**
     * @param issuePassBookState the issuePassBookState to set
     */
    public void setIssuePassBookState(String issuePassBookState)
    {
	this.issuePassBookState = issuePassBookState;
    }

    public String getCifProductCifName()
    {
        return cifProductCifName;
    }

    public void setCifProductCifName(String cifProductCifName)
    {
        this.cifProductCifName = cifProductCifName;
    }

    public String getCifProductShortNameEng()
    {
        return cifProductShortNameEng;
    }

    public void setCifProductShortNameEng(String cifProductShortNameEng)
    {
        this.cifProductShortNameEng = cifProductShortNameEng;
    }

    public String getCifProductShortNameArab()
    {
        return cifProductShortNameArab;
    }

    public void setCifProductShortNameArab(String cifProductShortNameArab)
    {
        this.cifProductShortNameArab = cifProductShortNameArab;
    }

    public String getCifProductLongNameEng()
    {
        return cifProductLongNameEng;
    }

    public void setCifProductLongNameEng(String cifProductLongNameEng)
    {
        this.cifProductLongNameEng = cifProductLongNameEng;
    }

    public String getCifProductLongNameArab()
    {
        return cifProductLongNameArab;
    }

    public void setCifProductLongNameArab(String cifProductLongNameArab)
    {
        this.cifProductLongNameArab = cifProductLongNameArab;
    }

    public String getScreenSrc()
    {
        return screenSrc;
    }

    public void setScreenSrc(String screenSrc)
    {
        this.screenSrc = screenSrc;
    }

    /**
     * @return the cifType
     */
    public String getCifType()
    {
        return cifType;
    }

    /**
     * @param cifType the cifType to set
     */
    public void setCifType(String cifType)
    {
        this.cifType = cifType;
    }

    /**
     * @return the cifCode
     */
    public BigDecimal getCifCode()
    {
        return cifCode;
    }

    /**
     * @param cifCode the cifCode to set
     */
    public void setCifCode(BigDecimal cifCode)
    {
        this.cifCode = cifCode;
    }

    /**
     * @return the cifStatus
     */
    public String getCifStatus()
    {
        return cifStatus;
    }

    /**
     * @param cifStatus the cifStatus to set
     */
    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

    public BigDecimal getBILLS_TYPE()
    {
	return BILLS_TYPE;
    }

    public void setBILLS_TYPE(BigDecimal bILLS_TYPE)
    {
        BILLS_TYPE = bILLS_TYPE;
    }

    public String getIssueBillsState()
    {
        return issueBillsState;
    }

    public void setIssueBillsState(String issueBillsState)
    {
        this.issueBillsState = issueBillsState;
    }
    
    public boolean isUpdateBills()
    {
        return updateBills;
    }

    public void setUpdateBills(boolean updateBills)
    {
        this.updateBills = updateBills;
    } 
    
}