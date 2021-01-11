package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;
/**
 * 
 * Copyright 2019, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: mariachamieh
 *
 * FOMVATDetailsSC.java used to
 */
public class FOMVATDetailsSC extends GridParamsSC
{
	private BigDecimal cifNo;
	private BigDecimal compCodeCif;
	private BigDecimal lineNo;
	private String preferredLanguage;
	private BigDecimal vatZone;
	private BigDecimal nationCode;
	private String resident;

	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	public BigDecimal getLineNo()
	{
	    return lineNo;
	}
	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}
	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	public void setLineNo(BigDecimal lineNo)
	{
	    this.lineNo = lineNo;
	}
	public String getPreferredLanguage()
	{
	    return preferredLanguage;
	}
	public void setPreferredLanguage(String preferredLanguage)
	{
	    this.preferredLanguage = preferredLanguage;
	}
	public BigDecimal getVatZone()
	{
	    return vatZone;
	}
	public void setVatZone(BigDecimal vatZone)
	{
	    this.vatZone = vatZone;
	}
	public BigDecimal getNationCode()
	{
	    return nationCode;
	}
	public void setNationCode(BigDecimal nationCode)
	{
	    this.nationCode = nationCode;
	}
	public String getResident()
	{
	    return resident;
	}
	public void setResident(String resident)
	{
	    this.resident = resident;
	}

}
