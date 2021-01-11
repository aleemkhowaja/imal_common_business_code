package com.path.vo.core.salutation;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class SalutationSC  extends GridParamsSC {

	private BigDecimal civilCode;
	private BigDecimal cifTypeCode;
    private BigDecimal cifFlag;
    private String language;
    
	public BigDecimal getCivilCode()
	{
		return civilCode;
	}
	public void setCivilCode(BigDecimal civilCode)
	{
		this.civilCode = civilCode;
	}
	public BigDecimal getCifTypeCode()
	{
		return cifTypeCode;
	}
	public void setCifTypeCode(BigDecimal cifTypeCode)
	{
		this.cifTypeCode = cifTypeCode;
	}
	public BigDecimal getCifFlag()
	{
		return cifFlag;
	}
	public void setCifFlag(BigDecimal cifFlag)
	{
		this.cifFlag = cifFlag;
	}
	public String getLanguage()
	{
		return language;
	}
	public void setLanguage(String language)
	{
		this.language = language;
	}
	
	
}
