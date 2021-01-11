package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

 public class FomCifCompanyDetailsSC extends  GridParamsSC
 {
	 private BigDecimal cifNo;
	 private BigDecimal lineNo;
	 private String	    status;
	 private BigDecimal year;
	 private String     langCode;
	 private BigDecimal lovType;
	 private BigDecimal compCodeCif;
	 private BigDecimal month;
	 

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

	public void setLineNo(BigDecimal lineNo)
	{
		this.lineNo = lineNo;
	}

	public void setStatus(String status)
	{
	    this.status = status;
	}

	public String getStatus()
	{
	    return status;
	}

	public void setYear(BigDecimal year)
	{
	    this.year = year;
	}

	public BigDecimal getYear()
	{
	    return year;
	}

	public String getLangCode()
	{
		return langCode;
	}

	public void setLangCode(String langCode)
	{
		this.langCode = langCode;
	}

	public BigDecimal getLovType()
	{
		return lovType;
	}

	public void setLovType(BigDecimal lovType)
	{
		this.lovType = lovType;
	}

	public void setCompCodeCif(BigDecimal compCodeCif) {
		this.compCodeCif = compCodeCif;
	}

	public BigDecimal getCompCodeCif() {
		return compCodeCif;
	}

	public BigDecimal getMonth()
	{
	    return month;
	}

	public void setMonth(BigDecimal month)
	{
	    this.month = month;
	}

	
	

	

 }