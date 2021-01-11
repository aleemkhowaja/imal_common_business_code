/**
 * 
 */
package com.path.vo.core.currency;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author MarwanMaddah
 * 
 */
public class CurrencySC extends GridParamsSC
{
    private String userId;
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private BigDecimal currencyCode;
    private BigDecimal accCyCode;
    private BigDecimal accBrCode;
    private BigDecimal giVersion;
    private String allCurrenciesFlag;
    private String applyAllowedCy;
    private BigDecimal trxType;
    
    private String language;

    public String getUserId()
    {
	return userId;
    }

    public void setUserId(String userId)
    {
	this.userId = userId;
    }

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

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getAccCyCode()
    {
	return accCyCode;
    }

    public void setAccCyCode(BigDecimal accCyCode)
    {
	this.accCyCode = accCyCode;
    }

    public BigDecimal getAccBrCode()
    {
        return accBrCode;
    }

    public void setAccBrCode(BigDecimal accBrCode)
    {
        this.accBrCode = accBrCode;
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

    public String getAllCurrenciesFlag()
    {
	return allCurrenciesFlag;
    }

    public void setAllCurrenciesFlag(String allCurrenciesFlag)
    {
	this.allCurrenciesFlag = allCurrenciesFlag;
    }
    

    public String getApplyAllowedCy()
    {
        return applyAllowedCy;
    }

    public void setApplyAllowedCy(String applyAllowedCy)
    {
        this.applyAllowedCy = applyAllowedCy;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }
    
}
