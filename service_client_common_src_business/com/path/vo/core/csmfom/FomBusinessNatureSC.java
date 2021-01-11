package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

 public class FomBusinessNatureSC extends  GridParamsSC
 {
	private BigDecimal cifNo;
	private BigDecimal lineNo;
	private String language;
	private BigDecimal cifType;
	private BigDecimal compCodeCif;

	public BigDecimal getLineNo()
	{
		return lineNo;
	}

	public void setLineNo(BigDecimal lineNo)
	{
		this.lineNo = lineNo;
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

	public BigDecimal getCifType()
	{
	    return cifType;
	}

	public void setCifType(BigDecimal cifType)
	{
	    this.cifType = cifType;
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