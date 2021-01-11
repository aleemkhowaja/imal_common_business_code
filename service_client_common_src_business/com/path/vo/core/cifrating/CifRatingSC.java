package com.path.vo.core.cifrating;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class CifRatingSC extends GridParamsSC
{
    private BigDecimal cifRatingCode;
    private String language;
    private BigDecimal cifNo;
    private BigDecimal compCodeCif;

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getCifRatingCode()
    {
	return cifRatingCode;
    }

    public void setCifRatingCode(BigDecimal cifRatingCode)
    {
	this.cifRatingCode = cifRatingCode;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

}
