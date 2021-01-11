package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomCifContactSC extends GridParamsSC
{
    private BigDecimal cifCode;
    private BigDecimal lineNo;
    private BigDecimal countryId;
    private BigDecimal regionId;

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getCountryId()
    {
	return countryId;
    }

    public void setCountryId(BigDecimal countryId)
    {
	this.countryId = countryId;
    }

    public BigDecimal getRegionId()
    {
	return regionId;
    }

    public void setRegionId(BigDecimal regionId)
    {
	this.regionId = regionId;
    }

}