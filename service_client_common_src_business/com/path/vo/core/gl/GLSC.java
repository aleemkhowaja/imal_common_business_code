/**
 * 
 */
package com.path.vo.core.gl;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: MarwanMaddah
 * 
 *          GLSC.java used to
 */
public class GLSC extends GridParamsSC
{
    private String userId;
    private BigDecimal currencyCode;
    private BigDecimal glCode;
    private String lang;
    private String balanceSheet;
    private String genLedgerType;
    private BigDecimal compCode;
    private String category;
    private String appName;
    private String allowInternAcc;
    private String bsContra;

    private String GMI_FLAG;
    private String AFFECT_CARD;
    private String affectPassChq;
    private BigDecimal br_code;
    private BigDecimal cifNo;
    private BigDecimal slNo;
    private BigDecimal giVersion;
    /* By HanaaElJazzar for Assets TrxTemplate Screen. */
    private String contraService;
    
    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
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

    public String getLang()
    {
	return lang;
    }

    public void setLang(String lang)
    {
	this.lang = lang;
    }

    public String getBalanceSheet()
    {
	return balanceSheet;
    }

    public void setBalanceSheet(String balanceSheet)
    {
	this.balanceSheet = balanceSheet;
    }

    public String getGenLedgerType()
    {
	return genLedgerType;
    }

    public void setGenLedgerType(String genLedgerType)
    {
	this.genLedgerType = genLedgerType;
    }

    public BigDecimal getCompCode()
    {
	return compCode;
    }

    public String getCategory()
    {
	return category;
    }

    public void setCompCode(BigDecimal compCode)
    {
	this.compCode = compCode;
    }

    public void setCategory(String category)
    {
	this.category = category;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getAllowInternAcc()
    {
	return allowInternAcc;
    }

    public void setAllowInternAcc(String allowInternAcc)
    {
	this.allowInternAcc = allowInternAcc;
    }

    public String getBsContra()
    {
	return bsContra;
    }

    public void setBsContra(String bsContra)
    {
	this.bsContra = bsContra;
    }

    public String getGMI_FLAG()
    {
	return GMI_FLAG;
    }

    public void setGMI_FLAG(String gMIFLAG)
    {
	GMI_FLAG = gMIFLAG;
    }

    public String getAFFECT_CARD()
    {
	return AFFECT_CARD;
    }

    public void setAFFECT_CARD(String aFFECTCARD)
    {
	AFFECT_CARD = aFFECTCARD;
    }

    public BigDecimal getBr_code()
    {
	return br_code;
    }

    public void setBr_code(BigDecimal brCode)
    {
	br_code = brCode;
    }

    public String getAffectPassChq()
    {
	return affectPassChq;
    }

    public void setAffectPassChq(String affectPassChq)
    {
	this.affectPassChq = affectPassChq;
    }

    /**
     * @return the cifNo
     */
    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    /**
     * @param cifNo the cifNo to set
     */
    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
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

    /**
     * @return the giVersion
     */
    public BigDecimal getGiVersion()
    {
	return giVersion;
    }

    /**
     * @param giVersion the giVersion to set
     */
    public void setGiVersion(BigDecimal giVersion)
    {
	this.giVersion = giVersion;
    }

    public String getContraService()
    {
	return contraService;
    }

    public void setContraService(String contraService)
    {
	this.contraService = contraService;
    }

}
