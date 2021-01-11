package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

 public class FomBankDetailsSC extends  GridParamsSC
 {
	private BigDecimal cifNo;
	private BigDecimal lineNo;
	private String language;
	private String appName;
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

	public BigDecimal getCompCodeCif()
	{
	    return compCodeCif;
	}

	public void setCompCodeCif(BigDecimal compCodeCif)
	{
	    this.compCodeCif = compCodeCif;
	}
	

	

 }